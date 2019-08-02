package com.ssm.dao;

import com.ssm.entity.User;
import com.ssm.utils.PageUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface AdminUserDao {

    /**
     * 根据登录名和密码获取用户记录
     *
     * @return
     */
    User getAdminUserByUserNameAndPassword(@Param("userName") String userName, @Param("passwordMD5") String passwordMD5);


    User getAdminUserByToken(String token);

    /**
     * 更新用户token值
     *
     * @param userId
     * @param newToken
     * @return
     */
    int updateUserToken(@Param("userId") Long userId, @Param("newToken") String newToken);

    /**
     * 查询用户列表
     */
    List<User> findAdminUsers(Map param);

    /**
     * 查询用户总数
     */
    int getTotalCount(Map param);

}
