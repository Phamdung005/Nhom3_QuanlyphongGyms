/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nhom3_quanlyphonggyms.controller;

import com.mycompany.nhom3_quanlyphonggyms.action.ManagerSpecialPerson;
import com.mycompany.nhom3_quanlyphonggyms.entity.SpecialPerson;
import com.mycompany.nhom3_quanlyphonggyms.view.ExerciseTypeView;
import com.mycompany.nhom3_quanlyphonggyms.view.LoginView;
import com.mycompany.nhom3_quanlyphonggyms.view.MainView;
import com.mycompany.nhom3_quanlyphonggyms.view.ManagerView;
import com.mycompany.nhom3_quanlyphonggyms.view.MemberView;
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
    private MemberView memberView;
    private ExerciseTypeView exerciseTypeView;
    private RoomView roomView;
    private MainView mainView;
    
    public MainController(MainView view)
    {
        this.mainView = view;
        view.addChooseRoomListener(new ChooseRoomListener());
        view.addChooseMemberListener(new ChooseMemberListener());
        view.addChooseExerciseTypeListener(new ChooseExerciseTypeListener());

    }
    public void showMainView() 
    {
        mainView.setVisible(true);
    }
    class ChooseRoomListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           roomView = new RoomView();
           RoomController roomController = new RoomController(roomView, mainView);
           roomController.showRoomView();
           mainView.setVisible(false);
        }
    }
    class ChooseMemberListener implements ActionListener {
    @Override
        public void actionPerformed(ActionEvent e) {
            memberView = new MemberView();
            MemberController controller = new MemberController(memberView, mainView);
            memberView.setVisible(true);
            mainView.setVisible(false);
        }
    }

    class ChooseExerciseTypeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            exerciseTypeView = new ExerciseTypeView();
            ExerciseTypeController controller = new ExerciseTypeController(exerciseTypeView, mainView);
            exerciseTypeView.setVisible(true);
            mainView.setVisible(false);
        }
    }

    
}
