package com.codingblocks.news_api;

public  class news_info {
 private   String title;
    private    String urltoimage;
    private    String description;
    private    String  url;
  private  String content;

    public news_info(String title, String urlToImage, String description, String url, String content) {
        this.title = title;
        this.urltoimage = urlToImage;
        this.description = description;
        this.url = url;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrltoimage() {
        return urltoimage;
    }

    public void setUrltoimage(String urltoimage) {
        this.urltoimage = urltoimage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
