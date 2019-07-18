package com.ssm.controller;

import com.ssm.entity.Description;
import com.ssm.service.DescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/description")
public class DescriptionController {

    @Autowired
    private DescriptionService descriptionService;

    /**
     * 通过ModandView 对象获取信息
     */
    @RequestMapping("/infoByMV")
    public ModelAndView  infoByMV() {
        Description description = descriptionService.getLastDescription();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("description", description);
        return new ModelAndView("description", map);
    }
}
