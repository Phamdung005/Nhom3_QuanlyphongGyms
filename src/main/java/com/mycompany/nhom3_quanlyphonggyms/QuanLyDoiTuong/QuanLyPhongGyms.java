/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.nhom3_quanlyphonggyms.QuanLyDoiTuong;

import com.mycompany.nhom3_quanlyphonggyms.controller.LoginController;
import com.mycompany.nhom3_quanlyphonggyms.view.LoginView;
import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author PC
 */
public class QuanLyPhongGyms 
{
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginView view = new LoginView();
                LoginController controller = new LoginController(view);
                // hiển thị màn hình login
                controller.showLoginView();
            }
        });
    }
}
