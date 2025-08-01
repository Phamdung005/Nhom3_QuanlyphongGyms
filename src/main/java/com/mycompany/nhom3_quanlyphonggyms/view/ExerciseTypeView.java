/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.nhom3_quanlyphonggyms.view;

import com.mycompany.nhom3_quanlyphonggyms.entity.ExerciseType;
import com.mycompany.nhom3_quanlyphonggyms.entity.ExerciseTypeXML;
import com.mycompany.nhom3_quanlyphonggyms.utils.FileUtils;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class ExerciseTypeView extends javax.swing.JFrame {

    /**
     * Creates new form ExerciseTypeView
     */
    private List<ExerciseType> exerciseTypeList = new  ArrayList<>();
    
    private void loadExerciseTypes() {
       
       ExerciseTypeXML data = (ExerciseTypeXML) FileUtils.readXMLFile("ExerciseType.xml", ExerciseTypeXML.class);
       if (data != null && data.getExerciseTypes() != null) {
           exerciseTypeList = data.getExerciseTypes();
           loadTable(exerciseTypeList);
       } else {
           exerciseTypeList = new ArrayList<>();
       }
    }
    
    private void loadTable(List<ExerciseType> List) {
        showExerciseTypeList(List);
    }
    public ExerciseTypeView() {
        initComponents();
        loadExerciseTypes();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblId = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        lblDescription = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        cbSort = new javax.swing.JComboBox<>();
        lblStatistics = new javax.swing.JLabel();
        lblId1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnChooseExerciseType = new javax.swing.JButton();
        btnChooseTrainer = new javax.swing.JButton();
        btnChooseRoom = new javax.swing.JButton();
        btnChooseMember = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();
        btnInvoice = new javax.swing.JButton();
        lblName1 = new javax.swing.JLabel();
        txtFee = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1130, 680));
        setResizable(false);
        setSize(new java.awt.Dimension(1130, 680));

        lblId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblId.setText("TÌM KIẾM");

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblName.setText("Tên loại hình");

        lblDescription.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDescription.setText("Mô tả");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setRowHeight(40);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("QUẢN LÝ LOẠI HÌNH ");

        btnAdd.setBackground(new java.awt.Color(204, 204, 204));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/nhom3_quanlyphonggyms/view/add.png"))); // NOI18N
        btnAdd.setText("THÊM");

        btnEdit.setBackground(new java.awt.Color(204, 204, 204));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/nhom3_quanlyphonggyms/view/Edit.png"))); // NOI18N
        btnEdit.setText("SỬA");

        btnDelete.setBackground(new java.awt.Color(204, 204, 204));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/nhom3_quanlyphonggyms/view/delete.png"))); // NOI18N
        btnDelete.setText("XÓA");

        btnSearch.setBackground(new java.awt.Color(204, 204, 204));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/nhom3_quanlyphonggyms/view/search.png"))); // NOI18N
        btnSearch.setText("TÌM KIẾM");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane2.setViewportView(txtDescription);

        cbSort.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sắp xếp theo", "Mã tăng dần", "Mã giảm dần", "Tên tăng dần", "Tên giảm dần" }));
        cbSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSortActionPerformed(evt);
            }
        });

        lblStatistics.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblStatistics.setText("THỐNG KÊ");
        lblStatistics.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblId1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblId1.setText("Mã loại hình");

        jPanel1.setBackground(new java.awt.Color(180, 180, 200));
        jPanel1.setPreferredSize(new java.awt.Dimension(280, 680));

        btnChooseExerciseType.setBackground(new java.awt.Color(88, 86, 128));
        btnChooseExerciseType.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnChooseExerciseType.setForeground(new java.awt.Color(255, 255, 255));
        btnChooseExerciseType.setText("<html><div style='text-align: center;'>Quản lý loại hình<br></div>");
        btnChooseExerciseType.setToolTipText("");
        btnChooseExerciseType.setBorder(null);
        btnChooseExerciseType.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChooseExerciseType.setOpaque(true);
        btnChooseExerciseType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseExerciseTypeActionPerformed(evt);
            }
        });

        btnChooseTrainer.setBackground(new java.awt.Color(88, 86, 128));
        btnChooseTrainer.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnChooseTrainer.setForeground(new java.awt.Color(255, 255, 255));
        btnChooseTrainer.setText("Quản lý huấn luyện viên");
        btnChooseTrainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseTrainerActionPerformed(evt);
            }
        });

        btnChooseRoom.setBackground(new java.awt.Color(88, 86, 128));
        btnChooseRoom.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnChooseRoom.setForeground(new java.awt.Color(255, 255, 255));
        btnChooseRoom.setText("<html><div style='text-align: center;'>Quản lý phòng tập<br></div>");
        btnChooseRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseRoomActionPerformed(evt);
            }
        });

        btnChooseMember.setBackground(new java.awt.Color(88, 86, 128));
        btnChooseMember.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnChooseMember.setForeground(new java.awt.Color(255, 255, 255));
        btnChooseMember.setText("<html><div style='text-align: center;'>Quản Lý học viên<br></div>");
        btnChooseMember.setToolTipText("");
        btnChooseMember.setBorder(null);
        btnChooseMember.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChooseMember.setPreferredSize(new java.awt.Dimension(250, 40));
        btnChooseMember.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnChooseMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseMemberActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(88, 86, 128));
        btnBack.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Thống kê");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnDangXuat.setBackground(new java.awt.Color(88, 86, 128));
        btnDangXuat.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnDangXuat.setForeground(new java.awt.Color(255, 255, 255));
        btnDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/nhom3_quanlyphonggyms/view/LogOut.png"))); // NOI18N
        btnDangXuat.setText("<html><div style='text-align: center;'>Đăng xuất<br></div>");
        btnDangXuat.setToolTipText("");
        btnDangXuat.setBorder(null);
        btnDangXuat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDangXuat.setPreferredSize(new java.awt.Dimension(250, 40));
        btnDangXuat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        btnInvoice.setBackground(new java.awt.Color(88, 86, 128));
        btnInvoice.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnInvoice.setForeground(new java.awt.Color(255, 255, 255));
        btnInvoice.setText("<html><div style='text-align: center;'>Quản Lý học phí<br></div>");
        btnInvoice.setToolTipText("");
        btnInvoice.setBorder(null);
        btnInvoice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInvoice.setPreferredSize(new java.awt.Dimension(250, 40));
        btnInvoice.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInvoiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnChooseTrainer, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChooseRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChooseMember, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChooseExerciseType, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnChooseExerciseType, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnChooseTrainer, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnChooseRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnChooseMember, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        lblName1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblName1.setText("Giá loại hình");

        txtFee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFeeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSearch)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblId1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(txtName)
                        .addComponent(txtId)
                        .addComponent(cbSort, 0, 222, Short.MAX_VALUE)
                        .addComponent(lblStatistics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblName1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFee, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cbSort, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lblId1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblName1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFee, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(493, 493, 493))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(365, 365, 365))))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSortActionPerformed
        // TODO add your handling code here:
        if (exerciseTypeList == null || exerciseTypeList.isEmpty()) return;
        
        int selectedIndex = cbSort.getSelectedIndex();
        List<ExerciseType> sortedList = new ArrayList<>(exerciseTypeList);
        switch (selectedIndex) {
            case 1:
                sortedList.sort(Comparator.comparing(ExerciseType::getId));
                break;
            case 2: 
                sortedList.sort(Comparator.comparing(ExerciseType::getId).reversed());
                break;
            case 3:
                sortedList.sort(Comparator.comparing(ExerciseType::getName));
                break;
            case 4:
                sortedList.sort(Comparator.comparing(ExerciseType::getName).reversed());
                break;
            default:
                return;
        }
        loadTable(sortedList);
    }//GEN-LAST:event_cbSortActionPerformed

    private void btnChooseExerciseTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseExerciseTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChooseExerciseTypeActionPerformed

    private void btnChooseTrainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseTrainerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChooseTrainerActionPerformed

    private void btnChooseRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseRoomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChooseRoomActionPerformed

    private void btnChooseMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseMemberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChooseMemberActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void btnInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInvoiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInvoiceActionPerformed

    private void txtFeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFeeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ExerciseTypeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExerciseTypeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExerciseTypeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExerciseTypeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExerciseTypeView().setVisible(true);
            }
        });
    }
        // Thêm các phương thức hỗ trợ controller gọi

public void addAddExerciseTypeListener(ActionListener listener) {
    btnAdd.addActionListener(listener);
}

public void addEditExerciseTypeListener(ActionListener listener) {
    btnEdit.addActionListener(listener);
}

public void addDeleteExerciseTypeListener(ActionListener listener) {
    btnDelete.addActionListener(listener);
}

public void addSearchExerciseTypeListener(ActionListener listener) {
    btnSearch.addActionListener(listener);
}

public void addBackButtonListener(ActionListener listener) {
    btnBack.addActionListener(listener);
}

public void addChooseRoomListener(ActionListener listener) {
    btnChooseRoom.addActionListener(listener);
}
public void addChooseTrainerListener(ActionListener listener) {
    btnChooseTrainer.addActionListener(listener);
}
public void addChooseMemberListener(ActionListener listener) {
    btnChooseMember.addActionListener(listener);
}

public void addDangXuatListener(ActionListener listener) {
    btnDangXuat.addActionListener(listener);
}

public void addChooseInvoiceListener(ActionListener listener) {
    btnInvoice.addActionListener(listener);
}

public void addTableSelectionListener(ListSelectionListener listener) {
    jTable1.getSelectionModel().addListSelectionListener(listener);
}

public ExerciseType getExerciseTypeInfo() {
    try {
        String id = txtId.getText().trim();
        String name = txtName.getText().trim();
        String desc = txtDescription.getText().trim();
        String feeText = txtFee.getText().trim();

        if (id.isEmpty() || name.isEmpty() || feeText.isEmpty()) {
            showMessage("Vui lòng điền đầy đủ thông tin!");
            return null;
        }

        double fee = Double.parseDouble(feeText.replace(",", "").replace("vnd", "").trim());

        return new ExerciseType(id, name, desc, fee);
    } catch (NumberFormatException e) {
        showMessage("Học phí phải là số hợp lệ!");
        return null;
    } catch (Exception e) {
        showMessage("Lỗi nhập liệu: " + e.getMessage());
        return null;
    }
}

public void showExerciseTypeList(List<ExerciseType> list) {
    String[] columnNames = {"Mã", "Tên", "Mô tả", "Học phí"};
    DefaultTableModel model = new DefaultTableModel(columnNames, 0);

    DecimalFormatSymbols symbols = new DecimalFormatSymbols();
    symbols.setGroupingSeparator('.');
    symbols.setDecimalSeparator(',');

    DecimalFormat df = new DecimalFormat("#,###", symbols);

    for (ExerciseType ex : list) {
        String formattedFee = df.format(ex.getFee());
        model.addRow(new Object[]{
            ex.getId(),
            ex.getName(),
            ex.getDescription(),
            formattedFee
        });
    }

    jTable1.setModel(model);
}



public void fillFormFromSelectedRow(List<ExerciseType> list) {
    int row = jTable1.getSelectedRow();
    if (row >= 0) {
        txtId.setText(jTable1.getValueAt(row, 0).toString());
        txtName.setText(jTable1.getValueAt(row, 1).toString());
        txtDescription.setText(jTable1.getValueAt(row, 2).toString());
        txtFee.setText(jTable1.getValueAt(row, 3).toString());
    }
}

public void clearForm() {
    txtId.setText("");
    txtName.setText("");
    txtDescription.setText("");
    txtSearch.setText("");
}
public void showExerciseTypeCount(int count) {
    lblStatistics.setText("Tổng số loại hình: " + count);
}


public void showMessage(String message) {
    JOptionPane.showMessageDialog(this, message);
}

public String getSearchKeyword() {
    return txtSearch.getText().trim();
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnChooseExerciseType;
    private javax.swing.JButton btnChooseMember;
    private javax.swing.JButton btnChooseRoom;
    private javax.swing.JButton btnChooseTrainer;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnInvoice;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbSort;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblId1;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel lblStatistics;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtFee;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
