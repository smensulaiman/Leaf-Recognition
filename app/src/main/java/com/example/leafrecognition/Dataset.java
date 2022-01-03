package com.example.leafrecognition;

public class Dataset {
    private String title;
    private String subTitle;
    private String key;
    private int image;

    public Dataset(String title, String subTitle, String key, int image) {
        this.title = title;
        this.subTitle = subTitle;
        this.key = key;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
