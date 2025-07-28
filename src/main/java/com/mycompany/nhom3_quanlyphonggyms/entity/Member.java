package com.mycompany.nhom3_quanlyphonggyms.entity;


import java.util.Date;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "member") // root XML tag cho mỗi đối tượng Member
@XmlAccessorType(XmlAccessType.FIELD) // cho phép JAXB truy cập trực tiếp các field
public class Member {
    private String id;
    private String name;
    private Date dob;
    private String phone;
    private String dateCreated;

    @XmlElement(name = "exerciseType")
    private ExerciseType exerciseType;

    @XmlElement(name = "room")
    private Room room;

    @XmlElement(name = "trainer")
    private Trainer trainer;

    public Member() {
        
    }

    public Member(String id, String name, Date dob, String phone, ExerciseType exerciseType, Room room, Trainer trainer) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.exerciseType = exerciseType;
        this.room = room;
        this.trainer = trainer;
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

    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
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
    public Trainer getTrainer() {
        return trainer;
    }
    
    public void setTrainer (Trainer trainer) {
        this.trainer = trainer;
    }
    
    public String getDateCreated() {
        return dateCreated;
    }
}
