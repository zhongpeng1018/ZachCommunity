package com.zach.community.model;

/**
 * @author zach - 吸柒
 */
public class Problem {

    private String title;

    private String category;

    private String content;

    private String userName;

    @Override
    public String toString() {
        return "Problem{" +
                "title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", content='" + content + '\'' +
                ", userName='" + userName + '\'' +
                '}';
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
