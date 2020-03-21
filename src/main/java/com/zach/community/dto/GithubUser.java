package com.zach.community.dto;

/**
 * @author zach - 吸柒
 * Github用户信息封装类
 */
public class GithubUser {

    private Long id; // Github ID
    private String name; // 授权用户名称
    private String bio; // 授权用户简介

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "GithubUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}
