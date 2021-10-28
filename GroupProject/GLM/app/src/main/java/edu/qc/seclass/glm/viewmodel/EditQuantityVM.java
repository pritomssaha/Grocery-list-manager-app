package edu.qc.seclass.glm.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.qc.seclass.glm.Adapters.ItemsQunaityRecyclerViewAdapterChild;
import edu.qc.seclass.glm.database.GLMDao;
import edu.qc.seclass.glm.database.GLMRepository;
import edu.qc.seclass.glm.database.schema.CategoryWithDetailedGroceryItems;
import edu.qc.seclass.glm.database.schema.GroceryItem;
import edu.qc.seclass.glm.database.schema.GroceryItemWithItem;
import edu.qc.seclass.glm.database.schema.GroceryList;
import edu.qc.seclass.glm.database.schema.Item;
import edu.qc.seclass.glm.database.schema.ListWithGroceryItems;
import edu.qc.seclass.glm.database.schema.TypeWithGroceryItem;

// Use factory for this model
public class EditQuantityVM extends AndroidViewModel {
        private GLMRepository repository;
        private LiveData<List<GroceryItem>> groceryItems;
        private int listId = -1;

        public EditQuantityVM(Application application, int listId) {
            super(application);
            System.out.println("PRINTING ListID");
            System.out.println(listId);
            repository = new GLMRepository(application);
            groceryItems = repository.displayList(listId);
        }


    public LiveData<List<GroceryItem>> getGroceryItems() {
            return groceryItems;
        }
        public LiveData<Item> getItemById(int id){
            return repository.getItemById(id);
        }

        public void setChecked(GroceryItem item){

//            System.out.println(listId + " " + itemIndex + " " + groceryItems.getValue().get(itemIndex).itemId);
//            System.out.println(repository.getGroceryItem(listId,groceryItems.getValue().get(itemIndex).itemId));
            repository.flipCheckState(item);
        }

        public void checkAll(int listId){
            repository.checkAllCheckMark(listId);
        }
        public void uncheckAll(int listId){
            repository.clearAllCheckMark(listId);
        }

        public void deleteGroceryItem(GroceryItem item){
            repository.deleteGroceryItem(item);
        }


}
