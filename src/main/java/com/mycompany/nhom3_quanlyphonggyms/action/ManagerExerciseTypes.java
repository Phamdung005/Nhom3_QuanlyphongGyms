/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nhom3_quanlyphonggyms.action;

import com.mycompany.nhom3_quanlyphonggyms.entity.ExerciseType;
import com.mycompany.nhom3_quanlyphonggyms.entity.ExerciseTypeXML;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class ManagerExerciseTypes {
    private List<ExerciseType> exerciseTypes = new ArrayList<>();
    private static final String DEFAULT_EXERCISE_TYPE_PATH = "exercise_types.xml";
    
    public ManagerExerciseTypes() {
        // Không load ngay, gọi init() sau
    }

    public void init() {
        loadFromFile(DEFAULT_EXERCISE_TYPE_PATH);
    }
    
    public List<ExerciseType> getExerciseTypes() {
        return exerciseTypes;
    }

    public void setExerciseTypes(List<ExerciseType> exerciseTypes) {
        this.exerciseTypes = exerciseTypes;
    }

    public void addExerciseType(ExerciseType type) {
        exerciseTypes.add(type);
    }

    public void deleteExerciseType(ExerciseType type) {
        exerciseTypes.removeIf(t -> t.getId().equals(type.getId()));
    }

    public boolean isIdUnique(String id) {
        return exerciseTypes.stream().noneMatch(t -> t.getId().equalsIgnoreCase(id));
    }

    public List<ExerciseType> searchByName(String keyword) {
        return exerciseTypes.stream()
                .filter(t -> t.getName().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }
    public List<ExerciseType> getAll() {
        return exerciseTypes;
    }
    
    public void loadFromFile(String path) {
        try {
            File file = new File(path);
            JAXBContext context = JAXBContext.newInstance(ExerciseTypeXML.class);
            Unmarshaller um = context.createUnmarshaller();
            ExerciseTypeXML wrapper = (ExerciseTypeXML) um.unmarshal(file);
            this.exerciseTypes = wrapper.getExerciseTypes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

