package com.codingblocks.github_api;

public class Githubuserinfo {
String login;
String id;
String Avatar_url;
String score;
String url;

    public Githubuserinfo(String login, String id, String avatar_url, String score, String url) {
        this.login = login;
        this.id = id;
        Avatar_url = avatar_url;
        this.score = score;
        this.url = url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvatar_url() {
        return Avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        Avatar_url = avatar_url;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
