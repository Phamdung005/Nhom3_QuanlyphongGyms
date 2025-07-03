/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nhom3_quanlyphonggyms.controller;
import com.mycompany.nhom3_quanlyphonggyms.entity.Trainer;
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class TrainerController {
    private ArrayList<Trainer> trainerList = new ArrayList<>();
    
    public void addTrainer(Trainer t) {
        trainerList.add(t);
    }
    
    public ArrayList<Trainer> getAll() {
        return trainerList;
    }
    public Trainer findByphone(String phone) {
        return trainerList.stream().filter(t -> t.getPhone().equals(phone)).findFirst().orElse(null);
    }
}
