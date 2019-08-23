package com.codingblocks.firebase;

import android.util.Log;

public class details {
    String name;
    String age;
    String phone;

    public details(String name, String age, String phone) {
        Log.d("in","i am in pojo");
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
