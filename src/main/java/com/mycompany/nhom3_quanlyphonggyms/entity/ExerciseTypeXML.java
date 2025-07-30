package com.mycompany.nhom3_quanlyphonggyms.entity;

import java.util.List;
import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "exerciseTypes")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExerciseTypeXML {
    @XmlElement(name = "exerciseType")
    private List<ExerciseType> exerciseTypes;

    public List<ExerciseType> getExerciseTypes() {
        return exerciseTypes;
    }

    public void setExerciseTypes(List<ExerciseType> exerciseTypes) {
        this.exerciseTypes = exerciseTypes;
    }
}
