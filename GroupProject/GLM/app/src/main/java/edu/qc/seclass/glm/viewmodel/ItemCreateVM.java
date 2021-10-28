package edu.qc.seclass.glm.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.qc.seclass.glm.database.GLMRepository;
import edu.qc.seclass.glm.database.schema.ItemType;

public class ItemCreateVM extends AndroidViewModel {
    private GLMRepository repository;
    private LiveData<List<ItemType>> typeList;

    public ItemCreateVM(Application application) {
        super(application);

        repository = new GLMRepository(application);
        typeList = repository.getTypes();
    }

    public void addItem(String itemName, int typeId) {
        repository.addItem(itemName, typeId);
    }

    public void addCategory(String categoryName) {
        repository.addType(categoryName);
    }

    public LiveData<List<ItemType>> getCategories() {
        return typeList;
    }
}
