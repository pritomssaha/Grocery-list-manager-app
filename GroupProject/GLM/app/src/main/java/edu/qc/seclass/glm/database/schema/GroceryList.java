package edu.qc.seclass.glm.database.schema;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "list_table")
public class GroceryList {
    @PrimaryKey(autoGenerate = true)
    private Integer listId;

    private Integer userId;

    private String name;

    public GroceryList(String name) {
        this.name = name;
    }


    //searchByName()


    public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
