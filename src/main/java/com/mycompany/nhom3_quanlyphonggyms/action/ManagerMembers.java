/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nhom3_quanlyphonggyms.action;

import com.mycompany.nhom3_quanlyphonggyms.entity.Member;
import java.util.ArrayList;
import java.util.List;

public class ManagerMembers {
    private List<Member> memberList = new ArrayList<>();

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }

    public void addMember(Member member) {
        memberList.add(member);
    }

    public void updateMember(Member updatedMember) {
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getId().equals(updatedMember.getId())) {
                memberList.set(i, updatedMember);
                return;
            }
        }
    }
    public void deleteMember(Member member) {
        memberList.removeIf(m -> m.getId().equals(member.getId()));
    }

    public boolean isMemberIdUnique(String id) {
        return memberList.stream().noneMatch(m -> m.getId().equalsIgnoreCase(id));
    }

    public List<Member> searchByName(String keyword) {
        return memberList.stream()
                .filter(m -> m.getName().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }
}

