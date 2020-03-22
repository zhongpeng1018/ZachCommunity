package com.zach.community.controller;

import com.zach.community.mapper.ProblemMapper;
import com.zach.community.model.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zach - 吸柒
 */
@Controller
public class DetailController {

    @Autowired
    ProblemMapper problemMapper;

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id,Model model){

        Problem problem = problemMapper.findById(id);

        if (problem != null){
            model.addAttribute("problem",problem) ;
        }

        return "detail";
    }

}
