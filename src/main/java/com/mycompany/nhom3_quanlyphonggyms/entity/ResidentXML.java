/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nhom3_quanlyphonggyms.entity;

import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@XmlRootElement(name = "Residents")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResidentXML {
    private List<Residents> residents;

    public List<Residents> getResidents() {
        return residents;
    }

    public void setResidents(List<Residents> residents) {
        this.residents = residents;
    } 
}
