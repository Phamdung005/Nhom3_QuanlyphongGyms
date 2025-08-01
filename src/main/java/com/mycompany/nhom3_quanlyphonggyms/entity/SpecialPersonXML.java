package com.mycompany.nhom3_quanlyphonggyms.entity;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SpecialPersons")
@XmlAccessorType(XmlAccessType.FIELD)
public class SpecialPersonXML {
    
    private List<SpecialPerson> specialPerson;

    public List<SpecialPerson> getSpecialPerson() {
        return specialPerson;
    }

    public void setSpecialPerson(List<SpecialPerson> specialPerson) {
        this.specialPerson = specialPerson;
    }
}
