package com.zach.community.model;

import java.util.Date;

/**
 * @author zach - 吸柒
 */
public class Problem {

    private String title;

    private String category;

    private String content;

    private String userName;

    private Date createTime;

    @Override
    public String toString() {
        return "Problem{" +
                "title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", content='" + content + '\'' +
                ", userName='" + userName + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
