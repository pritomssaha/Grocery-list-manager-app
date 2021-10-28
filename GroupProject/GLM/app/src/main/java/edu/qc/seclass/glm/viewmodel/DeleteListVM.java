package edu.qc.seclass.glm.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

import edu.qc.seclass.glm.database.GLMRepository;
import edu.qc.seclass.glm.database.schema.GroceryList;
import edu.qc.seclass.glm.database.schema.ListWithGroceryItems;

public class DeleteListVM extends AndroidViewModel {

        private GLMRepository repository;
        private LiveData<List<ListWithGroceryItems>> groceryLists;
        private List<GroceryList> queuedDelete = new ArrayList<>();

        public DeleteListVM(Application application) {
            super(application);

            repository = new GLMRepository(application);
            groceryLists = repository.getLists();
        }

        public LiveData<List<ListWithGroceryItems>> getGroceryLists() {
            return groceryLists;
        }

        public void deleteQueued(){
            for(int i = 0; i < queuedDelete.size(); i++){
                repository.deleteList(queuedDelete.get(i));
            }
        }

    public void toggleDeletion(GroceryList groceryList){
            if(this.queuedDelete.contains(groceryList)){
                this.queuedDelete.remove(groceryList);
            }else{
                this.queuedDelete.add(groceryList);
            }

    }
}
