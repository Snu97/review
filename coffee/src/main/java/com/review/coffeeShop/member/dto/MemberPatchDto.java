package com.review.coffeeShop.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class MemberPatchDto {
    @Setter
    private long memberId;

    private String name;
    private String phone;


}
