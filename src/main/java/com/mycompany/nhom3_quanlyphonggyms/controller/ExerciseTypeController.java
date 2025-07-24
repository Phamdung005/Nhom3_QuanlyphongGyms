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
import com.mycompany.nhom3_quanlyphonggyms.view.MainView;

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

        loadData();
        showList();
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
}

