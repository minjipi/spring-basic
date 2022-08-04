package com.minji.springbasic;

import com.minji.springbasic.member.Grade;
import com.minji.springbasic.member.Member;
import com.minji.springbasic.member.MemberService;
import com.minji.springbasic.order.Order;
import com.minji.springbasic.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memverId = 1L;
        Member member = new Member(memverId, "memberId", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memverId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
