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
import com.mycompany.nhom3_quanlyphonggyms.entity.RoomXML;
import com.mycompany.nhom3_quanlyphonggyms.utils.FileUtils;
import com.mycompany.nhom3_quanlyphonggyms.view.ExerciseTypeView;
import com.mycompany.nhom3_quanlyphonggyms.view.LoginView;
import com.mycompany.nhom3_quanlyphonggyms.view.MainView;
import com.mycompany.nhom3_quanlyphonggyms.view.MemberView;
import com.mycompany.nhom3_quanlyphonggyms.view.TrainerView;
import java.io.InputStream;



/**
 *
 * @author Admin
 */
public class RoomController {
    private RoomView roomView;
    private ManagerRooms managerRooms;
    private MainView mainView;
    private TrainerView trainerView;
    private MemberView memberView;
    private ExerciseTypeView exerciseTypeView;
    private LoginView loginView;

    RoomController(RoomView roomView) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }


    private void saveRoomListToXML() {
        RoomXML roomWrapper = new RoomXML();
        roomWrapper.setRoom(managerRooms.getRoomList());
        FileUtils.writeXMLtoFile("Room.xml", roomWrapper);
    }
    
    private void loadRoomListFromXML() {
        try {
            RoomXML roomWrapper = (RoomXML) FileUtils.readXMLFile("Room.xml", RoomXML.class);
            if(roomWrapper != null && roomWrapper.getRoom() != null) {
                managerRooms.setRoomList(roomWrapper.getRoom());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    
    public RoomController(RoomView view, MainView mainView) {
        this.roomView = view;
        this.mainView = mainView;
        System.out.println("RoomController initialized");
        this.managerRooms = new ManagerRooms();
        view.addAddRoomListener(new AddRoomListener());
        view.addEditRoomListener(new EditRoomListener());
        view.addDeleteRoomListener(new DeleteRoomListener());
        view.addSearchRoomListener(new SearchRoomListener());
        view.addRoomSelectionListener(new RoomSelectionListener());
        view.addBackButtonListener(new BackButtonListener());
        view.addSortByIdListener(new SortByIdListener());
        view.addSortByNameListener(new SortByNameListener());
        view.addSortByCapacityAscListener(new SortByCapacityAscListener());
        view.addSortByCapacityDescListener(new SortByCapacityDescListener());
        view.addSortByCreatedAtListener(new SortByCreatedAtListener());
        view.addChooseTrainerListener(new ChooseTrainerListener());
        view.addChooseMemberListener(new ChooseMemberListener());
        view.addChooseExerciseTypeListener(new ChooseExerciseTypeListener());
        view.addDangXuatListener(new ButtonDangXuat());
    }
    
    class ChooseTrainerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           trainerView = new TrainerView();
           TrainerController trainerController = new TrainerController(trainerView, mainView);
           trainerView.setVisible(true);
           roomView.setVisible(false);
        }
    }
    class ChooseMemberListener implements ActionListener {
    @Override
        public void actionPerformed(ActionEvent e) {
            memberView = new MemberView();
            MemberController controller = new MemberController(memberView, mainView);
            memberView.setVisible(true);
            roomView.setVisible(false);
        }
    }
    class ChooseExerciseTypeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            exerciseTypeView = new ExerciseTypeView();
            ExerciseTypeController controller = new ExerciseTypeController(exerciseTypeView, mainView);
            exerciseTypeView.setVisible(true);
            roomView.setVisible(false);
        }
    }
    class ButtonDangXuat implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            loginView = new LoginView();
            LoginController controller = new LoginController(loginView);
            loginView.setVisible(true);
            roomView.setVisible(false);
        }
    }
    
    public void showRoomView() {
        loadRoomListFromXML();
        List<Room> list = managerRooms.getRoomList();
        roomView.showRoomList(list);
        roomView.showRoomCount(list);  
        roomView.setVisible(true);
    }
    
    public static int getRoomCount() {
        RoomXML roomWrapper = (RoomXML) FileUtils.readXMLFile("Room.xml", RoomXML.class);
        if (roomWrapper != null && roomWrapper.getRoom() != null) {
            return roomWrapper.getRoom().size();
        }
        return 0;
    }
    
    
    class BackButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            roomView.setVisible(false);
            mainView.setVisible(true);
        }
    }
    
    
    class AddRoomListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Room room = roomView.getRoomInfo();
            if (room != null) {
                boolean isIdUnique = managerRooms.isRoomIdUnique(room.getId());
                boolean isNameUnique = managerRooms.isRoomNameUnique(room.getName());

                if (isIdUnique && isNameUnique) {
                    managerRooms.addRoom(room);
                    roomView.showRoomList(managerRooms.getRoomList());
                    roomView.showRoomCount(managerRooms.getRoomList());
                    roomView.showMessage("Thêm phòng tập thành công!");
                    saveRoomListToXML();
                } else {
                    if (!isIdUnique && !isNameUnique) {
                        roomView.showMessage("Mã phòng và tên phòng đã tồn tại!");
                    } else if (!isIdUnique) {
                        roomView.showMessage("Mã phòng đã tồn tại!");
                    } else {
                        roomView.showMessage("Tên phòng đã tồn tại!");
                    }
                }
            }
        }
    }
    
    class EditRoomListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Room room = roomView.getRoomInfo();
            if (room != null) {
                managerRooms.editRoom(room);
                roomView.showRoomList(managerRooms.getRoomList());
                roomView.showRoomCount(managerRooms.getRoomList());
                roomView.showMessage("Cập nhật phòng tập thành công!");
                saveRoomListToXML();
            }
        }
    }
    class DeleteRoomListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Room room = roomView.getRoomInfo();
            if (room != null) {
                managerRooms.deleteRoom(room);
                roomView.clearRoomInfo();
                roomView.showRoomList(managerRooms.getRoomList());
                roomView.showRoomCount(managerRooms.getRoomList());
                roomView.showMessage("Xóa phòng tập thành công!");
                saveRoomListToXML();
            }
        }
    }
    
    class SearchRoomListener implements ActionListener {
        @Override
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
        @Override
        public void valueChanged(ListSelectionEvent e) {
            List<Room> rooms = managerRooms.getRoomList();
            try {
                roomView.fillRoomFromSelectedRow(rooms);
            } catch (ParseException ex) {
                Logger.getLogger(RoomController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    class SortByIdListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            managerRooms.sortById();
            roomView.showRoomList(managerRooms.getRoomList());
        }
    }
    
    class SortByNameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            managerRooms.sortByName();
            roomView.showRoomList(managerRooms.getRoomList());
        }
    }
    
    class SortByCapacityAscListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            managerRooms.sortByCapacityAsc();
            roomView.showRoomList(managerRooms.getRoomList());
        }
    }

    class SortByCapacityDescListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            managerRooms.sortByCapacityDesc();
            roomView.showRoomList(managerRooms.getRoomList());
        }
    }
    class SortByCreatedAtListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            managerRooms.sortByCreatedAt();
            roomView.showRoomList(managerRooms.getRoomList());
        }
    }
    
    public static List<Room> getAll() {
        RoomXML roomWrapper = (RoomXML) FileUtils.readXMLFile("Room.xml", RoomXML.class);
        if (roomWrapper != null && roomWrapper.getRoom() != null) {
            return roomWrapper.getRoom();
        }
        return new java.util.ArrayList<>();
    }
}

