package com.example.demo.controller;

import com.example.demo.controller.dto.APIResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping
    public String test() {
        return "채은이의 첫 API ^^";
    }

    @GetMapping("/json")
    public APIResponse testJson() {
        return APIResponse.create("채은이의 첫 API ^^ with JSON");
    }
}
