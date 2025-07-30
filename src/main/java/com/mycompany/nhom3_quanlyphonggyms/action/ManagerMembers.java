package com.mycompany.nhom3_quanlyphonggyms.action;

import com.mycompany.nhom3_quanlyphonggyms.entity.ExerciseType;
import com.mycompany.nhom3_quanlyphonggyms.entity.Member;
import com.mycompany.nhom3_quanlyphonggyms.entity.MemberXML;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

public class ManagerMembers {
    private List<Member> memberList = new ArrayList<>();

    public ManagerMembers() {
        ManagerExerciseTypes met = new ManagerExerciseTypes();
        loadFromFile(met.getExerciseTypes());
        updateExerciseTypes(met.getExerciseTypes());
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
    public void updateExerciseTypes(List<ExerciseType> types) {
    for (Member m : memberList) {
        for (ExerciseType ex : types) {
            if (ex.getId().equals(m.getExerciseType().getId())) {
                m.setExerciseType(ex);
                break;
            }
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

    public void loadFromFile(List<ExerciseType> exerciseTypes) {
        try {
            String basePath = System.getProperty("user.dir");
            File file = new File(basePath + File.separator + "Member.xml");
            System.out.println("Loading file: " + file.getAbsolutePath());

            if (!file.exists()) {
                System.err.println("File không tồn tại: " + file.getAbsolutePath());
                return;
            }

            JAXBContext context = JAXBContext.newInstance(MemberXML.class);
            Unmarshaller um = context.createUnmarshaller();

            MemberXML wrapper = (MemberXML) um.unmarshal(file);
            this.memberList = wrapper.getMember();

            // Gán ExerciseType đúng lại
            for (Member m : memberList) {
                for (ExerciseType ex : exerciseTypes) {
                    if (ex.getId().equals(m.getExerciseType().getId())) {
                        m.setExerciseType(ex);
                        break;
                    }
                }
            }

        } catch (Exception e) {
            System.err.println("Lỗi khi load Member.xml:");
            e.printStackTrace();
        }
    }

    public boolean isSameInfoExceptExerciseType(Member newMember) {
        for (Member m : memberList) {
            if (m.getId().equalsIgnoreCase(newMember.getId())) {
                boolean sameName = m.getName().equalsIgnoreCase(newMember.getName());
                boolean sameDob = m.getDob().equals(newMember.getDob());
                boolean samePhone = m.getPhone().equalsIgnoreCase(newMember.getPhone());
                boolean sameRoom = m.getRoom().getId().equalsIgnoreCase(newMember.getRoom().getId());
                boolean sameTrainer = m.getTrainer().getId().equalsIgnoreCase(newMember.getTrainer().getId());

                return sameName && sameDob && samePhone && sameRoom && sameTrainer;
            }
        }
        return true;
    }
    
}