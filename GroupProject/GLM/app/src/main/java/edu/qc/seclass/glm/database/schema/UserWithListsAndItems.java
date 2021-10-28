package edu.qc.seclass.glm.database.schema;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class UserWithListsAndItems {
    @Embedded
    public User user;
    @Relation(
            entity = GroceryList.class,
            parentColumn = "userId", // userId from User
            entityColumn = "userId" // userId from GroceryList
    )
    public List<ListWithGroceryItems> lists;
}
