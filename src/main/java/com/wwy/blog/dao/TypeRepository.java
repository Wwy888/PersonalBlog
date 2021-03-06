package com.wwy.blog.dao;

import com.wwy.blog.po.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;

public interface TypeRepository extends JpaRepository<Type,Long> {
    Type findByName(String name);
}
