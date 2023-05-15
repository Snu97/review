package com.review.coffeeShop.member.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MemberPostDto {
    private String email;
    private String name;
    private String phone;
}
