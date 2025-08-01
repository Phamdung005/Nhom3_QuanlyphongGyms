package com.mycompany.nhom3_quanlyphonggyms.controller;

import com.mycompany.nhom3_quanlyphonggyms.action.ManagerExerciseTypes;
import com.mycompany.nhom3_quanlyphonggyms.action.ManagerMembers;
import com.mycompany.nhom3_quanlyphonggyms.action.ManagerRooms;
import com.mycompany.nhom3_quanlyphonggyms.action.ManagerTrainers;
import com.mycompany.nhom3_quanlyphonggyms.entity.*;
import com.mycompany.nhom3_quanlyphonggyms.view.MemberView;
import com.mycompany.nhom3_quanlyphonggyms.view.MainView;
import com.mycompany.nhom3_quanlyphonggyms.utils.FileUtils;
import com.mycompany.nhom3_quanlyphonggyms.entity.ExerciseType;
import com.mycompany.nhom3_quanlyphonggyms.view.ExerciseTypeView;
import com.mycompany.nhom3_quanlyphonggyms.view.InvoiceView;
import com.mycompany.nhom3_quanlyphonggyms.view.LoginView;
import com.mycompany.nhom3_quanlyphonggyms.view.RoomView;
import com.mycompany.nhom3_quanlyphonggyms.view.TrainerView;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MemberController {
    private MemberView memberView;
    private MainView mainView;
    private ManagerMembers managerMembers;
    private ManagerRooms managerRooms;
    private ManagerExerciseTypes managerExerciseTypes;
    private ManagerTrainers managerTrainers;
    private RoomView roomView;
    private ExerciseTypeView exerciseTypeView;
    private TrainerView trainerView;
    private LoginView loginView;
    private InvoiceView invoiceView;
    private InvoiceController invoiceController;
    
    public MemberController(MemberView memberView, MainView mainView) {
        this.memberView = memberView;
        this.mainView = mainView;
        this.managerMembers = new ManagerMembers();
        this.managerRooms = new ManagerRooms();
        this.managerExerciseTypes = new ManagerExerciseTypes();
        this.managerTrainers = new ManagerTrainers();
        this.roomView = new RoomView();
        this.loginView = new LoginView();
        this.exerciseTypeView = new ExerciseTypeView();
        this.trainerView = new TrainerView();

        this.memberView.addAddMemberListener(new AddMemberListener());
        this.memberView.addEditMemberListener(new EditMemberListener());
        this.memberView.addDeleteMemberListener(new DeleteMemberListener());
        this.memberView.addSearchMemberListener(new SearchMemberListener());
        this.memberView.addBackButtonListener(new BackButtonListener());
        this.memberView.addTableSelectionListener(new MemberSelectionListener());
        this.memberView.addSortMemberListener(new SortMemberListener());
        this.memberView.addChooseTrainerListener(new ChooseTrainerListener());
        this.memberView.addChooseRoomListener(new ChooseRoomListener());
        this.memberView.addChooseExerciseTypeListener(new ChooseExerciseTypeListener());
        this.memberView.addDangXuatListener(new ButtonDangXuat());
        this.memberView.addChooseInvoiceListener(new ChooseInvoiceListener());
        loadData();
        updateComboBoxes();
        showMemberList();
    }
    class ChooseTrainerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           trainerView = new TrainerView();
           TrainerController trainerController = new TrainerController(trainerView, mainView);
           trainerView.setVisible(true);
           memberView.setVisible(false);
        }
    }
    
    class ChooseRoomListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           roomView = new RoomView();
           RoomController roomController = new RoomController(roomView, mainView);
           roomController.showRoomView();
           memberView.setVisible(false);
        }
    }
    class ChooseExerciseTypeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            exerciseTypeView = new ExerciseTypeView();
            ExerciseTypeController controller = new ExerciseTypeController(exerciseTypeView, mainView);
            exerciseTypeView.setVisible(true);
            memberView.setVisible(false);
        }
    }
    class ButtonDangXuat implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            loginView = new LoginView();
            LoginController controller = new LoginController(loginView);
            loginView.setVisible(true);
            memberView.setVisible(false);
        }
    }

    private void loadData() {
    try {
        // Đọc dữ liệu ExerciseType TRƯỚC
        ExerciseTypeXML etWrapper = (ExerciseTypeXML) FileUtils.readXMLFile("ExerciseType.xml", ExerciseTypeXML.class);
        if (etWrapper != null && etWrapper.getExerciseTypes() != null) {
            managerExerciseTypes.setExerciseTypes(etWrapper.getExerciseTypes());
        }

        // Rồi mới đọc Member
        MemberXML wrapper = (MemberXML) FileUtils.readXMLFile("Member.xml", MemberXML.class);
        if (wrapper != null && wrapper.getMember() != null) {
            List<Member> members = wrapper.getMember();

            // Gán lại ExerciseType đầy đủ
            for (Member m : members) {
                if (m.getExerciseType() != null) {
                    String exId = m.getExerciseType().getId();
                    ExerciseType fullType = managerExerciseTypes.findById(exId);
                    m.setExerciseType(fullType);
                }
            }

            managerMembers.setMemberList(members);
        }

        // Load các dữ liệu còn lại
        RoomXML roomWrapper = (RoomXML) FileUtils.readXMLFile("Room.xml", RoomXML.class);
        if (roomWrapper != null && roomWrapper.getRoom() != null) {
            managerRooms.setRoomList(roomWrapper.getRoom());
        }

        TrainerXML trainerWrapper = (TrainerXML) FileUtils.readXMLFile("Trainer.xml", TrainerXML.class);
        if(trainerWrapper != null && trainerWrapper.getTrainerList() != null) {
            managerTrainers.setTrainerList(trainerWrapper.getTrainerList());
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    updateComboBoxes();
}

    private void saveData() {
        MemberXML wrapper = new MemberXML();
        wrapper.setMember(managerMembers.getMemberList()); 
        FileUtils.writeXMLtoFile("Member.xml", wrapper);
    }

    private void updateComboBoxes() {
        memberView.setRoomComboBox(managerRooms.getRoomList());
        memberView.setExerciseTypeComboBox(managerExerciseTypes.getExerciseTypes());
        memberView.setTrainerComboBox(managerTrainers.getTrainerList());
    }

    private void showMemberList() {
        List<Member> members = managerMembers.getMemberList();
        memberView.showMemberList(members);
        updateStatisticsLabel(members);
    }

    class AddMemberListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Member member = memberView.getMemberInfo();
        if (member != null) {

           
            if (member.getExerciseType() != null) {
                String exId = member.getExerciseType().getId();
                ExerciseType fullType = managerExerciseTypes.findById(exId);
                if (fullType != null) {
                    member.setExerciseType(fullType);
                }
            }

            if (managerMembers.isMemberIdUnique(member.getId())) {
                managerMembers.addMember(member);
                showMemberList();
                memberView.showMessage("Thêm học viên thành công!");
                saveData();
            } else {
                if (managerMembers.isSameInfoExceptExerciseType(member)) {
                    managerMembers.addMember(member);
                    showMemberList();
                    memberView.showMessage("Thêm loại hình mới cho học viên thành công!");
                    saveData();
                } else {
                    memberView.showMessage("Mã học viên đã tồn tại với thông tin khác!");
                }
            }
        }
    }
}

    class EditMemberListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Member member = memberView.getMemberInfo();
            if (member != null) {
                managerMembers.updateMember(member);
                showMemberList();
                memberView.showMessage("Cập nhật học viên thành công!");
                saveData();
            }
        }
    }
    
    

    class DeleteMemberListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Member member = memberView.getMemberInfo();
            if (member != null) {
                managerMembers.deleteMember(member);
                showMemberList();
                memberView.clearForm();
                memberView.showMessage("Xóa học viên thành công!");
                saveData();
            }
        }
    }

    class SearchMemberListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String keyword = memberView.getSearchKeyword();
            List<Member> result = managerMembers.searchByName(keyword);
            if (!result.isEmpty()) {
                memberView.showMemberList(result);
            } else {
                memberView.showMessage("Không tìm thấy học viên!");
            }
        }
    }

    class BackButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            memberView.setVisible(false);
            mainView.setVisible(true);
        }
    }

    class MemberSelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            try {
                memberView.fillFormFromSelectedRow(managerMembers.getMemberList());
            } catch (Exception ex) {
                Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    class SortMemberListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = memberView.getSelectedSortIndex();
            System.out.println("ComboBox chọn: " + selectedIndex);
            SortMemberListByIndex(selectedIndex);
            memberView.showMemberList(managerMembers.getMemberList());
        }
        
        private void SortMemberListByIndex (int index) {
            List<Member> list = managerMembers.getMemberList();
            switch (index) {
                case 1:
                    list.sort((m1, m2) -> m1.getId().compareToIgnoreCase(m2.getId()));
                    break;
                case 2:
                    list.sort((m1, m2) -> m2.getId().compareToIgnoreCase(m1.getId()));
                    break;
                case 3:
                    list.sort((m1, m2) -> m1.getName().compareToIgnoreCase(m2.getName()));
                    break;
                case 4:
                    list.sort((m1, m2) -> m2.getName().compareToIgnoreCase(m1.getName()));
                    break;
                case 5: { 
                    list.sort((m1, m2) -> {
                    Date d1 = m1.getDob();
                    Date d2 = m2.getDob();
                    if (d1 == null && d2 == null) return 0;
                    if (d1 == null) return 1;   
                    if (d2 == null) return -1;  
                    return d1.compareTo(d2);
                    });
                    break;
                }
                case 6: {
                    list.sort((m1, m2) -> {
                    Date d1 = m1.getDob();
                    Date d2 = m2.getDob();
                    if (d1 == null && d2 == null) return 0;
                    if (d1 == null) return 1;
                    if (d2 == null) return -1;
                    return d2.compareTo(d1);
                    });
                    break;
                }

                case 7: 
                    list.sort((m1, m2) -> m1.getExerciseType().getName().compareToIgnoreCase(m2.getExerciseType().getName()));
                    break;
                case 8:
                    list.sort((m1, m2) -> m1.getPhone().compareToIgnoreCase(m2.getPhone()));
                    break;
                default:
                    break;
            }
        }
    }
    
    public void updateStatisticsLabel(List<Member> members) {
        int total = members.size();
        Map<String, Integer> typeCount = new HashMap<>();

        for (Member m : members) {
            String type = (m.getExerciseType() != null) ? m.getExerciseType().getName() : "Không xác định";
            typeCount.put(type, typeCount.getOrDefault(type, 0) + 1);
        }

        StringBuilder stats = new StringBuilder();
        stats.append("TỔNG SỐ HỌC VIÊN: ").append(total).append("\nSỐ LƯỢNG THEO LOẠI HÌNH:\n");

        for (Map.Entry<String, Integer> entry : typeCount.entrySet()) {
            stats.append(" - ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }

        memberView.getStatisticsLabel().setText("<html>" + stats.toString().replaceAll("\n", "<br>") + "</html>");
    }
    
    public static int getMemberCount() {
        MemberXML wrapper = (MemberXML) FileUtils.readXMLFile("Member.xml", MemberXML.class);
        if (wrapper != null && wrapper.getMember() != null) {
            return wrapper.getMember().size();
        }
        return 0;
    }
    public static List<Member> getAll() {
        MemberXML wrapper = (MemberXML) FileUtils.readXMLFile("Member.xml", MemberXML.class);
        if (wrapper != null && wrapper.getMember() != null) {
            return wrapper.getMember();
        }
        return new ArrayList<>();
    }
    class ChooseInvoiceListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ManagerMembers managerMembers = new ManagerMembers();
            invoiceView = new InvoiceView();
            invoiceController = new InvoiceController(invoiceView, managerMembers, mainView);
            invoiceView.setVisible(true);
            memberView.setVisible(false);
        }
    }
        

}
