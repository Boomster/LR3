package com.lab3.ver1.shopitem;

public class ShopItem {
    Integer id;
    String name;
    Double price;
    String genre;
    String image_link;

    public ShopItem(Integer _id, String _name, Double _price, String _genre, String _image_link)
    {
        this.id = _id;
        this.name = _name;
        this.price = _price;
        this.genre = _genre;
        this.image_link = _image_link;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }
}
