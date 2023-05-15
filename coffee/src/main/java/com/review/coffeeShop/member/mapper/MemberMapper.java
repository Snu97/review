package com.review.coffeeShop.member.mapper;


import com.review.coffeeShop.member.dto.MemberPatchDto;
import com.review.coffeeShop.member.dto.MemberPostDto;
import com.review.coffeeShop.member.dto.MemberResponseDto;
import com.review.coffeeShop.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberPostDto);
    Member memberPatchDtoToMember(MemberPatchDto memberPatchDto);
    MemberResponseDto memberToMemberResponseDto(Member member);
}
