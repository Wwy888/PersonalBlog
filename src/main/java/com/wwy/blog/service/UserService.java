package com.wwy.blog.service;

import com.wwy.blog.po.User;
import org.springframework.stereotype.Service;


public interface UserService {

    User checkUser(String username,String password);

}
