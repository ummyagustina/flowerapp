package com.example.flowerapp.model;

public class Group {

    private String grubTitle;
    private String grubButtonTitle;

    public Group(String grubTitle, String grubButtonTitle) {
        this.grubTitle = grubTitle;
        this.grubButtonTitle = grubButtonTitle;
    }

    public String getGrubTitle() {
        return grubTitle;
    }

    public void setGrubTitle(String grubTitle) {
        this.grubTitle = grubTitle;
    }

    public String getGrubButtonTitle() {
        return grubButtonTitle;
    }

    public void setGrubButtonTitle(String grubButtonTitle) {
        this.grubButtonTitle = grubButtonTitle;
    }
}
