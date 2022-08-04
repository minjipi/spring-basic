package com.minji.springbasic;

import com.minji.springbasic.member.Grade;
import com.minji.springbasic.member.Member;
import com.minji.springbasic.member.MemberService;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();


        Member member = new Member(1L, "member1", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());

    }
}
