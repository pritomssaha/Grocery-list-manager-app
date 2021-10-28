package edu.qc.seclass.glm.database;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import edu.qc.seclass.glm.database.schema.CategoryWithDetailedGroceryItems;
import edu.qc.seclass.glm.database.schema.GroceryItem;
import edu.qc.seclass.glm.database.schema.GroceryItemWithItem;
import edu.qc.seclass.glm.database.schema.GroceryList;
import edu.qc.seclass.glm.database.schema.Item;
import edu.qc.seclass.glm.database.schema.ItemType;
import edu.qc.seclass.glm.database.schema.ListWithGroceryItems;
import edu.qc.seclass.glm.database.schema.TypeWithGroceryItem;


@Dao
public interface GLMDao {

    @Transaction
    @Query("SELECT * FROM list_table")
    LiveData<List<ListWithGroceryItems>> getAllListsWithGroceryItems();


/** Operations for list_table **/
    @Insert
    void addList(GroceryList groceryList);

    @Delete
    void deleteList(GroceryList groceryList);

    @Update
    void updateList(GroceryList groceryList);

    @Query("SELECT * FROM list_table WHERE listId = :listId")
    LiveData<GroceryList> selectList(int listId);

    @Query("DELETE FROM list_table")
    void deleteAllLists();

    @Transaction
    @Query("SELECT * FROM groceryItem_table as git WHERE listId = :listId ORDER BY git.typeId")
    LiveData<List<GroceryItem>> displayList(int listId);


//    @Transaction
//    @Query("SELECT * FROM type_table as tt INNER JOIN item_table as it on it.typeId = tt.typeId INNER JOIN groceryItem_table as git on git.itemId == it.itemId WHERE git.listId = :listId")
//    LiveData<List<CategoryWithDetailedGroceryItems>> displayListByCategory(int listId);

    // Does not work since it impacts our ability to update the object.
//    static class DetailedGroceryItem {
//        public int itemId;
//        public int quantity;
//        public boolean checkState;
//
//        public String itemName;
//        public String itemType;
//    }

/**Operations for item_table **/
    @Insert
    void addItem(Item item);

    @Query("SELECT * FROM item_table WHERE itemId = :itemId")
    LiveData<Item> getItem(int itemId);

    @Query("SELECT * FROM item_table WHERE itemName = :itemName")
    LiveData<List<Item>> getItemsByName(String itemName);

    @Query("SELECT * FROM item_table WHERE typeId = :typeId")
    LiveData<List<Item>> getItemsByTypeId(int typeId);

    // Added for initial population
    @Query("SELECT * FROM item_table")
    LiveData<List<Item>> getItems();

    @Query("SELECT * FROM item_table NATURAL JOIN type_table WHERE typeName = :typeName")
    LiveData<List<Item>> getItemsByTypeName(String typeName);



/** Operations for type_table **/
    @Insert
    void addType(ItemType type);

    // Select all types for listing
    @Query("SELECT * FROM type_table")
    LiveData<List<ItemType>> getTypes();


/** Operations for groceryItem_table **/
    @Insert
    void addGroceryItem(GroceryItem groceryItem);

    @Query("SELECT * FROM groceryItem_table WHERE listId = :listId AND itemId = :itemId")
    GroceryItem getGroceryItem(Integer listId, Integer itemId);

    @Delete
    void deleteGroceryItem(GroceryItem groceryItem);

    @Update
    void updateGroceryItem(GroceryItem groceryItem);

    @Query("SELECT * FROM groceryItem_table WHERE listId = :listId")
    LiveData<List<GroceryItem>> getItemsByList(int listId);

    @Query("UPDATE groceryItem_table SET checkState = 0 WHERE listId = :listId")
    void clearAllCheckMarks(int listId);

    @Query("UPDATE groceryItem_table SET checkState = 1 WHERE listId = :listId")
    void checkAllCheckMarks(int listId);


}