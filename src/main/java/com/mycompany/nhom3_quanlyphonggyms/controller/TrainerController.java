package com.mycompany.nhom3_quanlyphonggyms.controller;

import com.mycompany.nhom3_quanlyphonggyms.entity.Trainer;
import com.mycompany.nhom3_quanlyphonggyms.entity.TrainerXML;
import com.mycompany.nhom3_quanlyphonggyms.utils.FileUtils;
import com.mycompany.nhom3_quanlyphonggyms.view.MainView;
import com.mycompany.nhom3_quanlyphonggyms.view.TrainerView;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TrainerController {
    private MainView mainView;
    private TrainerView view;
    private List<Trainer> trainerList = new ArrayList<>();
    private DefaultTableModel model;

    public TrainerController(TrainerView view, MainView mainView) {
        this.view = view;
        this.mainView = mainView;
        this.model = (DefaultTableModel) view.getTable().getModel();
        addListeners();
        loadData();
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
    }
    
    private void loadData() {
        try {
            TrainerXML wrapper = (TrainerXML) FileUtils.readXMLFile("Trainer.xml", TrainerXML.class);
            if (wrapper != null && wrapper.getTrainerList() != null) {
                trainerList = wrapper.getTrainerList();
                for(Trainer t : trainerList) {
                    model.addRow(new Object[]{t.getId(), t.getName(), t.getExpertise()});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void saveData() {
        TrainerXML wrapper = new TrainerXML();
        wrapper.setTrainerList(trainerList);
        FileUtils.writeXMLtoFile("Trainer.xml", wrapper);
    }

    private void addTrainer() {
        String id = view.getTextFieldID().getText().trim();
        String name = view.getTextFieldName().getText().trim();
        String expertise = view.getTextFieldExpertise().getText().trim();

        if (id.isEmpty() || name.isEmpty() || expertise.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập đầy đủ thông tin.");
            return;
        }

        Trainer trainer = new Trainer(id, name, expertise);
        trainerList.add(trainer);
        model.addRow(new Object[]{id, name, expertise});
        clearForm();
        saveData();
    }

    private void updateTrainer() {
        int row = view.getTable().getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(view, "Hãy chọn một huấn luyện viên để sửa.");
            return;
        }

        String id = view.getTextFieldID().getText().trim();
        String name = view.getTextFieldName().getText().trim();
        String expertise = view.getTextFieldExpertise().getText().trim();

        Trainer trainer = new Trainer(id, name, expertise);
        trainerList.set(row, trainer);

        model.setValueAt(id, row, 0);
        model.setValueAt(name, row, 1);
        model.setValueAt(expertise, row, 2);
        saveData();
        clearForm();
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
    }

    private void searchTrainer() {
        String keyword = view.getTextFieldSearch().getText().trim().toLowerCase();
        model.setRowCount(0);

        for (Trainer t : trainerList) {
            if (t.getId().toLowerCase().contains(keyword) || t.getName().toLowerCase().contains(keyword)) {
                model.addRow(new Object[]{t.getId(), t.getName(), t.getExpertise()});
            }
        }
    }

    private void fillFormFromTable() {
        int row = view.getTable().getSelectedRow();
        if (row >= 0) {
            view.getTextFieldID().setText(model.getValueAt(row, 0).toString());
            view.getTextFieldName().setText(model.getValueAt(row, 1).toString());
            view.getTextFieldExpertise().setText(model.getValueAt(row, 2).toString());
        }
    }

    private void clearForm() {
        view.getTextFieldID().setText("");
        view.getTextFieldName().setText("");
        view.getTextFieldExpertise().setText("");
        view.getTextFieldSearch().setText("");
    }
}
