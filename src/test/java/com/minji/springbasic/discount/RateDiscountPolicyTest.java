package com.minji.springbasic.discount;

import com.minji.springbasic.member.Grade;
import com.minji.springbasic.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인")
    void vip() {
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        int discount = discountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인 적용 X")
    void notVip() {
//        given
        Member member = new Member(2L, "memberVIP", Grade.BASIC);
//        when
        int discount = discountPolicy.discount(member, 10000);
//        then
        assertThat(discount).isEqualTo(0);
    }

}