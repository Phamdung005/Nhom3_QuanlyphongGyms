package com.mycompany.nhom3_quanlyphonggyms.entity;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "member") // root XML tag cho mỗi đối tượng Member
@XmlAccessorType(XmlAccessType.FIELD) // cho phép JAXB truy cập trực tiếp các field
public class Member {
    private String id;
    private String name;
    private String dob;
    private String phone;

    @XmlElement(name = "exerciseType")
    private ExerciseType exerciseType;

    @XmlElement(name = "room")
    private Room room;


    public Member() {
    }

    public Member(String id, String name, String dob, String phone, ExerciseType exerciseType, Room room) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.exerciseType = exerciseType;
        this.room = room;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ExerciseType getExerciseType() {
        return exerciseType;
    }
    public void setExerciseType(ExerciseType exerciseType) {
        this.exerciseType = exerciseType;
    }

    public Room getRoom() {
        return room;
    }
    public void setRoom(Room room) {
        this.room = room;
    }
}
