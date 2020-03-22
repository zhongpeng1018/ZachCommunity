package com.zach.community.controller;

import com.zach.community.model.Problem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author zach - 吸柒
 */
@Controller
public class PublishController {

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String addProblem(Problem problem){
        System.out.println(problem);
        return "redirect:/";
    }

}
