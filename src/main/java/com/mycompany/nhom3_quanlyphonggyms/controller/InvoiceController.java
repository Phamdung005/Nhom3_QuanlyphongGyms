package com.mycompany.nhom3_quanlyphonggyms.controller;

import com.mycompany.nhom3_quanlyphonggyms.action.ManagerMembers;
import com.mycompany.nhom3_quanlyphonggyms.entity.ExerciseType;
import com.mycompany.nhom3_quanlyphonggyms.entity.Member;
import com.mycompany.nhom3_quanlyphonggyms.view.ExerciseTypeView;
import com.mycompany.nhom3_quanlyphonggyms.view.InvoiceView;
import com.mycompany.nhom3_quanlyphonggyms.view.LoginView;
import com.mycompany.nhom3_quanlyphonggyms.view.MainView;
import com.mycompany.nhom3_quanlyphonggyms.view.MemberView;
import com.mycompany.nhom3_quanlyphonggyms.view.RoomView;
import com.mycompany.nhom3_quanlyphonggyms.view.TrainerView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class InvoiceController {
    private InvoiceView invoiceView;
    private ManagerMembers managerMembers;
    private MainView mainView;
    private RoomView roomView;
    private MemberView memberView;
    private TrainerView trainerView;
    private ExerciseTypeView exerciseTypeView;
    private LoginView loginView;
    private List<String> paidMemberIds = new ArrayList<>();

    public InvoiceController(InvoiceView invoiceView, ManagerMembers managerMembers, MainView mainView) {
        this.invoiceView = invoiceView;
        this.managerMembers = managerMembers;
        this.mainView = mainView;
        
        this.invoiceView.addBackButtonListener(new BackButtonListener());
        this.invoiceView.addChooseMemberListener(new ChooseMemberListener());
        this.invoiceView.addChooseTrainerListener(new ChooseTrainerListener());
        this.invoiceView.addChooseRoomListener(new ChooseRoomListener());
        this.invoiceView.addChooseExerciseTypeListener(new ChooseExerciseTypeListener());
        this.invoiceView.addDangXuatListener(new ButtonDangXuat());
        this.invoiceView.getBtnSearch().addActionListener(new SearchFilterSortListener());
        this.invoiceView.getCbPriceFilter().addActionListener(new SearchFilterSortListener());
        this.invoiceView.getCbSortFee().addActionListener(new SearchFilterSortListener());

        loadInvoices();
        invoiceView.getPayButton().addActionListener(new PayButtonListener());
    }
    
    class ChooseTrainerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           trainerView = new TrainerView();
           TrainerController trainerController = new TrainerController(trainerView, mainView);
           trainerView.setVisible(true);
           invoiceView.setVisible(false);
        }
    }
    
    class ChooseRoomListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           roomView = new RoomView();
           RoomController roomController = new RoomController(roomView, mainView);
           roomController.showRoomView();
           invoiceView.setVisible(false);
        }
    }
    class ChooseExerciseTypeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            exerciseTypeView = new ExerciseTypeView();
            ExerciseTypeController controller = new ExerciseTypeController(exerciseTypeView, mainView);
            exerciseTypeView.setVisible(true);
            invoiceView.setVisible(false);
        }
    }
    class BackButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        invoiceView.setVisible(false);
        if (mainView != null) {
            mainView.setVisible(true);
        }
    }
}
    class ChooseMemberListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        memberView = new MemberView();
        MemberController controller = new MemberController(memberView, mainView);
        memberView.setVisible(true);         
        invoiceView.setVisible(false);         
    }
}
    class ButtonDangXuat implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            loginView = new LoginView();
            LoginController controller = new LoginController(loginView);
            invoiceView.setVisible(true);
            loginView.setVisible(false);
        }
    }
    

    public void loadInvoices() {
    Map<String, List<Member>> groupedById = new HashMap<>();

    for (Member m : managerMembers.getMemberList()) {
        groupedById.computeIfAbsent(m.getId(), k -> new ArrayList<>()).add(m);
    }

    List<Object[]> rows = new ArrayList<>();

    String keyword = invoiceView.getTxtSearchName().getText().trim().toLowerCase();
    String priceFilter = invoiceView.getCbPriceFilter().getSelectedItem().toString();
    String sortOption = invoiceView.getCbSortFee().getSelectedItem().toString();

    for (String memberId : groupedById.keySet()) {
        if (paidMemberIds.contains(memberId)) continue;

        List<Member> sameIdMembers = groupedById.get(memberId);
        if (sameIdMembers.isEmpty()) continue;

        Member representative = sameIdMembers.get(0);
        String name = representative.getName();
        String dateCreated = ""; 

        if (!name.toLowerCase().contains(keyword)) continue;

        StringBuilder types = new StringBuilder();
        double total = 0;

        for (Member m : sameIdMembers) {
            ExerciseType type = m.getExerciseType();
            if (type != null) {
                types.append(type.getName()).append(", ");
                total += type.getFee();
            }
        }

        boolean match = switch (priceFilter) {
            case "Dưới 200.000VND" -> total < 200000;
            case "Từ 200.000 - 500.000VND" -> total >= 200000 && total <= 500000;
            case "Trên 500.000VND" -> total > 500000;
            default -> true;
        };
        if (!match) continue;

        if (types.length() > 0) types.setLength(types.length() - 2);

        rows.add(new Object[]{ memberId, name, types.toString(), total });
    }

    // Sắp xếp
    if (sortOption.equals("Giá tăng dần")) {
        rows.sort(Comparator.comparingDouble(r -> (double) r[3]));
    } else if (sortOption.equals("Giá giảm dần")) {
        rows.sort((a, b) -> Double.compare((double) b[3], (double) a[3]));
    }

    DefaultTableModel model = (DefaultTableModel) invoiceView.getInvoiceTable().getModel();
    model.setRowCount(0); // clear

    for (Object[] row : rows) {
        model.addRow(row);
    }
}

    class PayButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JTable table = invoiceView.getInvoiceTable();
            int row = table.getSelectedRow();

            if (row >= 0) {
                String memberId = table.getValueAt(row, 0).toString();

                int confirm = JOptionPane.showConfirmDialog(null,
                        "Xác nhận học viên đã hoàn thành học phí?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    paidMemberIds.add(memberId);
                    loadInvoices(); 
                    invoiceView.showMessage("Đã xác nhận thanh toán cho học viên " + memberId);
                }
            } else {
                invoiceView.showMessage("Vui lòng chọn học viên cần xác nhận thanh toán!");
            }
        }
    }
    class SearchFilterSortListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            loadInvoices(); // dùng dữ liệu lọc/sắp xếp mới
        }
    }
}