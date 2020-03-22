package com.zach.community.controller;

import com.zach.community.mapper.ProblemMapper;
import com.zach.community.model.Problem;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

/**
 * @author zach - 吸柒
 */
@Controller
public class PublishController {

    @Autowired
    ProblemMapper problemMapper;

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String addProblem(Problem problem){
        problem.setCreateTime(new Date());
        problemMapper.insert(problem);
        return "redirect:/";
    }

}
