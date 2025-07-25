package com.mycompany.nhom3_quanlyphonggyms.entity;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "trainer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Trainer {
    private String id;
    private String name;
    private String expertise;
    private String phone;
    private String dob;
    private ExerciseType exerciseType;

    public Trainer() {
    }

    public Trainer(String id, String name, String expertise, String phone, String dob) {
        this.id = id;
        this.name = name;
        this.expertise = expertise;
        this.phone = phone;
        this.dob = dob;
    }

    public Trainer(String id, String name, String expertise) {
        this(id, name, expertise, "", "");
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getExpertise() { return expertise; }
    public void setExpertise(String expertise) { this.expertise = expertise; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    public ExerciseType getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(ExerciseType exerciseType) {
        this.exerciseType = exerciseType;
        if (exerciseType != null) {
            this.expertise = exerciseType.getName(); 
        } else {
            this.expertise = null;
        }
    }
    @Override
    public String toString() {
        return name;
    }
}

