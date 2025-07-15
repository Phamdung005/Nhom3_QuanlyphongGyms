package com.mycompany.nhom3_quanlyphonggyms.controller;

import com.mycompany.nhom3_quanlyphonggyms.action.ManagerExerciseTypes;
import com.mycompany.nhom3_quanlyphonggyms.action.ManagerMembers;
import com.mycompany.nhom3_quanlyphonggyms.action.ManagerRooms;
import com.mycompany.nhom3_quanlyphonggyms.entity.*;
import com.mycompany.nhom3_quanlyphonggyms.view.MemberView;
import com.mycompany.nhom3_quanlyphonggyms.view.MainView;
import com.mycompany.nhom3_quanlyphonggyms.utils.FileUtils;

import java.awt.event.*;
import java.util.List;
import java.util.logging.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MemberController {
    private MemberView memberView;
    private MainView mainView;
    private ManagerMembers managerMembers;
    private ManagerRooms managerRooms;
    private ManagerExerciseTypes managerExerciseTypes;

    public MemberController(MemberView memberView, MainView mainView) {
        this.memberView = memberView;
        this.mainView = mainView;
        this.managerMembers = new ManagerMembers();
        this.managerRooms = new ManagerRooms();
        this.managerExerciseTypes = new ManagerExerciseTypes();

        this.memberView.addAddMemberListener(new AddMemberListener());
        this.memberView.addEditMemberListener(new EditMemberListener());
        this.memberView.addDeleteMemberListener(new DeleteMemberListener());
        this.memberView.addSearchMemberListener(new SearchMemberListener());
        this.memberView.addBackButtonListener(new BackButtonListener());
        this.memberView.addTableSelectionListener(new MemberSelectionListener());

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
    }

    private void showMemberList() {
        memberView.showMemberList(managerMembers.getMemberList());
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
}
