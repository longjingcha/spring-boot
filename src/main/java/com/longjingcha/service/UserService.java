package com.longjingcha.service;

import com.longjingcha.mapper.UserMapper;
import com.longjingcha.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by user
 */

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserInfo(){
        User user=userMapper.findUserInfo();
        //User user=null;
        return user;
    }

}
