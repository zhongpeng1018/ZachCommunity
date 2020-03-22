package com.zach.community.controller;

import com.zach.community.mapper.ProblemMapper;
import com.zach.community.mapper.UserMapper;
import com.zach.community.model.Problem;
import com.zach.community.model.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author zach - 吸柒
 */

@Controller
public class IndexController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    ProblemMapper problemMapper;

    @GetMapping("/")
    public String index(HttpServletRequest request,Model model) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                String token = cookie.getValue();
                User user = userMapper.findByToken(token);
                //存入Session
                request.getSession().setAttribute("user",user);
                break;
            }
        }

        List<Problem> problems = problemMapper.findAll();

        System.out.println(problems);

        model.addAttribute("problems",problems);



        return "index";
    }

}
