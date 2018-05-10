package com.example.caixiao0504yk.Bean;

/**
 * Created by mac on 2018/5/4.
 */

public class TabBean {

    private String title;
    private String type;

    public TabBean(String title, String type) {
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
