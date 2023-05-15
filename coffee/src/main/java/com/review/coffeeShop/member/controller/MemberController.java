package com.review.coffeeShop.member.controller;


import com.review.coffeeShop.member.dto.MemberPatchDto;
import com.review.coffeeShop.member.dto.MemberPostDto;
import com.review.coffeeShop.member.entity.Member;
import com.review.coffeeShop.member.mapper.MemberMapper;
import com.review.coffeeShop.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/v1/members")
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper mapper;

    public MemberController(MemberService memberService, MemberMapper mapper) {
        this.memberService = memberService;
        this.mapper = mapper;
    }


    @PostMapping
    public ResponseEntity postMember(@RequestBody MemberPostDto memberPostDto){

        Member member = mapper.memberPostDtoToMember(memberPostDto);


        Member response = memberService.createMember(member);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PatchMapping("/{member_id}")
    public ResponseEntity patchMember(@PathVariable("member-id") @Positive long memberId,
                                      @RequestBody MemberPatchDto memberPatchDto){
        memberPatchDto.setMemberId(memberId);

        Member member = mapper.memberPatchDtoToMember(memberPatchDto);

        Member response = memberService.updateMember(member);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{member_id}")
    public ResponseEntity getMember(@PathVariable("member-id") @Positive long memberId){
        Member member = memberService.findMember(memberId);

        return new ResponseEntity<>(mapper.memberToMemberResponseDto(member), HttpStatus.OK);
    }




    @GetMapping
    public ResponseEntity getMembers(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{member_id}")
    public ResponseEntity deleteMember(@RequestParam long memberId){
        memberService.deleteMember(memberId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
