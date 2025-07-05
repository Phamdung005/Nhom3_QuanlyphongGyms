/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nhom3_quanlyphonggyms.entity;
 
/**
 *
 * @author Admin
 */
public class Trainer {
    private String id;
    private String name;
    private String expertise;
    private String phone;
    
    public Trainer(String name, String expertise, String phone) {
        this.name = name;
        this.expertise = expertise;
        this.phone = phone;
        this.id = id;
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
    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }
    public String getExpertise() {
        return expertise;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPhone() {
        return phone;
    }
}
