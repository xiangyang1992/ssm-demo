package com.ssm.service;

import com.ssm.common.PageResult;
import com.ssm.entity.User;
import com.ssm.utils.PageUtil;

import java.util.List;
import java.util.Map;

public interface AdminUserService {
    User findByPwdAndUsername(String username,String passwordMd5);

    User getAdminUserByToken(String token);

    User updateTokenAndLogin(String username, String password);

    PageResult getAdminUserByPage(PageUtil pageUtil);


}
