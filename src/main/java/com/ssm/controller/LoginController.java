package com.ssm.controller;

import com.ssm.common.Result;
import com.ssm.common.ResultGenerator;
import com.ssm.entity.User;
import com.ssm.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private AdminUserService adminUserService;

    @RequestMapping("/login")
    @ResponseBody
    public Result Login(@RequestBody User user) {
        Result result = ResultGenerator.genFailResult("登录失败");
        if (StringUtils.isEmpty(user.getUserName()) && StringUtils.isEmpty(user.getPasswordMd5())) {
            result.setMessage("请填写登录信息！");
        }
        User loginUser = adminUserService.findByPwdAndUsername(user.getUserName(), user.getPasswordMd5());
        if (loginUser != null) {
            ResultGenerator.genSuccessResult(loginUser);
        }
        return result;
    }
}
