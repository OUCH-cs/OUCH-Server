package umc.umc_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import umc.umc_spring.domain.Member;
import umc.umc_spring.service.MemberService;

import java.util.List;
import java.util.Optional;

@RestController
public class MemberController {

    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/Member/{id}")
    public Optional<Member> getMember(@PathVariable("id") Long id) {
        return memberService.findOne(id);
    }

    @GetMapping("/Member/all")
    public List<Member> getAllMember() {
        return memberService.findMembers();
    }

    @PutMapping("/Member/new/{name}")
    public void putMember(@PathVariable("name") String name) {
        Member member = new Member();
        member.setName(name);

        memberService.join(member);
    }

}