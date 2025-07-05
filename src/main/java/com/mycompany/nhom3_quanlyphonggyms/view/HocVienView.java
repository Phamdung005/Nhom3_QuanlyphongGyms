/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.nhom3_quanlyphonggyms.view;

import com.mycompany.nhom3_quanlyphonggyms.controller.HocVienController;
import com.mycompany.nhom3_quanlyphonggyms.entity.HocVien;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class HocVienView extends javax.swing.JFrame {
    private HocVienController controller = new HocVienController();

    public HocVienView() {
        initComponents();
        hienThiLenTable();
    }

    private void hienThiLenTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Ma", "Ten", "Tuoi", "Gioi Tinh", "SDT", "Goi Tap"});
        for (HocVien hv : controller.getDanhSach()) {
            model.addRow(new Object[]{
                hv.getMa(), hv.getTen(), hv.getTuoi(),
                hv.getGioiTinh(), hv.getSdt(), hv.getGoiTap()
            });
        }
        tblHocVien.setModel(model);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mahocvien = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        txtMa = new javax.swing.JTextField();
        hoten = new javax.swing.JPanel();
        btnTim = new javax.swing.JButton();
        txtGoiTap = new javax.swing.JTextField();
        gioitinh = new javax.swing.JPanel();
        tuoi = new javax.swing.JPanel();
        btnLuu = new javax.swing.JButton();
        sdt = new javax.swing.JPanel();
        goitap = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHocVien = new javax.swing.JTable();
        btnThongKe = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnDoc = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        txtTen = new javax.swing.JTextField();
        txtTuoi = new javax.swing.JTextField();
        txtGioiTinh = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnThem.setText("Them");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        txtMa.setText("jTextField1");

        javax.swing.GroupLayout mahocvienLayout = new javax.swing.GroupLayout(mahocvien);
        mahocvien.setLayout(mahocvienLayout);
        mahocvienLayout.setHorizontalGroup(
            mahocvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mahocvienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mahocvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        mahocvienLayout.setVerticalGroup(
            mahocvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mahocvienLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(btnThem)
                .addContainerGap())
        );

        btnTim.setText("tim");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        txtGoiTap.setText("jTextField1");

        javax.swing.GroupLayout hotenLayout = new javax.swing.GroupLayout(hoten);
        hoten.setLayout(hotenLayout);
        hotenLayout.setHorizontalGroup(
            hotenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hotenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(hotenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTim)
                    .addComponent(txtGoiTap, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        hotenLayout.setVerticalGroup(
            hotenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hotenLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(txtGoiTap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnTim))
        );

        javax.swing.GroupLayout gioitinhLayout = new javax.swing.GroupLayout(gioitinh);
        gioitinh.setLayout(gioitinhLayout);
        gioitinhLayout.setHorizontalGroup(
            gioitinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
        );
        gioitinhLayout.setVerticalGroup(
            gioitinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        btnLuu.setText("luufile");

        javax.swing.GroupLayout tuoiLayout = new javax.swing.GroupLayout(tuoi);
        tuoi.setLayout(tuoiLayout);
        tuoiLayout.setHorizontalGroup(
            tuoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tuoiLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(btnLuu)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        tuoiLayout.setVerticalGroup(
            tuoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tuoiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLuu)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout sdtLayout = new javax.swing.GroupLayout(sdt);
        sdt.setLayout(sdtLayout);
        sdtLayout.setHorizontalGroup(
            sdtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 117, Short.MAX_VALUE)
        );
        sdtLayout.setVerticalGroup(
            sdtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout goitapLayout = new javax.swing.GroupLayout(goitap);
        goitap.setLayout(goitapLayout);
        goitapLayout.setHorizontalGroup(
            goitapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        goitapLayout.setVerticalGroup(
            goitapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        tblHocVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblHocVien);

        btnThongKe.setText("thongke");

        btnXoa.setText("xoa");

        btnSua.setText("sua");

        btnDoc.setText("docfile");

        btnLamMoi.setText("lammoi");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        txtTen.setText("jTextField1");

        txtTuoi.setText("jTextField2");

        txtGioiTinh.setText("jTextField3");

        txtSDT.setText("jTextField4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mahocvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSua)
                                .addGap(20, 20, 20)
                                .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnLamMoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDoc))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(btnThongKe))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnXoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(174, 174, 174)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(goitap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(goitap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mahocvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSua)
                                .addGap(14, 14, 14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnXoa)
                                .addGap(15, 15, 15)
                                .addComponent(btnDoc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnThongKe))
                            .addComponent(btnLamMoi))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
       try {
            String ma = txtMa.getText();
            String ten = txtTen.getText();
            int tuoi = Integer.parseInt(txtTuoi.getText());
            String gioiTinh = txtGioiTinh.getText();
            String sdt = txtSDT.getText();
            String goiTap = txtGoiTap.getText();
            HocVien hv = new HocVien(ma, ten, tuoi, gioiTinh, sdt, goiTap);
            controller.themHocVien(hv);
            hienThiLenTable();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Tuoi phai la so!");
        }
    }//GEN-LAST:event_btnThemActionPerformed
     private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {
        String ma = txtMa.getText();
        controller.xoaHocVien(ma);
        hienThiLenTable();
    }
     private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String ma = txtMa.getText();
            String ten = txtTen.getText();
            int tuoi = Integer.parseInt(txtTuoi.getText());
            String gioiTinh = txtGioiTinh.getText();
            String sdt = txtSDT.getText();
            String goiTap = txtGoiTap.getText();
            HocVien hv = new HocVien(ma, ten, tuoi, gioiTinh, sdt, goiTap);
            controller.suaHocVien(hv);
            hienThiLenTable();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Tuoi phai la so!");
        }
    }
    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
       String ma = txtMa.getText();
        HocVien hv = controller.timKiemTheoMa(ma);
        if (hv != null) {
            txtTen.setText(hv.getTen());
            txtTuoi.setText(String.valueOf(hv.getTuoi()));
            txtGioiTinh.setText(hv.getGioiTinh());
            txtSDT.setText(hv.getSdt());
            txtGoiTap.setText(hv.getGoiTap());
        } else {
            JOptionPane.showMessageDialog(this, "Khong tim thay hoc vien");
        }
    }//GEN-LAST:event_btnTimActionPerformed
     private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            controller.luuFile("hocvien.dat");
            JOptionPane.showMessageDialog(this, "Luu thanh cong");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Loi khi luu file");
        }
    }

    private void btnDocActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            controller.docFile("hocvien.dat");
            hienThiLenTable();
            JOptionPane.showMessageDialog(this, "Doc thanh cong");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Loi khi doc file");
        }
    }

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {
        String goiTap = txtGoiTap.getText();
        int soLuong = controller.thongKeTheoGoiTap(goiTap);
        JOptionPane.showMessageDialog(this, "So hoc vien dang ky goi '" + goiTap + "': " + soLuong);
    }

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
    txtMa.setText("");
        txtTen.setText("");
        txtTuoi.setText("");
        txtGioiTinh.setText("");
        txtSDT.setText("");
        txtGoiTap.setText("");
    }//GEN-LAST:event_btnLamMoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoc;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JPanel gioitinh;
    private javax.swing.JPanel goitap;
    private javax.swing.JPanel hoten;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mahocvien;
    private javax.swing.JPanel sdt;
    private javax.swing.JTable tblHocVien;
    private javax.swing.JPanel tuoi;
    private javax.swing.JTextField txtGioiTinh;
    private javax.swing.JTextField txtGoiTap;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTuoi;
    // End of variables declaration//GEN-END:variables
}
