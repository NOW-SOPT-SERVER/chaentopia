package com.example.demo.service.dto;

import com.example.demo.domain.Member;
import com.example.demo.domain.Part;

public record MemberFindDto(
    String name,
    Part part,
    int age
) {
    public static MemberFindDto of(Member member) {
        return new MemberFindDto(member.getName(), member.getPart(), member.getAge());
    }
}
