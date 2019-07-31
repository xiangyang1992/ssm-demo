package com.ssm.service;

import com.ssm.entity.User;
import com.ssm.utils.PageUtil;

public interface AdminUserService {
    User findByPwdAndUsername(String username,String passwordMd5);

    User getAdminUserByToken(String token);


    String getAdminUserPage(PageUtil page);

    User updateTokenAndLogin(String username, String password);
}
