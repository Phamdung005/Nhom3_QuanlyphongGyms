/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nhom3_quanlyphonggyms.controller;

import com.mycompany.nhom3_quanlyphonggyms.entity.HocVien;
import java.io.*;
import java.util.ArrayList;

public class HocVienController {
    private ArrayList<HocVien> danhSach = new ArrayList<>();

    public ArrayList<HocVien> getDanhSach() {
        return danhSach;
    }

    public void themHocVien(HocVien hv) {
        danhSach.add(hv);
    }

    public void xoaHocVien(String ma) {
        danhSach.removeIf(hv -> hv.getMa().equals(ma));
    }

    public void suaHocVien(HocVien hocVienMoi) {
        for (HocVien hv : danhSach) {
            if (hv.getMa().equals(hocVienMoi.getMa())) {
                hv.setTen(hocVienMoi.getTen());
                hv.setTuoi(hocVienMoi.getTuoi());
                hv.setGioiTinh(hocVienMoi.getGioiTinh());
                hv.setSdt(hocVienMoi.getSdt());
                hv.setGoiTap(hocVienMoi.getGoiTap());
                break;
            }
        }
    }

    public HocVien timKiemTheoMa(String ma) {
        for (HocVien hv : danhSach) {
            if (hv.getMa().equals(ma)) {
                return hv;
            }
        }
        return null;
    }

    public void luuFile(String tenFile) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(tenFile))) {
            oos.writeObject(danhSach);
        }
    }

    public void docFile(String tenFile) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(tenFile))) {
            danhSach = (ArrayList<HocVien>) ois.readObject();
        }
    }

    public int thongKeTheoGoiTap(String goiTap) {
        int count = 0;
        for (HocVien hv : danhSach) {
            if (hv.getGoiTap().equalsIgnoreCase(goiTap)) {
                count++;
            }
        }
        return count;
    }
}
