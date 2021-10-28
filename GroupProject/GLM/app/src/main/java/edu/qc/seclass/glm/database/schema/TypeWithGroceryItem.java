package edu.qc.seclass.glm.database.schema;

import androidx.room.Embedded;
import androidx.room.Relation;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;
import java.util.List;

public class TypeWithGroceryItem {


        @Embedded
        public ItemType itemType;
        @Relation(
                parentColumn = "typeId",
                entityColumn = "typeId"
        )
        public List<GroceryItem> items;

}
