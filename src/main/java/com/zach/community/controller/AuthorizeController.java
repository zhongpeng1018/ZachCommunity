package com.zach.community.controller;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.zach.community.dto.GithubDTO;
import com.zach.community.dto.GithubUser;
import com.zach.community.mapper.UserMapper;
import com.zach.community.model.User;
import com.zach.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;

/**
 * @author zach - 吸柒
 * Github授权回调路径
 */

@Controller
public class AuthorizeController {

    @Autowired
    GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String client_id;

    @Value("${github.client.secret}")
    private String client_secret;

    @Autowired
    UserMapper userMapper;

    @GetMapping("/callback")
    public String getAccessToken(@RequestParam(name = "code") String code
            , HttpServletRequest request, HttpServletResponse response) {

        String accessToken = githubProvider.getAccessToken(new GithubDTO(client_id, client_secret, code));

        GithubUser githubUser = githubProvider.getGithubUser(accessToken);

        if (githubUser != null) {
            if (userMapper.findByAccountId(githubUser.getId().toString())==null){
                User user = new User();
                String token = UUID.randomUUID().toString();
                user.setName(githubUser.getName());
                user.setAccountId(githubUser.getId().toString());
                user.setToken(token);
                user.setCreateTime(new Date());
                user.setUpdateTime(user.getCreateTime());
                userMapper.addUser(user);
                //给浏览器返回一个自定义Cookie
                Cookie cookie = new Cookie("token", token);
                response.addCookie(cookie);
            }else {
                User user = userMapper.findByAccountId(githubUser.getId().toString());
                //给浏览器返回一个自定义Cookie
                Cookie cookie = new Cookie("token", user.getToken());
                response.addCookie(cookie);
            }
        }
        return "redirect:/";
    }

}
