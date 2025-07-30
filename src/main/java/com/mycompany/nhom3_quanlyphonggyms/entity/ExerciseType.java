package com.mycompany.nhom3_quanlyphonggyms.entity;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "exerciseType")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExerciseType {
    private String id;
    private String name;
    private String description;
    private double fee;

    public ExerciseType() {

    }

    public ExerciseType(String id, String name, String description, double fee) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.fee = fee;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ExerciseType other = (ExerciseType) obj;
        return id != null && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return name;
    }
    public void setFee(double fee) {
        this.fee = fee;
    }
    public double getFee() {
        return fee;
    }
    
}
