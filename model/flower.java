package com.example.flowerapp.model;

public class flower {

    private String flowerName;
    private String flowerCountry;
    private String flowerPrice;
    private  int flowerImage;


    public flower() {
        this.flowerName = flowerName;
        this.flowerCountry = flowerCountry;
        this.flowerPrice = flowerPrice;
        this.flowerImage = flowerImage;
    }

    public flower(String hazel, String korea, String $350, int img2) {
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public String getFlowerCountry() {
        return flowerCountry;
    }

    public void setFlowerCountry(String flowerCountry) {
        this.flowerCountry = flowerCountry;
    }

    public String getFlowerPrice() {
        return flowerPrice;
    }

    public void setFlowerPrice(String flowerPrice) {
        this.flowerPrice = flowerPrice;
    }

    public int getFlowerImage() {
        return flowerImage;
    }

    public void setFlowerImage(int flowerImage) {
        this.flowerImage = flowerImage;
    }
}
