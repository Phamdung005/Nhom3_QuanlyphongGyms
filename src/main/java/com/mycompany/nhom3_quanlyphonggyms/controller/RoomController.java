/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nhom3_quanlyphonggyms.controller;
import com.mycompany.nhom3_quanlyphonggyms.entity.Room;
import com.mycompany.nhom3_quanlyphonggyms.action.ManagerRooms;
import com.mycompany.nhom3_quanlyphonggyms.view.RoomView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


/**
 *
 * @author Admin
 */
public class RoomController {
    private RoomView roomView;
    private ManagerRooms managerRooms;
    
    public RoomController(RoomView view) {
        this.roomView = view;
        this.managerRooms = new ManagerRooms();
        view.addAddRoomListener(new AddRoomListener());
        view.addEditRoomListener(new EditRoomListener());
        view.addDeleteRoomListener(new DeleteRoomListener());
        view.addClearRoomListener(new ClearRoomListener());
        view.addSearchRoomListener(new SearchRoomListener());
        view.addRoomSelectionListener(new RoomSelectionListener());
    }
    
    public void showRoomView() {
        List<Room> roomList = managerRooms.getRoomList();
        roomView.setVisible(true);
        roomView.showRoomList(roomList);
        roomView.showRoomCount(roomList);
    }
    
    class AddRoomListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Room room = roomView.getRoomInfo();
            if (room != null) {
                if (managerRooms.isRoomNameUnique(room.getName())) {
                    managerRooms.addRoom(room);
                    roomView.showRoomList(managerRooms.getRoomList());
                    roomView.showRoomCount(managerRooms.getRoomList());
                    roomView.showMessage("Thêm phòng tập thành công!");
                } else {
                    roomView.showMessage("Tên phòng đã tồn tại!");
                }
            }
        }
    }
    
    class EditRoomListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Room room = roomView.getRoomInfo();
            if (room != null) {
                managerRooms.editRoom(room);
                roomView.showRoomList(managerRooms.getRoomList());
                roomView.showRoomCount(managerRooms.getRoomList());
                roomView.showMessage("Cập nhật phòng tập thành công!");
            }
        }
    }
    class DeleteRoomListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Room room = roomView.getRoomInfo();
            if (room != null) {
                managerRooms.deleteRoom(room);
                roomView.clearRoomInfo();
                roomView.showRoomList(managerRooms.getRoomList());
                roomView.showRoomCount(managerRooms.getRoomList());
                roomView.showMessage("Xóa phòng tập thành công!");
            }
        }
    }
    
    class ClearRoomListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            roomView.clearRoomInfo();
        }
    }
    
    class SearchRoomListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String keyword = roomView.getSearchKeyword();
            List<Room> result = managerRooms.searchRoomByName(keyword);
            if (!result.isEmpty()) {
                roomView.showRoomList(result);
            } else {
                roomView.showMessage("Không tìm thấy phòng!");
            }
        }
    }
    
    class RoomSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            List<Room> rooms = managerRooms.getRoomList();
            roomView.fillRoomFromSelectedRow(rooms);
        }
    }
    
    

}
