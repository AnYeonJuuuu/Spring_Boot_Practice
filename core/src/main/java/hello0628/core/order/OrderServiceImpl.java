package hello0628.core.order;

import hello0628.core.discount.DiscountPolicy;
import hello0628.core.discount.FixDiscountPolicy;
import hello0628.core.member.Member;
import hello0628.core.member.MemberRepository;
import hello0628.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    //Order 두 개의 필드가 있음.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }
}