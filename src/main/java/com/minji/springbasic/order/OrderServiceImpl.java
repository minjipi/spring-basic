package com.minji.springbasic.order;

import com.minji.springbasic.discount.DiscountPolicy;
import com.minji.springbasic.discount.FixDiscountPolicy;
import com.minji.springbasic.member.Member;
import com.minji.springbasic.member.MemberRepository;
import com.minji.springbasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
