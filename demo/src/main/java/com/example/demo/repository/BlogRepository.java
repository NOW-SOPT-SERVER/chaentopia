package com.example.demo.repository;

import com.example.demo.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository  extends JpaRepository<Blog, Long> {

}
