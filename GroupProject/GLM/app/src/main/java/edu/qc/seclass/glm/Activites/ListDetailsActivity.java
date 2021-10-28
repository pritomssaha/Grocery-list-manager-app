package edu.qc.seclass.glm.Activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import edu.qc.seclass.glm.Adapters.ItemsQunaityRecyclerViewAdapterChild;
import edu.qc.seclass.glm.Adapters.ItemsQunaityRecyclerViewAdapterParent;
import edu.qc.seclass.glm.Models.Item_Tab;
import edu.qc.seclass.glm.Models.Model_Items;
import edu.qc.seclass.glm.R;
import edu.qc.seclass.glm.database.schema.CategoryWithDetailedGroceryItems;
import edu.qc.seclass.glm.database.schema.GroceryItem;
import edu.qc.seclass.glm.database.schema.GroceryItemWithItem;
import edu.qc.seclass.glm.database.schema.Item;
import edu.qc.seclass.glm.database.schema.TypeWithGroceryItem;
import edu.qc.seclass.glm.viewmodel.EditQuantityVM;
import edu.qc.seclass.glm.viewmodel.EditQuantityVMFactory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;


import java.util.ArrayList;
import java.util.List;

public class ListDetailsActivity extends AppCompatActivity {
    private List<Model_Items> model_itemsList;
    private RecyclerView item_rv;
    private Button edit_quanity_btn, addItem_btn, selectAll_btn, unSlectAll_btn, userLists_btn;
    private char checks = 'N';
    private ItemsQunaityRecyclerViewAdapterParent itemsQunaityRecyclerViewAdapterParent;
    RadioGroup rdgroup;
    String type = "cat";
    private EditQuantityVM editQuantityVM;
    private int listId = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_details);
        item_rv = findViewById(R.id.item_rv);
        selectAll_btn = findViewById(R.id.selectAll_btn);
        unSlectAll_btn = findViewById(R.id.unSlectAll_btn);
        edit_quanity_btn = findViewById(R.id.editQuanity_btn);
        userLists_btn = findViewById(R.id.userLists_btn);
        addItem_btn = findViewById(R.id.addItem_btn);
        model_itemsList = new ArrayList<>();
        listId = getIntent().getIntExtra("EXTRA_LIST_ID", -1);
//        initData();

        initItemRecyclerViewAdapter();


        userLists_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        selectAll_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(listId);
                editQuantityVM.checkAll(listId);
//                itemsQunaityRecyclerViewAdapterParent.notifyDataSetChanged();
            }
        });
        unSlectAll_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editQuantityVM.uncheckAll(listId);
//                itemsQunaityRecyclerViewAdapterParent.notifyDataSetChanged();
            }
        });

        addItem_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListDetailsActivity.this, AddItemActivity.class);
                startActivity(intent);

            }
        });


    }


//    private void initData() {
//        model_itemsList.clear();
//        model_itemsList.add(new Model_Items(getString(R.string.dairy), ChildItemList()));
//        model_itemsList.add(new Model_Items(getString(R.string.meat), ChildItemList()));
//        model_itemsList.add(new Model_Items(getString(R.string.frozen), ChildItemList()));
//        model_itemsList.add(new Model_Items(getString(R.string.fishseafood), ChildItemList()));
//        model_itemsList.add(new Model_Items(getString(R.string.produce), ChildItemList()));
//
//    }

    private List<Item_Tab> ChildItemList() {
        List<Item_Tab> ChildItemList
                = new ArrayList<>();

        ChildItemList.add(new Item_Tab("Card 1", "1"));
        ChildItemList.add(new Item_Tab("Card 2", "3"));
        ChildItemList.add(new Item_Tab("Card 3", "6"));
        ChildItemList.add(new Item_Tab("Card 4", "4"));

        return ChildItemList;
    }

    private void initItemRecyclerViewAdapter() {
        itemsQunaityRecyclerViewAdapterParent = new ItemsQunaityRecyclerViewAdapterParent();
        item_rv.setLayoutManager(new LinearLayoutManager(this));
        item_rv.setAdapter(itemsQunaityRecyclerViewAdapterParent);


//        itemsQunaityRecyclerViewAdapterParent.notifyDataSetChanged();
        editQuantityVM = new ViewModelProvider(this, new EditQuantityVMFactory(this.getApplication(), listId)).get(EditQuantityVM.class);

        itemsQunaityRecyclerViewAdapterParent.itemCheckedListener = item -> {
            editQuantityVM.setChecked(item);
        };

        itemsQunaityRecyclerViewAdapterParent.itemDeleteListener = item -> {
            System.out.println("DELETE ITEM LISTENER");
            System.out.println(item);
            editQuantityVM.deleteGroceryItem(item);
        };



        editQuantityVM.getGroceryItems().observe(this, new Observer<List<GroceryItem>>() {
            @Override
            public void onChanged(List<GroceryItem> groceryItemWithItems) {
                model_itemsList.clear();

                model_itemsList.add(new Model_Items("category", groceryItemWithItems));

                itemsQunaityRecyclerViewAdapterParent.setModelList(model_itemsList);
                System.out.println(groceryItemWithItems);
                itemsQunaityRecyclerViewAdapterParent.notifyDataSetChanged();
            }
        });


    }
}
