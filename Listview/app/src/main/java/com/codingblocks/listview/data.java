package com.codingblocks.listview;

public class data {
    String name;
    String teachername;
    String lecture;

    public data(String name, String teachername, String lecture) {
        this.name = name;
        this.teachername = teachername;
        this.lecture = lecture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getLecture() {
        return lecture;
    }

    public void setLecture(String lecture) {
        this.lecture = lecture;
    }

}
