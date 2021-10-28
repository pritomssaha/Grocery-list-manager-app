package edu.qc.seclass.glm.viewmodel;

import android.app.Application;
import android.text.Editable;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.qc.seclass.glm.database.GLMRepository;
import edu.qc.seclass.glm.database.schema.GroceryList;
import edu.qc.seclass.glm.database.schema.ListWithGroceryItems;

public class GLMViewModel extends AndroidViewModel {
    private GLMRepository repository;
    private LiveData<List<ListWithGroceryItems>> groceryLists;

    public GLMViewModel(Application application) {
        super(application);

        repository = new GLMRepository(application);
        groceryLists = repository.getLists();
    }

    public LiveData<List<ListWithGroceryItems>> getGroceryLists() {
        return groceryLists;
    }

    public void addList(String name) {
        repository.addList(name);
    }

    public void addItem(String name, Integer typeId) {
        repository.addItem(name, typeId);
    }

    public void addType(String name) {
        repository.addType(name);
    }

    public void deleteAllLists() {
        repository.deleteAllLists();
    }

    public void deleteList(GroceryList groceryList){
        repository.deleteList(groceryList);
    }
    public void renameList(ListWithGroceryItems listWithGroceryItems, String newName){
        repository.renameList(listWithGroceryItems.list, newName);
    }
}