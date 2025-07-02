/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nhom3_quanlyphonggyms.entity;

/**
 *
 * @author Admin
 */
public class Member {
    private String name;
    private String dob;
    private String phone;
    private ExerciseType exerciseType;
    private Room room;
    
    public Member(String name, String dob, String phone, ExerciseType exerciseType, Room room) {
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.exerciseType = exerciseType;
        this.room = room;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    public String getDob() {
        return dob;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPhone() {
        return phone;
    }
    public void setExerciseType(ExerciseType exerciseType) {
        this.exerciseType = exerciseType;
    }
    public ExerciseType getExerciseType() {
        return exerciseType;
    }
    public void setRoom(Room room) {
        this.room = room;
    }
    public Room getRoom() {
        return room;
    }
}
