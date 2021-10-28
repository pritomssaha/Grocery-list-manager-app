package edu.qc.seclass.glm.database.schema;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class GroceryItemWithItem {
    @Embedded
    public GroceryItem groceryItem;
    @Relation(
            parentColumn = "itemId",
            entityColumn = "itemId"
    )
    public List<Item> items;
}
