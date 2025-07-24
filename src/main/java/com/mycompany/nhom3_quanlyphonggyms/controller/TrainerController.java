package com.mycompany.nhom3_quanlyphonggyms.controller;

import com.mycompany.nhom3_quanlyphonggyms.entity.ExerciseTypeXML;
import com.mycompany.nhom3_quanlyphonggyms.entity.Trainer;
import com.mycompany.nhom3_quanlyphonggyms.entity.TrainerXML;
import com.mycompany.nhom3_quanlyphonggyms.utils.FileUtils;
import com.mycompany.nhom3_quanlyphonggyms.view.MainView;
import com.mycompany.nhom3_quanlyphonggyms.view.TrainerView;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import static javax.xml.bind.DatatypeConverter.parseDate;

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
        loadExerciseTypes();
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
        String phone = view.getTextFieldPhone().getText().trim(); // Fixed
        String dob = view.getTextFieldDob().getText().trim();

        if (id.isEmpty() || name.isEmpty() || expertise.isEmpty() || phone.isEmpty() || dob.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập đầy đủ thông tin.");
            return;
        }

        Trainer trainer = new Trainer(id, name, expertise, phone, dob);
        trainerList.add(trainer);
        model.addRow(new Object[]{id, name, expertise, phone, dob});
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
        String expertise = view.getTextFieldExpertise().getSelectedItem().toString();
        String phone = view.getTextFieldPhone().getText().trim();
        String dob = view.getTextFieldDob().getText().trim();

        Trainer trainer = new Trainer(id, name, expertise, phone, dob);
        trainerList.set(row, trainer);

        model.setValueAt(id, row, 0);
        model.setValueAt(name, row, 1);
        model.setValueAt(expertise, row, 2);
        model.setValueAt(phone, row, 3);
        model.setValueAt(dob, row, 4);

        clearForm();
        saveData();
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
            view.getTextFieldDob().setText(model.getValueAt(row, 4).toString());
        }
    }

    private void clearForm() {
        view.getTextFieldID().setText("");
        view.getTextFieldName().setText("");
        view.getTextFieldExpertise().setSelectedIndex(0);
        view.getTextFieldPhone().setText("");
        view.getTextFieldDob().setText("");
        view.getTextFieldSearch().setText("");
    }
}
