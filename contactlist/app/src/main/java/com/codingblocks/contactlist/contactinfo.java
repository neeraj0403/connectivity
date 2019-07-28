package com.codingblocks.contactlist;

public class contactinfo {

    String name;
    String number;
    String link;

    public contactinfo(String name, String number,String link) {
        this.name = name;
        this.number = number;
        this.link=link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
