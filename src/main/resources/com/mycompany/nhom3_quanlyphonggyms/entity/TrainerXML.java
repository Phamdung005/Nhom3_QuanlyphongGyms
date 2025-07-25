/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nhom3_quanlyphonggyms.entity;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "trainers")
@XmlAccessorType(XmlAccessType.FIELD)
public class TrainerXML {
    @XmlElement(name = "trainer")
    private List<Trainer> trainerList;

    public List<Trainer> getTrainerList() {
        return trainerList;
    }

    public void setTrainerList(List<Trainer> trainer) {
        this.trainerList = trainer;
    }
}

