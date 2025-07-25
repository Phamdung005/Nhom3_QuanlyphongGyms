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
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public MemberController(MemberView memberView, MainView mainView, List<ExerciseType> exerciseTypes) {
        this.memberView = memberView;
        this.mainView = mainView;
        this.managerMembers = new ManagerMembers();
        this.managerRooms = new ManagerRooms();
        this.managerExerciseTypes = new ManagerExerciseTypes();
        this.managerExerciseTypes.setExerciseTypes(exerciseTypes); // dùng danh sách từ ngoài
        this.managerTrainers = new ManagerTrainers();

        this.memberView.addAddMemberListener(new AddMemberListener());
        this.memberView.addEditMemberListener(new EditMemberListener());
        this.memberView.addDeleteMemberListener(new DeleteMemberListener());
        this.memberView.addSearchMemberListener(new SearchMemberListener());
        this.memberView.addBackButtonListener(new BackButtonListener());
        this.memberView.addTableSelectionListener(new MemberSelectionListener());
        this.memberView.addSortMemberListener(new SortMemberListener());

        loadData();
        updateComboBoxes();
        showMemberList();
    }

    private void loadData() {
    try {
        MemberXML wrapper = (MemberXML) FileUtils.readXMLFile("Member.xml", MemberXML.class);
        if (wrapper != null && wrapper.getMember() != null) {
            managerMembers.setMemberList(wrapper.getMember());
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    try {
        RoomXML roomWrapper = (RoomXML) FileUtils.readXMLFile("Room.xml", RoomXML.class);
        if (roomWrapper != null && roomWrapper.getRoom() != null) {
            managerRooms.setRoomList(roomWrapper.getRoom());
        }

        ExerciseTypeXML etWrapper = (ExerciseTypeXML) FileUtils.readXMLFile("ExerciseType.xml", ExerciseTypeXML.class);
        if (etWrapper != null && etWrapper.getExerciseTypes() != null) {
            managerExerciseTypes.setExerciseTypes(etWrapper.getExerciseTypes());
        }
        
        TrainerXML trainerWrapper = (TrainerXML) FileUtils.readXMLFile("Trainer.xml", TrainerXML.class);
        if(trainerWrapper != null && trainerWrapper.getTrainerList() != null) {
            managerTrainers.setTrainerList(trainerWrapper.getTrainerList());
        }
    } catch (Exception ex) {
        ex.printStackTrace();
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
                if (managerMembers.isMemberIdUnique(member.getId())) {
                    managerMembers.addMember(member);
                    showMemberList();
                    memberView.showMessage("Thêm học viên thành công!");
                    saveData();
                } else {
                    memberView.showMessage("Mã học viên đã tồn tại!");
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
            SortMemberListByIndex(selectedIndex);
            memberView.showMemberList(managerMembers.getMemberList());
        }
        
        private void SortMemberListByIndex (int index) {
            List<Member> list = managerMembers.getMemberList();
            switch (index) {
                case 1:
                    list.sort((m1, m2) -> Integer.compare(Integer.parseInt(m1.getId()), Integer.parseInt(m2.getId())));
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
                case 5:{
                    list.sort((m1, m2) -> m1.getDob().compareToIgnoreCase(m2.getDob()));
                    break;
                }
                case 6:
                    list.sort((m1, m2) -> m2.getDob().compareToIgnoreCase(m1.getDob()));
                    break;

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
}
