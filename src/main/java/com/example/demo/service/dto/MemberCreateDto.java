package com.example.demo.service.dto;

import com.example.demo.domain.Part;

public record MemberCreateDto(
        String name,
        Part part,
        int age
) {

}
