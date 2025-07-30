/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nhom3_quanlyphonggyms.entity;

import java.util.Date;
import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "invoice")
@XmlAccessorType(XmlAccessType.FIELD)
public class Invoice {
    private String memberId;
    private String memberName;
    private String exerciseType;
    private double fee;
    private Date dateCreated;

    public Invoice() {
    }

    public Invoice(String memberId, String memberName, String exerciseType, double fee, Date dateCreated) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.exerciseType = exerciseType;
        this.fee = fee;
        this.dateCreated = dateCreated;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}