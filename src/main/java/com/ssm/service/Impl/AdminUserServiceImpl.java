package com.ssm.service.Impl;

import com.ssm.dao.AdminUserDao;
import com.ssm.entity.User;
import com.ssm.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserDao adminUserDao;
    @Override
    public User findByPwdAndUsername(String username,String passwordMd5) {
        return adminUserDao.getAdminUserByUserNameAndPassword(username,passwordMd5);
    }

    @Override
    public User getAdminUserByToken(String token) {
        return adminUserDao.getAdminUserByToken(token);
    }
}
