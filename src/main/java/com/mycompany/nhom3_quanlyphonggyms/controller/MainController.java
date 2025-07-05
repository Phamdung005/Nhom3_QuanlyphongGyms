/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nhom3_quanlyphonggyms.controller;

import com.mycompany.nhom3_quanlyphonggyms.action.ManagerSpecialPerson;
import com.mycompany.nhom3_quanlyphonggyms.entity.SpecialPerson;
import com.mycompany.nhom3_quanlyphonggyms.view.LoginView;
import com.mycompany.nhom3_quanlyphonggyms.view.MainView;
import com.mycompany.nhom3_quanlyphonggyms.view.ManagerView;
import com.mycompany.nhom3_quanlyphonggyms.view.ResidentView;
import com.mycompany.nhom3_quanlyphonggyms.view.RoomView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author PC
 */
public class MainController 
{
    private LoginView loginView;
    private ManagerView managerView;
    private ResidentView residentView;
    private RoomView roomView;
    private MainView mainView;
    
    public MainController(MainView view)
    {
        this.mainView = view;
        view.addChooseSpecialPersonListener(new ChooseSpecialPersonListener());
        view.addChooseResidentsListener(new ChooseResidentListener());
        view.addChooseRoomListener(new ChooseRoomListener());
    }
    public void showMainView() 
    {
        mainView.setVisible(true);
    }
    class ChooseSpecialPersonListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            managerView = new ManagerView();
            SpecialPersonController managerController = new SpecialPersonController(managerView);
            managerController.showManagerView();
            mainView.setVisible(false);
        }
    }
    
    class ChooseResidentListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            residentView = new ResidentView();
            ResidentController residentController = new ResidentController(residentView);
            residentController.showManagerView();
            mainView.setVisible(false);
        }
    }
    class ChooseRoomListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           roomView = new RoomView();
           RoomController roomController = new RoomController(roomView, mainView);
           roomController.showRoomView();
           mainView.setVisible(false);
        }
    }
    
}
