package com.art.artscommunity.model;


public class Item {
    private Art art;
    private int quantity;

    public Item(Art art, int quantity) {
        this.art = art;
        this.quantity = quantity;
    }
    public Item(){}



    public Art getArt() {
        return art;
    }

    public void setArt(Art art) {
        this.art = art;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
