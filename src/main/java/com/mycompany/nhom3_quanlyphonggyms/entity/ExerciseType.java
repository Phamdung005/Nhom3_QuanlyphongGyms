package com.mycompany.nhom3_quanlyphonggyms.entity;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "exerciseType")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExerciseType {
    private String id;
    private String name;
    private String description;

    public ExerciseType() {

    }

    public ExerciseType(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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
    public String toString() {
        return name;
    }
}
