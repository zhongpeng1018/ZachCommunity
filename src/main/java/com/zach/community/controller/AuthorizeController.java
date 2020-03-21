package com.zach.community.controller;

import com.zach.community.dto.GithubDTO;
import com.zach.community.dto.GithubUser;
import com.zach.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zach - 吸柒
 */

@Controller
public class AuthorizeController {

    @Autowired
    GithubProvider githubProvider;
    @Value("${github.client.id}")
    private String client_id;
    @Value("${github.client.secret}")
    private String client_secret;

    @GetMapping("/callback")
    public String getAccessToken(@RequestParam(name = "code") String code
                                 , HttpServletRequest request) {

        String accessToken = githubProvider.getAccessToken(new GithubDTO(client_id, client_secret, code));

        GithubUser githubUser = githubProvider.getGithubUser(accessToken);

        request.getSession().setAttribute("githubUser",githubUser);

        return "redirect:/";
    }

}
