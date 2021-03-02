package com.wwy.blog.service;

import com.wwy.blog.po.Blog;
import com.wwy.blog.vo.BlogQuery;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

public interface BlogService {

    Blog getBlog(Long id);

    Page<Blog> listBog(Pageable pageable, BlogQuery blogQuery);

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id, Blog blog);

    void deleteBlog(Long id);
}
