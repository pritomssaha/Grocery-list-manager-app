package edu.qc.seclass.glm.database.schema;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "type_table")
public class ItemType {

    @PrimaryKey(autoGenerate = true)
    private Integer typeId;


    private String typeName;

    public ItemType(String typeName) {
        this.typeName = typeName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

// getAllType()
}
