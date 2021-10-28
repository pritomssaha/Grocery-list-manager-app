package edu.qc.seclass.glm.database.schema;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "item_table")
public class Item {
    @PrimaryKey(autoGenerate = true)
    private Integer itemId;

    private String itemName;

    private Integer typeId;

    public Item(String itemName, Integer typeId) {

        this.itemName = itemName;
        this.typeId = typeId;
    }

    //getItemsOfType()

    //searchByName()


    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}
