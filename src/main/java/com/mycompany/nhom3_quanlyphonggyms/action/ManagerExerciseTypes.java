/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nhom3_quanlyphonggyms.action;

import com.mycompany.nhom3_quanlyphonggyms.entity.ExerciseType;
import java.util.ArrayList;
import java.util.List;

public class ManagerExerciseTypes {
    private List<ExerciseType> exerciseTypes = new ArrayList<>();

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
}

