package edu.qc.seclass.glm.database.schema;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import edu.qc.seclass.glm.database.schema.GroceryList;

@Entity(tableName = "user_table")
public class User {
    @PrimaryKey(autoGenerate = true)
    public Integer userId;

//    HashMap<Integer, GroceryList> groceryLists;

    public void newList(String name) {

    }

    public void renameList(GroceryList list, String newName) {

    }

    public void deleteList(GroceryList list) {

    }

    public GroceryList selectList(GroceryList list) {
        return list;
    }




}
