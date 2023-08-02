package hello0628.core;

import hello0628.core.discount.DiscountPolicy;
import hello0628.core.discount.FixDiscountPolicy;
import hello0628.core.discount.RateDiscountPolicy;
import hello0628.core.member.MemberRepository;
import hello0628.core.member.MemberService;
import hello0628.core.member.MemberServiceImpl;
import hello0628.core.member.MemoryMemberRepository;
import hello0628.core.order.OrderService;
import hello0628.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
