package com.minji.springbasic;

import com.minji.springbasic.discount.DiscountPolicy;
import com.minji.springbasic.discount.FixDiscountPolicy;
import com.minji.springbasic.member.MemberRepository;
import com.minji.springbasic.member.MemberService;
import com.minji.springbasic.member.MemberServiceImpl;
import com.minji.springbasic.member.MemoryMemberRepository;
import com.minji.springbasic.order.OrderService;
import com.minji.springbasic.order.OrderServiceImpl;


// 애플리케이션의 실제 동작에 필요한 구현 객체를 생성함. 그리고 생성한 객체 인스턴스의 참조를 '생성자를 통해서' 주입 해준다.

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
