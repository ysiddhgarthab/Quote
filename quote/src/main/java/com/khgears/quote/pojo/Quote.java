package com.khgears.quote.pojo;

public class Quote {
    private int id;
    private String itemcode;
    private String itemname;
    private float price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "itemcode='" + itemcode + '\'' +
                ", itemname='" + itemname + '\'' +
                ", price=" + price +
                '}';
    }
}
