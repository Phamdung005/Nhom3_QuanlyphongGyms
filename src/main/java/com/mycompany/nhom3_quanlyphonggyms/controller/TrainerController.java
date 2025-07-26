package com.mycompany.nhom3_quanlyphonggyms.controller;

import com.mycompany.nhom3_quanlyphonggyms.entity.ExerciseTypeXML;
import com.mycompany.nhom3_quanlyphonggyms.entity.Trainer;
import com.mycompany.nhom3_quanlyphonggyms.entity.TrainerXML;
import com.mycompany.nhom3_quanlyphonggyms.utils.FileUtils;
import com.mycompany.nhom3_quanlyphonggyms.view.ExerciseTypeView;
import com.mycompany.nhom3_quanlyphonggyms.view.LoginView;
import com.mycompany.nhom3_quanlyphonggyms.view.MainView;
import com.mycompany.nhom3_quanlyphonggyms.view.MemberView;
import com.mycompany.nhom3_quanlyphonggyms.view.RoomView;
import com.mycompany.nhom3_quanlyphonggyms.view.TrainerView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static javax.xml.bind.DatatypeConverter.parseDate;

public class TrainerController {
    private MainView mainView;
    private TrainerView view;
    private List<Trainer> trainerList = new ArrayList<>();
    private DefaultTableModel model;
    private LoginView loginView;
    private MemberView memberView;
    private ExerciseTypeView exerciseTypeView;
    private RoomView roomView;

    public TrainerController(TrainerView view, MainView mainView) {
        this.view = view;
        this.mainView = mainView;
        this.model = (DefaultTableModel) view.getTable().getModel();
        addListeners();
        loadExerciseTypes();
        loadData();
        this.loginView = new LoginView();
        this.memberView = new MemberView();
        this.exerciseTypeView = new ExerciseTypeView();
        this.roomView = new RoomView();
    }

    private void addListeners() {
        view.getBtnAdd().addActionListener(e -> addTrainer());
        view.getBtnUpdate().addActionListener(e -> updateTrainer());
        view.getBtnDelete().addActionListener(e -> deleteTrainer());
        view.getBtnSearch().addActionListener(e -> searchTrainer());
        view.getTable().getSelectionModel().addListSelectionListener(e -> fillFormFromTable());
        view.getBtnBack().addActionListener(e -> {
            view.dispose();
            mainView.setVisible(true);
        });
        view.getBtnChooseExerciseType().addActionListener(e -> {
            ExerciseTypeView etv = new ExerciseTypeView();
            ExerciseTypeController etc = new ExerciseTypeController(etv, mainView);
            view.dispose();
            etv.setVisible(true);
        });
        view.getBtnChooseMember().addActionListener(e -> {
            MemberView mv = new MemberView();
            MemberController mc = new MemberController(mv, mainView);
            view.dispose();
            mv.setVisible(true);
        });
        view.getBtnChooseRoom().addActionListener(e -> {
            RoomView rv = new RoomView();
            RoomController rc = new RoomController(rv, mainView);
            view.dispose();
            rv.setVisible(true);
        });
        view.getBtnDangXuat().addActionListener(e -> {
            LoginView lv = new LoginView();
            LoginController lc = new LoginController(lv);
            view.dispose();
            lv.setVisible(true);
        });
        view.getSortComboBox().addActionListener(e -> sortTrainerList());
    }
    
    private void sortTrainerList() {
        int selectedIndex = view.getSortComboBox().getSelectedIndex();
        
        switch (selectedIndex) {
            case 1:
                trainerList.sort((m1, m2) -> m1.getId().compareToIgnoreCase(m2.getId()));
                break;
            case 2:
                trainerList.sort((m1, m2) -> m2.getId().compareToIgnoreCase(m1.getId()));
                break;
            case 3:
                trainerList.sort(Comparator.comparing(Trainer::getName, String.CASE_INSENSITIVE_ORDER));
                break;
            case 4:
                trainerList.sort((a, b) -> b.getName().compareToIgnoreCase(a.getName()));
                break;
            case 5: 
                trainerList.sort((m1, m2) -> 
                parseDate(m1.getDob()).compareTo(parseDate(m2.getDob()))
                );
                break;
            case 6: 
                trainerList.sort((m1, m2) -> 
                parseDate(m2.getDob()).compareTo(parseDate(m1.getDob()))
                );
                break;
            case 7:
                trainerList.sort(Comparator.comparing(Trainer::getExpertise, String.CASE_INSENSITIVE_ORDER));
                break;
            default:
                return;
        }
        
        refreshTable();
    }
    
    private void updateStatisticsLabel() {
        int total = trainerList.size();
        Map<String, Integer> expertiseCount = new HashMap<>();
        
        for (Trainer t : trainerList) {
            String expertise = t.getExpertise();
            expertiseCount.put(expertise, expertiseCount.getOrDefault(expertise, 0) + 1);
        }
        StringBuilder stats = new StringBuilder();
        stats.append("TỔNG SỐ HUẤN LUYỆN VIÊN: ").append(total).append("\n");
        stats.append("SỐ LƯỢNG THEO CHUYÊN MÔN: \n");
        
        for(Map.Entry<String, Integer> entry : expertiseCount.entrySet()) {
            stats.append(" - ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        
        view.getTxtStats().setText(stats.toString());
        
    }
    
    private LocalDate parseDate(String dob) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            return LocalDate.parse(dob, formatter);
        } catch (Exception e) {
            return LocalDate.MIN; 
        }
    }
    
    private void refreshTable() {
        model.setRowCount(0);
        for(Trainer t : trainerList) {
            model.addRow(new Object[]{t.getId(), t.getName(), t.getExpertise(), t.getPhone(), t.getDob()});
        }
    }

    private void loadData() {
        try {
            TrainerXML wrapper = (TrainerXML) FileUtils.readXMLFile("Trainer.xml", TrainerXML.class);
            if (wrapper != null && wrapper.getTrainerList() != null) {
                trainerList = wrapper.getTrainerList();
                for (Trainer t : trainerList) {
                    model.addRow(new Object[]{t.getId(), t.getName(), t.getExpertise(), t.getPhone(), t.getDob()});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        updateStatisticsLabel();
    }
    private void loadExerciseTypes() {
        ExerciseTypeXML exerciseWrapper = (ExerciseTypeXML) FileUtils.readXMLFile("ExerciseType.xml", ExerciseTypeXML.class);
        if (exerciseWrapper != null && exerciseWrapper.getExerciseTypes() != null) {
            view.setExerciseTypeComboBox(exerciseWrapper.getExerciseTypes());
        }
    }


    private void saveData() {
        TrainerXML wrapper = new TrainerXML();
        wrapper.setTrainerList(trainerList);
        FileUtils.writeXMLtoFile("Trainer.xml", wrapper);
    }

    private void addTrainer() {
        String id = view.getTextFieldID().getText().trim();
        String name = view.getTextFieldName().getText().trim();
        String expertise = view.getTextFieldExpertise().getSelectedItem().toString();
        String phone = view.getTextFieldPhone().getText().trim();
        Date selectedDate = view.getDateChooserDob().getDate();

        if (id.isEmpty() && name.isEmpty() && 
            (expertise == null || expertise.trim().isEmpty()) && 
            phone.isEmpty() && selectedDate == null) {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập đầy đủ thông tin huấn luyện viên.");
            return;
        }

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập mã huấn luyện viên.");
            return;
        }
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập tên huấn luyện viên.");
            return;
        }
        if (expertise == null || expertise.trim().isEmpty() || expertise.equals("-- Chọn chuyên môn --")) {
            JOptionPane.showMessageDialog(view, "Vui lòng chọn chuyên môn.");
            return;
        }
        if (phone.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập số điện thoại.");
            return;
        }
        if (selectedDate == null) {
            JOptionPane.showMessageDialog(view, "Vui lòng chọn ngày sinh.");
            return;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate dobDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String dob = dobDate.format(formatter);

        Trainer trainer = new Trainer(id, name, expertise, phone, dob);
        trainerList.add(trainer);
        model.addRow(new Object[]{id, name, expertise, phone, dob});
        clearForm();
        saveData();
        updateStatisticsLabel();
    }

    private void updateTrainer() {
        int row = view.getTable().getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(view, "Hãy chọn một huấn luyện viên để sửa.");
            return;
        }

        String id = view.getTextFieldID().getText().trim();
        String name = view.getTextFieldName().getText().trim();
        String expertise = view.getTextFieldExpertise().getSelectedItem().toString();
        String phone = view.getTextFieldPhone().getText().trim();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate dobDate = view.getDateChooserDob().getDate()
        .toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        String dob = dobDate.format(formatter);

        Trainer trainer = new Trainer(id, name, expertise, phone, dob);
        trainerList.set(row, trainer);

        model.setValueAt(id, row, 0);
        model.setValueAt(name, row, 1);
        model.setValueAt(expertise, row, 2);
        model.setValueAt(phone, row, 3);
        model.setValueAt(dob, row, 4);

        clearForm();
        saveData();
        updateStatisticsLabel();
    }

    private void deleteTrainer() {
        int row = view.getTable().getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(view, "Hãy chọn huấn luyện viên để xóa.");
            return;
        }

        trainerList.remove(row);
        model.removeRow(row);
        clearForm();
        saveData();
        updateStatisticsLabel();
    }

    private void searchTrainer() {
        String keyword = view.getTextFieldSearch().getText().trim().toLowerCase();
        model.setRowCount(0);
        for (Trainer t : trainerList) {
            if (t.getId().toLowerCase().contains(keyword) || t.getName().toLowerCase().contains(keyword)) {
                model.addRow(new Object[]{t.getId(), t.getName(), t.getExpertise(), t.getPhone(), t.getDob()}); // Fixed
            }
        }
    }

    private void fillFormFromTable() {
        int row = view.getTable().getSelectedRow();
        if (row >= 0) {
            view.getTextFieldID().setText(model.getValueAt(row, 0).toString());
            view.getTextFieldName().setText(model.getValueAt(row, 1).toString());
            view.getTextFieldExpertise().setSelectedItem(model.getValueAt(row, 2).toString());
            view.getTextFieldPhone().setText(model.getValueAt(row, 3).toString());
            try {
            String dobString = model.getValueAt(row, 4).toString();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate dob = LocalDate.parse(dobString, formatter);
            java.util.Date date = java.util.Date.from(dob.atStartOfDay(java.time.ZoneId.systemDefault()).toInstant());
            view.getDateChooserDob().setDate(date);
            } catch (Exception e) {
            e.printStackTrace();
            }
        }
    }

    private void clearForm() {
        view.getTextFieldID().setText("");
        view.getTextFieldName().setText("");
        view.getTextFieldExpertise().setSelectedIndex(0);
        view.getTextFieldPhone().setText("");
        view.getDateChooserDob().setDate(null);
        view.getTextFieldSearch().setText("");
    }
    
    public static int getTrainerCount() {
        TrainerXML wrapper = (TrainerXML) FileUtils.readXMLFile("Trainer.xml", TrainerXML.class);
        if (wrapper != null && wrapper.getTrainerList() != null) {
            return wrapper.getTrainerList().size();
        }
        return 0;
    }
    
}
