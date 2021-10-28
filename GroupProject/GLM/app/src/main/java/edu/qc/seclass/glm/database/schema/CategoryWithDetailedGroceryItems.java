package edu.qc.seclass.glm.database.schema;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class CategoryWithDetailedGroceryItems {
    @Embedded public ItemType itemType;
    @Relation(
            entity = Item.class,
            parentColumn = "typeId",
            entityColumn = "typeId"
    )
    public List<GroceryItemWithItem> GroceryItemWithItem;
}
