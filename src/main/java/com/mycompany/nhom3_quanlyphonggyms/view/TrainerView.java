/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.nhom3_quanlyphonggyms.view;
import com.mycompany.nhom3_quanlyphonggyms.controller.RoomController;
import com.mycompany.nhom3_quanlyphonggyms.controller.TrainerController;
import com.mycompany.nhom3_quanlyphonggyms.entity.ExerciseType;
import com.mycompany.nhom3_quanlyphonggyms.entity.Trainer;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.util.TreeSet;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

   
public class TrainerView extends javax.swing.JFrame {
    private DefaultTableModel tableModel;
    private List<Trainer> trainerList = new ArrayList<>();
    private int selectedRow = -1;
    private List<ExerciseType> currentExerciseTypes;

    /**
     * Creates new form TrainerView
     */
    public TrainerView() {
        initComponents();
        initTable();
        addListeners();
        setLocationRelativeTo(null);
        setTitle("Quản lý phòng gym");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jTextFieldName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldSearch = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        lblPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lblDob = new javax.swing.JLabel();
        cbExerciseType = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTrainer = new javax.swing.JTable();
        cbSortBy = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtStats = new javax.swing.JTextArea();
        txtDob = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        btnChooseExerciseType = new javax.swing.JButton();
        btnChooseTrainer = new javax.swing.JButton();
        btnChooseRoom = new javax.swing.JButton();
        btnChooseMember = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();
        btnInvoice = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1130, 680));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel1.setText("QUẢN LÝ HUẤN LUYỆN VIÊN.");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("MÃ HLV:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("TÊN HLV:");

        jTextFieldID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("CHUYÊN MÔN:");

        jTextFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(204, 204, 204));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/nhom3_quanlyphonggyms/view/add.png"))); // NOI18N
        btnAdd.setText("THÊM");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(204, 204, 204));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/nhom3_quanlyphonggyms/view/Edit.png"))); // NOI18N
        btnUpdate.setText("SỬA ");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(204, 204, 204));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/nhom3_quanlyphonggyms/view/delete.png"))); // NOI18N
        btnDelete.setText("XÓA ");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(204, 204, 204));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/nhom3_quanlyphonggyms/view/search.png"))); // NOI18N
        btnSearch.setText("TÌM KIẾM");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        lblPhone.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPhone.setText("SĐT:");

        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });

        lblDob.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDob.setText("NGÀY SINH:");

        cbExerciseType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbExerciseTypeActionPerformed(evt);
            }
        });

        jTableTrainer.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableTrainer.setRowHeight(40);
        jScrollPane1.setViewportView(jTableTrainer);

        cbSortBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sắp xếp", "Mã (tăng dần)", "Mã (giảm dần)", "Họ tên (A - Z)", "Họ tên (Z - A)", "Ngày sinh (cũ - mới)", "Ngày sinh (mới - cũ)", "Loại hình", " ", " " }));
        cbSortBy.setPreferredSize(new java.awt.Dimension(280, 60));

        txtStats.setEditable(false);
        txtStats.setColumns(20);
        txtStats.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        txtStats.setLineWrap(true);
        txtStats.setRows(5);
        txtStats.setWrapStyleWord(true);
        jScrollPane3.setViewportView(txtStats);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(btnSearch)))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldSearch)
                                .addGap(78, 78, 78))))
                    .addComponent(jScrollPane1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbSortBy, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDob)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldID, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(cbExerciseType, 0, 180, Short.MAX_VALUE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(jTextFieldName, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(txtDob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(cbSortBy, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbExerciseType, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblDob, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                    .addComponent(txtDob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jTextFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchActionPerformed

    private void jTextFieldIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIDActionPerformed

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void cbExerciseTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbExerciseTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbExerciseTypeActionPerformed

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
    private void initTable(){
        String[] columnNames = {"ID", "Name", "Expertise", "SĐT", "Ngày sinh"};
        tableModel = new DefaultTableModel(columnNames, 0);
        jTableTrainer.setModel(tableModel);
    }
    private void addListeners(){
        btnAdd.addActionListener(evt -> addTrainer());
        btnUpdate.addActionListener(evt -> updateTrainer());
        btnDelete.addActionListener(evt -> deleteTrainer());
        btnSearch.addActionListener(evt -> searchTrainer());
        
        jTableTrainer.getSelectionModel().addListSelectionListener(e -> {
           if(!e.getValueIsAdjusting() && jTableTrainer.getSelectedRow() >= 0) {
               selectedRow = jTableTrainer.getSelectedRow();
               Trainer trainer = trainerList.get(selectedRow);
               jTextFieldID.setText(trainer.getId());
               jTextFieldName.setText(trainer.getName());
               cbExerciseType.setSelectedItem(trainer.getExpertise());
           } 
        });
    }
    
    public void setExerciseTypeComboBox(List<ExerciseType> types) {
        currentExerciseTypes = types;
        cbExerciseType.removeAllItems();
        for (ExerciseType t : types) {
            cbExerciseType.addItem(t.getName());
        }
    }
    private void addTrainer(){
        String id = jTextFieldID.getText().trim();
        String name = jTextFieldName.getText().trim();
        String expertise = cbExerciseType.getSelectedItem().toString();
        if (id.isEmpty() || name.isEmpty() || expertise.isEmpty()){
            JOptionPane.showMessageDialog(this, "vui lòng nhập đày đủ thông tin.");
            return;
        }
        Trainer trainer =new Trainer(id, name, expertise);
        trainerList.add(trainer);
        tableModel.addRow(new Object[]{id, name, expertise});
        clearForm();
    }
    private void updateTrainer(){
        if(selectedRow >= 0){
            String id = jTextFieldID.getText().trim();
            String name = jTextFieldName.getText().trim();
            String expertise = cbExerciseType.getSelectedItem().toString();
            
            Trainer trainer = new Trainer(id, name, expertise);
            trainerList.set(selectedRow, trainer);
            
            tableModel.setValueAt(id, selectedRow, 0);
             tableModel.setValueAt(name, selectedRow, 1);
              tableModel.setValueAt(expertise, selectedRow, 2);
              clearForm();
        }else{
            JOptionPane.showMessageDialog(this, "hãy chọn dòng để sửa.");
        }
    }
    private void deleteTrainer(){
        if(selectedRow >=0){
            trainerList.remove(selectedRow);
            tableModel.removeRow(selectedRow);
            clearForm();
            selectedRow = -1;
        }else{
            JOptionPane.showMessageDialog(this,"chọn dòng để xóa nhé.");
            
        }
    }
    private void searchTrainer(){
        String keyword = jTextFieldSearch.getText().trim().toLowerCase();
        tableModel.setRowCount(0);
        for (Trainer t: trainerList){
            if(t.getId().toLowerCase().contains(keyword) ||
               t.getName().toLowerCase().contains(keyword) ||
               t.getExpertise().toLowerCase().contains(keyword)){
                tableModel.addRow(new Object[]{t.getId(), t.getName(), t.getExpertise()});
            }
        }
    }
    private void clearForm(){
        jTextFieldID.setText("");
        jTextFieldName.setText("");
        cbExerciseType.setSelectedIndex(-1);
        jTextFieldSearch.setText("");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrainerView().setVisible(true);
            }
        });
    }
    // Getter cho các thành phần giao diện

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }
    
    public JButton getBtnBack() {
        return btnBack;
    }
    
    public JButton getBtnChooseRoom() {
        return btnChooseRoom;
    }
    
    public JButton getBtnChooseMember() {
        return btnChooseMember;
    }
    public JButton getBtnChooseExerciseType() {
        return btnChooseExerciseType;
    }
    public JButton getBtnDangXuat() {
        return btnDangXuat;
    }

    public JTable getTable() {
        return jTableTrainer;
    }

    public JTextField getTextFieldID() {
        return jTextFieldID;
    }

    public JTextField getTextFieldName() {
        return jTextFieldName; 
    }

    public JComboBox<String> getTextFieldExpertise() {
        return cbExerciseType;
    }
    
    public JTextField getTextFieldSearch() {
        return jTextFieldSearch;
    }
    public int getSelectedSortIndex() {
        return cbSortBy.getSelectedIndex();
    }
    public JComboBox<String> getSortComboBox() {
        return cbSortBy;
    }
    public JTextArea getTxtStats() {
        return txtStats;
    }
    public JTextField getTextFieldPhone() {
        return txtPhone;
    }
    public JDateChooser getDateChooserDob() {
        return txtDob;
    }
    public void addBackButtonListener(java.awt.event.ActionListener listener) {
        btnBack.addActionListener(listener);
    }
    public void addChooseRoomListener(java.awt.event.ActionListener listener) {
        btnChooseRoom.addActionListener(listener);
    }
    public void addChooseMemberListener(java.awt.event.ActionListener listener) {
        btnChooseMember.addActionListener(listener);
    }
    public void addChooseExerciseTypeListener(java.awt.event.ActionListener listener) {
        btnChooseExerciseType.addActionListener(listener);
    }
    public void addDangXuatListener(java.awt.event.ActionListener listener) {
        btnDangXuat.addActionListener(listener);
    }
    public void addChooseInvoiceListener(java.awt.event.ActionListener listener) {
        btnInvoice.addActionListener(listener);
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
    private javax.swing.JButton btnInvoice;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbExerciseType;
    private javax.swing.JComboBox<String> cbSortBy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableTrainer;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JLabel lblDob;
    private javax.swing.JLabel lblPhone;
    private com.toedter.calendar.JDateChooser txtDob;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextArea txtStats;
    // End of variables declaration//GEN-END:variables

    public Object getBtnExerciseType() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
