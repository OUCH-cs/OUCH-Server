package umc.umc_spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import umc.umc_spring.repository.MemberRepository;
import umc.umc_spring.repository.MemoryMemberRepository;
import umc.umc_spring.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {return new MemberService(memberRepository()); }

    @Bean
    public MemberRepository memberRepository() { return new MemoryMemberRepository(); }
}