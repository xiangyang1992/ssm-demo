package com.ssm.dao;

import com.ssm.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

public interface AdminUserDao {

    /**
     * 根据登录名和密码获取用户记录
     *
     * @return
     */
    User getAdminUserByUserNameAndPassword(@Param("userName") String userName, @Param("passwordMD5") String passwordMD5);

    User getAdminUserByToken(@RequestParam("token")String token);

}
