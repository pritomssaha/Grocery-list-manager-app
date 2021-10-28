package edu.qc.seclass.glm.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import edu.qc.seclass.glm.database.schema.GroceryItem;

public class Model_Items implements Serializable {
    String categoryName;
    private boolean expanded;
    private List<GroceryItem> Items = new ArrayList<>();

    public Model_Items(String itemName ,List<GroceryItem> Items) {
        this.categoryName = itemName;
        this.expanded = true;
        this.Items = Items;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void toggleExpanded() {
        this.expanded = !this.expanded;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<GroceryItem> getChildItemList()
    {
        return Items;
    }

//    public void setChildItemList(
//            List<Item_Tab> childItemList)
//    {
//        Items = childItemList;
//    }

}
