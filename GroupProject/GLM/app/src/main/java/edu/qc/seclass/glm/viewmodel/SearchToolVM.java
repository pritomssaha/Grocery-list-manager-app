package edu.qc.seclass.glm.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import java.util.List;

import edu.qc.seclass.glm.database.GLMRepository;
import edu.qc.seclass.glm.database.schema.Item;
import edu.qc.seclass.glm.database.schema.ItemsOfType;
import edu.qc.seclass.glm.database.schema.ListWithGroceryItems;

// https://developer.android.com/reference/android/arch/lifecycle/Transformations
// https://stackoverflow.com/a/49669526
public class SearchToolVM extends AndroidViewModel {
    private GLMRepository repository;
    private LiveData<List<Item>> itemList;
    private MutableLiveData<QueryContainer> filter = new MutableLiveData<>();

    enum QueryType {
        ALL,
        TYPE,
        NAME
    }

    class QueryContainer {
        private QueryType type;
        private String queryString;

        QueryContainer(QueryType type, String queryString) {
            this.type = type;
            this.queryString = queryString;
        }

        public QueryType getType() {
            return type;
        }

        public String getQueryString() {
            return queryString;
        }
    }


    public SearchToolVM(Application application) {
        super(application);

        repository = new GLMRepository(application);

        itemList = repository.getItems(); // returns observer class


    }

    public void addItem(String name, Integer typeId) {
        repository.addItem(name, typeId);
    }

    public void searchByName(String name) {
        filter.setValue(new QueryContainer(QueryType.NAME, name));
    }

    public void searchByType(String type) {
        filter.setValue(new QueryContainer(QueryType.TYPE, type));
    }

    public void listAllItems() {
        filter.setValue(new QueryContainer(QueryType.ALL, null));
    }

    public LiveData<List<Item>> getFilteredList() {

        return Transformations.switchMap(
                filter,
                query -> {
                    LiveData<List<Item>> filterList = null;
                    if (query.getType() == QueryType.NAME) {
                        filterList = repository.getItemsByName(query.queryString);

                    } else if (query.getType() == QueryType.TYPE) {
                        filterList = repository.getItemsByTypeName(query.queryString);
                    } else {
                        filterList = repository.getItems();
                    }

                    return filterList;
                });
    }
}
