package com.mycompany.nhom3_quanlyphonggyms.action;

import com.mycompany.nhom3_quanlyphonggyms.entity.Room;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ManagerRooms {
    private List<Room> roomList;

    public ManagerRooms() {
        roomList = new ArrayList<>();
    }

    public List<Room> getRoomList() {
        return roomList;
    }
    
    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public void addRoom(Room room) {
        roomList.add(room);
    }

    public void editRoom(Room updatedRoom) {
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getId().equals(updatedRoom.getId())) {
                roomList.set(i, updatedRoom);
                return;
            }
        }
    }
    public void deleteRoom(Room room) {
        roomList.removeIf(r -> r.getId().equals(room.getId()));
    }

    public boolean isRoomNameUnique(String name) {
        return roomList.stream()
                .noneMatch(r -> r.getName().equalsIgnoreCase(name));
    }

    public boolean isRoomIdUnique(String id) {
        return roomList.stream()
                .noneMatch(r -> r.getId().equalsIgnoreCase(id));
    }

    public List<Room> searchRoomByName(String keyword) {
        return roomList.stream()
                .filter(r -> r.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void sortByName() {
        roomList.sort(Comparator.comparing(Room::getName));
    }
    public void sortByCapacity() {
        roomList.sort(Comparator.comparingInt(Room::getCapacity));
    }
}
