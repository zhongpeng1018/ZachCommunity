package com.zach.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zach - 吸柒
 */

@Controller
public class AuthorizeController {

    @GetMapping("/callback")
    public String getAccessToken(@RequestParam(name = "code") String code){
        return "";
    }

}
