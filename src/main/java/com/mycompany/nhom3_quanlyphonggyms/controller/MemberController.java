/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nhom3_quanlyphonggyms.controller;
import com.mycompany.nhom3_quanlyphonggyms.entity.Member;
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class MemberController {
    private ArrayList<Member> memberList = new ArrayList<>();

    public void addMember(Member m) {
        memberList.add(m);
    }

    public ArrayList<Member> getAll() {
        return memberList;
    }

    public Member findByPhone(String phone) {
        return memberList.stream().filter(m -> m.getPhone().equals(phone)).findFirst().orElse(null);
    }
}
