package com.ssm.controller;

import com.ssm.common.Constants;
import com.ssm.common.Result;
import com.ssm.common.ResultGenerator;
import com.ssm.entity.User;
import com.ssm.service.AdminUserService;
import com.ssm.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private AdminUserService adminUserService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public Result Login(@RequestBody User user) {
        Result result = ResultGenerator.genFailResult("登录失败");
        if (StringUtils.isEmpty(user.getUserName()) && StringUtils.isEmpty(user.getpassword())) {
            result.setMessage("请填写登录信息！");
        }
        User loginUser = adminUserService.updateTokenAndLogin(user.getUserName(), user.getpassword());
        if (loginUser != null) {
            result = ResultGenerator.genSuccessResult(loginUser);
        }
        return result;
    }


    /**
     * 列表
     */

    @RequestMapping(value = "/list")
    public Result list(@RequestParam Map<String, Object> params) {
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genErrorResult(Constants.RESULT_CODE_PARAM_ERROR, "参数异常");
        }
        //查询列表数据
        PageUtil page = new PageUtil(params);
        return ResultGenerator.genSuccessResult(adminUserService.getAdminUserPage(page));
    }
}
