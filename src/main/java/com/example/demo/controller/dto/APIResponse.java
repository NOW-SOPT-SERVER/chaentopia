package com.example.demo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter // 없으면 통신 안됨
public class APIResponse {
    private String content;

    public static APIResponse create(String content) {
        return new APIResponse(content);
    }
}
