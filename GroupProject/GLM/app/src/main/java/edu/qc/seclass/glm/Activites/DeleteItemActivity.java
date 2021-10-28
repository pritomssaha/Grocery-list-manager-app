package edu.qc.seclass.glm.Activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import edu.qc.seclass.glm.Adapters.DeleteItemRecyclerViewAdapter;
import edu.qc.seclass.glm.Models.Model_Items;
import edu.qc.seclass.glm.R;

import android.os.Bundle;
import android.widget.Button;


import java.util.ArrayList;
import java.util.List;

public class DeleteItemActivity extends AppCompatActivity {
    private List<Model_Items> model_items;
    private RecyclerView deleteItem_rv;
    Button deleteList_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_item);
        deleteItem_rv = findViewById(R.id.deleteItem_rv);
        deleteList_btn = findViewById(R.id.deleteList_btn);
        initItems();
        initDeleteItemsRecyclerViewAdapter();

    }

    private void initItems(){
        model_items = new ArrayList<>();
        if (getIntent()!=null){
            model_items.addAll((List<Model_Items>) getIntent().getSerializableExtra("list"));
        }

//        model_items.add(new Model_Items("Apple",""));
//        model_items.add(new Model_Items("Milk",""));
//        model_items.add(new Model_Items("Egg",""));
    }
    private void initDeleteItemsRecyclerViewAdapter(){
        DeleteItemRecyclerViewAdapter deleteItemRecyclerViewAdapter = new DeleteItemRecyclerViewAdapter(model_items,deleteList_btn);
        deleteItem_rv.setLayoutManager(new LinearLayoutManager(this));
        deleteItem_rv.setAdapter(deleteItemRecyclerViewAdapter);
    }
}