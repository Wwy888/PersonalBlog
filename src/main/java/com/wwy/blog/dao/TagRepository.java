package com.wwy.blog.dao;

import com.wwy.blog.po.Tag;
import com.wwy.blog.po.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Long> {

    Tag findByName(String name);
}
