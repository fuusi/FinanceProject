package com.project.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.pojo.User;
import com.project.service.UserService;
import com.project.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping("/userinfo")
    public String selectUserAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, Model model){
        //查询所有返回到页面
        //ModelAndView modelAndView = new ModelAndView("userinfo","list",userService.selectUserAll());
        //modelAndView.addObject(userService.selectUserAll());
        //modelAndView.setViewName("list");
        //return modelAndView;

        //引入分页信息
        //首先引入PageHelper插件
        PageHelper.startPage(pageNum,pageSize);
        List<User> list = userServiceImpl.selectUserAll();
        //PageInfo封装分页信息
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        model.addAttribute("userPageInfo",pageInfo);
        model.addAttribute("list",list);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl","userInfoActive");
        model.addAttribute("activeUrl2","userInfoActive");
        model.addAttribute("username","username");

        return "admin/userinfo/userinfo";
    }

}
