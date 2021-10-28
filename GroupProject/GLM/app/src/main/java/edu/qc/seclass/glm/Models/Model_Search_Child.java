package edu.qc.seclass.glm.Models;

import java.io.Serializable;

public class Model_Search_Child implements Serializable
{
    private String category_tab_name;

    public Model_Search_Child(String nameIN)
    {
        category_tab_name = nameIN;
    }

    public String getCategory_tab_name() {
        return category_tab_name;
    }

    public void setCategory_tab_name(String category_tab_name) {
        this.category_tab_name = category_tab_name;
    }
}
