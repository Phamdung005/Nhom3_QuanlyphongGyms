/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nhom3_quanlyphonggyms.action;

import com.mycompany.nhom3_quanlyphonggyms.entity.Trainer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ManagerTrainers {
    private List<Trainer> trainerList = new ArrayList<>();
    
    public List<Trainer> getTrainerList() {
        return trainerList;
    }
    
    public void setTrainerList(List<Trainer> trainerList) {
        this.trainerList = trainerList;
    }
    
    public void addTrainer(Trainer trainer) {
        trainerList.add(trainer);
    }
    
    public Trainer findById(String id) {
        for(Trainer t : trainerList) {
            if (t.getId().equalsIgnoreCase(id)) {
                return t;
            }
        }
        return null;
    }
    
    public boolean isTrainerIdUnique(String id) {
        return findById(id) == null;
    }
}
