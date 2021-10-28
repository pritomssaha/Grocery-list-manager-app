package edu.qc.seclass.glm.database.schema;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class ItemsOfType {
    @Embedded
    public ItemType type;

    @Relation(
            parentColumn = "typeId",
            entityColumn = "itemId"
    )

    public List<Item> items;
}
