package com.example.demo.controller;

import com.example.demo.repository.BlogRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.BlogService;
import com.example.demo.service.MemberService;
import com.example.demo.service.dto.BlogCreateRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BlogController.class)
@AutoConfigureMockMvc
public class BlogControllerTest {

    @Autowired
    private MockMvc mockmvc;

    @SpyBean
    private BlogService blogService;

    @SpyBean
    private MemberService memberService;

    @MockBean
    private BlogRepository blogRepository;

    @MockBean
    private MemberRepository memberRepository;

    // 빈 주입 받을
    @Autowired
    private ObjectMapper objectMapper; // 생성하는 객체를 String JSON 배열로 바꾸기 위해 사용

    @Nested
    class createBlog {
        @Test
        @DisplayName("Blog 생성 실패 테스트")
        public void createBlogFail() throws Exception {
            // given
            String request = objectMapper.writeValueAsString(new BlogCreateRequest("챈토피아", "메롱"));

            mockmvc.perform(
                            post("/api/v1/blog")
                                    .content(request)
                                    .header("memberId", 2)
                                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNotFound())
                    .andDo(print());
        }
    }
}
