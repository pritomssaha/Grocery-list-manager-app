package edu.qc.seclass.glm.database.schema;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(tableName = "groceryItem_table", primaryKeys = {"listId", "itemId"})
public class GroceryItem {
    @NonNull
    public Integer listId;

    @NonNull
    public Integer itemId;
    private Integer quantity;
    private String itemName;
    private String itemType;

    private int typeId;
    private boolean checkState;

    public GroceryItem(Integer listId, Integer itemId, Integer typeId, String itemName, String itemType) {
        this.listId = listId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemType = itemType;
        this.typeId = typeId;
        quantity = 0;
        checkState = false;
    }


    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }


    public Integer getQuantity() { return quantity; }

    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public boolean getCheckState() { return checkState; }

    public void setCheckState(boolean checkState) { this.checkState = checkState; }

    // getByItemID()

    // saveListItem()

}
