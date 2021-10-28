package edu.qc.seclass.glm.Models;

import java.io.Serializable;

public class Item_Tab implements Serializable
{
    private String item_tab_name, quantity;
    private char check;

    public Item_Tab(String nameIN, String quantityIN)
    {
        item_tab_name = nameIN;
        quantity = quantityIN;
        check = 'F';
    }

    public String getItem_tab_name()
    {
        return item_tab_name;
    }

    public void setItem_tab_name(String input)
    {
        item_tab_name = input;
    }

    public String getQuantity()
    {
        return quantity;
    }

    public void setQuantity(String input)
    {
        quantity = input;
    }

    public void setCheck(char check) {
        this.check = check;
    }

    public char getCheck() {
        return check;
    }
}
