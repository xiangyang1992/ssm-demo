package com.ssm.service;

import com.ssm.entity.User;

public interface AdminUserService {
    User findByPwdAndUsername(String username,String passwordMd5);

    User getAdminUserByToken(String token);


}
