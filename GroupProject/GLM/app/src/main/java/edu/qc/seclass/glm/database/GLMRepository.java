package edu.qc.seclass.glm.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.qc.seclass.glm.database.schema.CategoryWithDetailedGroceryItems;
import edu.qc.seclass.glm.database.schema.GroceryItem;
import edu.qc.seclass.glm.database.schema.GroceryItemWithItem;
import edu.qc.seclass.glm.database.schema.GroceryList;
import edu.qc.seclass.glm.database.schema.Item;
import edu.qc.seclass.glm.database.schema.ItemType;
import edu.qc.seclass.glm.database.schema.ListWithGroceryItems;
import edu.qc.seclass.glm.database.schema.TypeWithGroceryItem;

public class GLMRepository {
    private GLMDao glmDao;

    private LiveData<List<ListWithGroceryItems>> lists;
    private LiveData<List<Item>> itemList;

    public GLMRepository(Application application) {
        GLMDatabase database = GLMDatabase.getDatabase(application);
        glmDao = database.glmDao();
        lists = glmDao.getAllListsWithGroceryItems();
        itemList = glmDao.getItems();
    }

    /**
     * Operations for list_table
     **/

    public LiveData<List<ListWithGroceryItems>> getLists() {
        return lists;
    }

    public void addList(String name) {
        GroceryList list = new GroceryList(name);
        GLMDatabase.databaseExecutor.execute(() -> {
            glmDao.addList(list);
        });
    }

    public void renameList(GroceryList list, String newName) {
        list.setName(newName);
        GLMDatabase.databaseExecutor.execute(() -> {
            glmDao.updateList(list);
        });
    }

    public void deleteList(GroceryList list) {
        GLMDatabase.databaseExecutor.execute(() -> {
            glmDao.deleteList(list);
        });
    }

    public LiveData<GroceryList> selectList(Integer listId) {
        return glmDao.selectList(listId);
    }

    public void deleteAllLists() {
        GLMDatabase.databaseExecutor.execute(() -> {
            glmDao.deleteAllLists();
        });
    }

    public LiveData<List<GroceryItem>> displayList(int listId) {
        return glmDao.displayList(listId);
    }

//    public LiveData<List<CategoryWithDetailedGroceryItems>> displayListByCategory(int listId) {
//        return glmDao.displayListByCategory(listId);
//    }


    /**
     * Operations for item_table
     **/
    public void addItem(String name, Integer typeId) {
        Item item = new Item(name, typeId);
        GLMDatabase.databaseExecutor.execute(() -> {
            glmDao.addItem(item);
        });
    }

    public void deleteGroceryItem(GroceryItem item) {
        GLMDatabase.databaseExecutor.execute(() -> {
            glmDao.deleteGroceryItem(item);
        });
    }

    public LiveData<List<Item>> getItemsByName(String itemName) {

        return glmDao.getItemsByName(itemName);
    }

    ;

    public List<Item> getItemsByTypeId(int typeId) {
        return glmDao.getItemsByTypeId(typeId).getValue();
    }

    ;

    public LiveData<List<Item>> getItemsByTypeName(String typeName) {
        return glmDao.getItemsByTypeName(typeName);
    }

    public LiveData<Item> getItemById(int itemId) {
        return glmDao.getItem(itemId);
    }

    public LiveData<List<Item>> getItems() {
        return glmDao.getItems();
    }


    /**
     * Operations for type_table
     **/
    public void addType(String name) {
        ItemType type = new ItemType(name);
        GLMDatabase.databaseExecutor.execute(() -> {
            glmDao.addType(type);
        });
    }

    public LiveData<List<ItemType>> getTypes() {
        return glmDao.getTypes();
    }

    /**
     * Operations for groceryItem_table
     *
     * @return*/

    public LiveData<List<GroceryItem>> getItemsByLists(int listId) {
        return glmDao.getItemsByList(listId);
    }
    public void addGroceryItem(Integer listId, Integer itemId, Integer typeId, String itemName, String itemType) {
        GroceryItem groceryItem = new GroceryItem(listId, itemId,typeId, itemName, itemType);
        GLMDatabase.databaseExecutor.execute(() -> {
            glmDao.addGroceryItem(groceryItem);
        });
    }

//    public void deleteGroceryItem(Integer listId, Integer itemId) {
//        GroceryItem groceryItem = glmDao.getGroceryItem(listId, itemId).getValue().get(0);
//        GLMDatabase.databaseExecutor.execute(() -> {
//            glmDao.deleteGroceryItem(groceryItem);
//        });
//    }

    public GroceryItem getGroceryItem(Integer listId, Integer itemId) {
//        System.out.println(glmDao.getGroceryItem(listId, itemId).getValue());

        return glmDao.getGroceryItem(listId, itemId);
    }

    public void changeQuantity(GroceryItem groceryItem, int quantity) {
        groceryItem.setQuantity(quantity);
        GLMDatabase.databaseExecutor.execute(() -> {
            glmDao.updateGroceryItem(groceryItem);
        });
    }

    public void flipCheckState(GroceryItem groceryItem) {
        System.out.println("FLIP CHECK STATE");
        groceryItem.setCheckState(!groceryItem.getCheckState());
        GLMDatabase.databaseExecutor.execute(() -> {
            glmDao.updateGroceryItem(groceryItem);
        });
    }

    public void clearAllCheckMark(int listId) {
        GLMDatabase.databaseExecutor.execute(() -> {
            glmDao.clearAllCheckMarks(listId);
        });
    }

    public void checkAllCheckMark(int listId) {

        GLMDatabase.databaseExecutor.execute(() -> {
            System.out.println(listId);
            System.out.println("CHECK ALL CHECK MARK");
            glmDao.checkAllCheckMarks(listId);
        });
    }

}
