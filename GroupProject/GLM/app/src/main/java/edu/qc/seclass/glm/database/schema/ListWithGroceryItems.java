package edu.qc.seclass.glm.database.schema;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class ListWithGroceryItems {
    @Embedded
    public GroceryList list;

    @Relation(
            parentColumn = "listId",
            entityColumn = "itemId",
            associateBy = @Junction(GroceryItem.class)
    )

    public List<Item> items;
}
