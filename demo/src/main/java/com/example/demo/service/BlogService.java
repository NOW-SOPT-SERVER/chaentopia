package com.example.demo.service;

import com.example.demo.domain.Blog;
import com.example.demo.domain.Member;
import com.example.demo.exception.NotFoundException;
import com.example.demo.exception.message.ErrorMessage;
import com.example.demo.repository.BlogRepository;
import com.example.demo.service.dto.BlogCreateRequest;
import com.example.demo.service.dto.BlogTitleUpdateRequest;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;
    private final MemberService memberService;

    @Transactional
    public String create( // URI 값 (String) 반환
            Long memberId,
            BlogCreateRequest blogCreateRequest
    ) {
        Member member = memberService.findById(memberId);
        Blog blog = blogRepository.save(Blog.create(member, blogCreateRequest));
        return blog.getId().toString();
    }
    @Transactional
    public void updateTitle(
            Long blogId,
            BlogTitleUpdateRequest blogTitleUpdateRequest
    ) {
        Blog blog = findBlogById(blogId);
        blog.updateTitle(blogTitleUpdateRequest.title());
    }

    private Blog findBlogById(Long blogId) {
        return blogRepository.findById(blogId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.BLOG_NOT_FOUND_BY_ID_EXCEPTION)
        );
    }
}
