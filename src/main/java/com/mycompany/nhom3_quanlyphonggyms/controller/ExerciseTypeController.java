/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nhom3_quanlyphonggyms.controller;

import com.mycompany.nhom3_quanlyphonggyms.action.ManagerExerciseTypes;
import com.mycompany.nhom3_quanlyphonggyms.entity.ExerciseType;
import com.mycompany.nhom3_quanlyphonggyms.entity.ExerciseTypeXML;
import com.mycompany.nhom3_quanlyphonggyms.utils.FileUtils;
import com.mycompany.nhom3_quanlyphonggyms.view.ExerciseTypeView;
import com.mycompany.nhom3_quanlyphonggyms.view.LoginView;
import com.mycompany.nhom3_quanlyphonggyms.view.MainView;
import com.mycompany.nhom3_quanlyphonggyms.view.MemberView;
import com.mycompany.nhom3_quanlyphonggyms.view.RoomView;
import com.mycompany.nhom3_quanlyphonggyms.view.TrainerView;

import java.awt.event.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ExerciseTypeController {
    private ExerciseTypeView view;
    private MainView mainView;
    private ManagerExerciseTypes manager;
    private TrainerView trainerView;
    private MemberView memberView;
    private RoomView roomView;
    private LoginView loginView;

    public ExerciseTypeController(ExerciseTypeView view, MainView mainView) {
        this.view = view;
        this.mainView = mainView;
        this.manager = new ManagerExerciseTypes();

        this.view.addAddExerciseTypeListener(new AddListener());
        this.view.addEditExerciseTypeListener(new EditListener());
        this.view.addDeleteExerciseTypeListener(new DeleteListener());
        this.view.addSearchExerciseTypeListener(new SearchListener());
        this.view.addBackButtonListener(new BackListener());
        this.view.addTableSelectionListener(new TableSelectionListener());
        this.view.addChooseMemberListener(new ChooseMemberListener());
        this.view.addChooseTrainerListener(new ChooseTrainerListener());
        this.view.addChooseRoomListener(new ChooseRoomListener());
        this.view.addDangXuatListener(new ButtonDangXuat());

        loadData();
        showList();
    }
    
    class ChooseRoomListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           roomView = new RoomView();
           RoomController roomController = new RoomController(roomView, mainView);
           roomController.showRoomView();
           view.setVisible(false);
        }
    }
    class ChooseMemberListener implements ActionListener {
    @Override
        public void actionPerformed(ActionEvent e) {
            memberView = new MemberView();
            MemberController controller = new MemberController(memberView, mainView);
            memberView.setVisible(true);
            view.setVisible(false);
        }
    }
    class ChooseTrainerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           trainerView = new TrainerView();
           TrainerController trainerController = new TrainerController(trainerView, mainView);
           trainerView.setVisible(true);
           view.setVisible(false);
        }
    }
    class ButtonDangXuat implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            loginView = new LoginView();
            LoginController controller = new LoginController(loginView);
            loginView.setVisible(true);
            view.setVisible(false);
        }
    }

    private void loadData() {
        try {
            ExerciseTypeXML wrapper = (ExerciseTypeXML) FileUtils.readXMLFile("ExerciseType.xml", ExerciseTypeXML.class);
            if (wrapper != null && wrapper.getExerciseTypes() != null) {
                manager.setExerciseTypes(wrapper.getExerciseTypes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveData() {
        ExerciseTypeXML wrapper = new ExerciseTypeXML();
        wrapper.setExerciseTypes(manager.getExerciseTypes());
        FileUtils.writeXMLtoFile("ExerciseType.xml", wrapper);
    }

    private void showList() {
        List<ExerciseType> list = manager.getExerciseTypes();
        view.showExerciseTypeList(list);
        view.showExerciseTypeCount(list.size()); 
    }

    class AddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ExerciseType type = view.getExerciseTypeInfo();
            if (type != null) {
                if (manager.isIdUnique(type.getId())) {
                    manager.addExerciseType(type);
                    showList();
                    view.showMessage("Thêm loại hình thành công!");
                    saveData();
                } else {
                    view.showMessage("ID loại hình đã tồn tại!");
                }
            }
        }
    }

    class EditListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ExerciseType type = view.getExerciseTypeInfo();
            if (type != null) {
                manager.deleteExerciseType(type); // Xóa cũ
                manager.addExerciseType(type);    // Thêm mới
                showList();
                view.showMessage("Cập nhật loại hình thành công!");
                saveData();
            }
        }
    }

    class DeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ExerciseType type = view.getExerciseTypeInfo();
            if (type != null) {
                manager.deleteExerciseType(type);
                showList();
                view.clearForm();
                view.showMessage("Xóa loại hình thành công!");
                saveData();
            }
        }
    }

    class SearchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String keyword = view.getSearchKeyword();
            List<ExerciseType> result = manager.searchByName(keyword);
            if (!result.isEmpty()) {
                view.showExerciseTypeList(result);
            } else {
                view.showMessage("Không tìm thấy loại hình!");
            }
        }
    }

    class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setVisible(false);
            mainView.setVisible(true);
        }
    }

    class TableSelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            try {
                view.fillFormFromSelectedRow(manager.getExerciseTypes());
            } catch (Exception ex) {
                Logger.getLogger(ExerciseTypeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public List<ExerciseType> getExerciseTypeList() {
        return manager.getExerciseTypes(); 
    }
    
    public static int getExerciseTypeCount() {
        ExerciseTypeXML wrapper = (ExerciseTypeXML) FileUtils.readXMLFile("ExerciseType.xml", ExerciseTypeXML.class);
        if (wrapper != null && wrapper.getExerciseTypes() != null) {
            return wrapper.getExerciseTypes().size();
        }
        return 0;
    }
}

