/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nhom3_quanlyphonggyms.action;

import com.mycompany.nhom3_quanlyphonggyms.entity.ExerciseType;
import com.mycompany.nhom3_quanlyphonggyms.entity.Member;
import com.mycompany.nhom3_quanlyphonggyms.entity.MemberXML;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class ManagerMembers {
    private List<Member> memberList = new ArrayList<>();
    private static final String DEFAULT_MEMBER_PATH = "members.xml";

    public ManagerMembers() {
        ManagerExerciseTypes met = new ManagerExerciseTypes();
        loadFromFile(DEFAULT_MEMBER_PATH, met.getExerciseTypes());
    }

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
    public void loadFromFile(String path, List<ExerciseType> exerciseTypes) {
        try {
            JAXBContext context = JAXBContext.newInstance(MemberXML.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            MemberXML memberXML = (MemberXML) unmarshaller.unmarshal(new File(path));
            this.memberList = memberXML.getMember();

        // Gán lại ExerciseType từ danh sách hiện có (tránh reference khác)
            for (Member m : memberList) {
                for (ExerciseType et : exerciseTypes) {
                    if (m.getExerciseType() != null && 
                        et.getId().equals(m.getExerciseType().getId())) {
                        m.setExerciseType(et);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

