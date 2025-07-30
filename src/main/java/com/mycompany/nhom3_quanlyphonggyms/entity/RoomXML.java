/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nhom3_quanlyphonggyms.entity;

import java.util.List;
import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "rooms")
@XmlAccessorType(XmlAccessType.FIELD)
public class RoomXML {

    @XmlElement(name = "room")
    private List<Room> room;

    public List<Room> getRoom() {
        return room;
    }

    public void setRoom(List<Room> room) {
        this.room = room;
    }
}
