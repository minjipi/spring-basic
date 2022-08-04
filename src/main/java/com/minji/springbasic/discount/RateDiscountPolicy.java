package com.minji.springbasic.discount;

import com.minji.springbasic.member.Grade;
import com.minji.springbasic.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
//    cmd + shift + t 테스트코드 단축키
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
