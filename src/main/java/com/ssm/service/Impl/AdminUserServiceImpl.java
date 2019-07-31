package com.ssm.service.Impl;

import com.ssm.dao.AdminUserDao;
import com.ssm.entity.User;
import com.ssm.service.AdminUserService;
import com.ssm.utils.MD5Util;
import com.ssm.utils.NumberUtil;
import com.ssm.utils.PageUtil;
import com.ssm.utils.SystemUtil;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.NumberUtils;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserDao adminUserDao;
    @Override
    public User findByPwdAndUsername(String userName,String password) {
        return adminUserDao.getAdminUserByUserNameAndPassword(userName,password);
    }

    @Override
    public User getAdminUserByToken(String token) {
        return adminUserDao.getAdminUserByToken(token);
    }

    @Override
    public String getAdminUserPage(PageUtil page) {
        return null;
    }

    @Override
    public User updateTokenAndLogin(String userName, String password) {
        User user = adminUserDao.getAdminUserByUserNameAndPassword(userName, MD5Util.MD5Encode(password, "UTF-8"));
        if (user != null) {
            String token = getNewToken(System.currentTimeMillis() + "", user.getId());
            if (adminUserDao.updateUserToken(user.getId(), token) > 0) {
                user.setUserToken(token);
                return user;
            }
        }
        return null;
    }

    public String getNewToken(String session, Long userId) {
        String src = session + userId + NumberUtil.genRandomNum(4);
        return SystemUtil.genToken(src);
    }


}
