package com.review.coffeeShop.member.service;

import com.review.coffeeShop.exception.BusinessLogicException;
import com.review.coffeeShop.exception.ExceptionCode;
import com.review.coffeeShop.member.entity.Member;
import com.review.coffeeShop.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(Member member){
        Member response = memberRepository.save(member);

        return response;
    }

    public Member updateMember(Member member){

        return null;
    }

    public Member findMember(long memberId){

        Optional<Member> member = memberRepository.findById(memberId);
        Member response = member.orElseThrow(()-> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));

        return response;
    }

    public List<Member> findMembers(){

        return null;
    }

    public void deleteMember(long memberId){

    }
}
