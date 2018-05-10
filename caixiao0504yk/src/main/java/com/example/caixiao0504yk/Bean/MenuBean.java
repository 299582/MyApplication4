package com.example.caixiao0504yk.Bean;

/**
 * Created by mac on 2018/5/4.
 */

public class MenuBean {
    private String title;
    private int image;

    public MenuBean(String title, int image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
