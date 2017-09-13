package com.longjingcha.service;

import com.longjingcha.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user
 */

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List getUserInfo(){
        List list= userDao.findUserInfo();
        System.out.println("ssss");
        return list ;
    }

}
