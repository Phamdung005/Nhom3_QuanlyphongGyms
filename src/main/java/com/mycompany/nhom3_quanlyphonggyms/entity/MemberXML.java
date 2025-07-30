package com.mycompany.nhom3_quanlyphonggyms.entity;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "members")               
@XmlAccessorType(XmlAccessType.FIELD)           
public class MemberXML {

    @XmlElement(name = "member")               
    private List<Member> member;

    public MemberXML() {
    }

    public List<Member> getMember() {
        return member;
    }

    public void setMember(List<Member> member) {
        this.member = member;
    }
}
