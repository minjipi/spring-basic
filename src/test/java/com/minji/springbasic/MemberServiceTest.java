package com.minji.springbasic;

import com.minji.springbasic.member.Grade;
import com.minji.springbasic.member.Member;
import com.minji.springbasic.member.MemberService;
import com.minji.springbasic.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
//        given
        Member member = new Member(1L, "member1", Grade.VIP);

//        when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

//        then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
