/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nhom3_quanlyphonggyms.action;

import com.mycompany.nhom3_quanlyphonggyms.entity.ExerciseType;
import com.mycompany.nhom3_quanlyphonggyms.entity.Member;
import com.mycompany.nhom3_quanlyphonggyms.entity.MemberXML;
import com.mycompany.nhom3_quanlyphonggyms.entity.Trainer;
import com.mycompany.nhom3_quanlyphonggyms.entity.TrainerXML;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Admin
 */
public class ManagerTrainers {
    private List<Trainer> trainerList = new ArrayList<>();
    private static final String DEFAULT_TRAINER_PATH = "trainers.xml";
    
    public ManagerTrainers() {
        // Constructor rỗng, không load gì
    }

    public void init(List<ExerciseType> exerciseTypes) {
        loadFromFile(DEFAULT_TRAINER_PATH, exerciseTypes);
    }
    
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
    public void loadFromFile(String path, List<ExerciseType> exerciseTypes) {
        try {
            JAXBContext context = JAXBContext.newInstance(TrainerXML.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            TrainerXML trainerXML = (TrainerXML) unmarshaller.unmarshal(new File(path));
            this.trainerList = trainerXML.getTrainerList();

            for (Trainer m : trainerList) {
                for (ExerciseType et : exerciseTypes) {
                        if (m.getExerciseType() != null && 
                        et.getId().equals(m.getExerciseType().getId())) {
                        m.setExerciseType(et);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
