package edu.qc.seclass.glm.Activites;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import edu.qc.seclass.glm.Adapters.CategoryRecyclerViewAdapter;
import edu.qc.seclass.glm.Adapters.ItemSearchRecyclerViewAdapterParent;
import edu.qc.seclass.glm.Models.Item_Tab;
import edu.qc.seclass.glm.Models.Model_Category;
import edu.qc.seclass.glm.Models.Model_Items;
import edu.qc.seclass.glm.Models.Model_Search_Child;
import edu.qc.seclass.glm.Models.Model_Search_Parent;
import edu.qc.seclass.glm.R;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;



import java.util.ArrayList;
import java.util.List;

public class AddItemActivity extends AppCompatActivity {
    private List<Model_Search_Parent> model_categories;
    private CategoryRecyclerViewAdapter categoryRecyclerViewAdapter;
    private RecyclerView cartegory_rv,items_rv;
    private Button createNewItem_btn,clear_btn,backToList_btn,addtolist;
    private EditText search_et;
    private ItemSearchRecyclerViewAdapterParent ItemSearchP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        addtolist = findViewById(R.id.addtolist);
        backToList_btn = findViewById(R.id.backToList_btn);
        cartegory_rv = findViewById(R.id.cartegory_rv);
        items_rv = findViewById(R.id.items_rv);

        createNewItem_btn = findViewById(R.id.createNewItem_btn);
        search_et = findViewById(R.id.search_et);
        clear_btn = findViewById(R.id.clear_btn);
        model_categories = new ArrayList<>();
        searchCategory();
        initCategory();
        initCategoryRecyclerViewAdapter();

        addtolist.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                //add the selected item to list

                finish();
            }
        });

        clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                search_et.setText("");
            }
        });

        backToList_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        createNewItem_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(AddItemActivity.this, CreateItemActivity.class);
                startActivity(intent);
            }
        });

    }

    private void searchCategory(){
        search_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    categoryRecyclerViewAdapter.getFilter().filter(s);
                }

                catch (Exception e){
                    e.getStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void initCategory(){
        model_categories.clear();
        model_categories.add(new Model_Search_Parent(getString(R.string.dairy),ChildItemList()));
        model_categories.add(new Model_Search_Parent(getString(R.string.meat),ChildItemList()));
        model_categories.add(new Model_Search_Parent(getString(R.string.frozen),ChildItemList()));
        model_categories.add(new Model_Search_Parent(getString(R.string.fishseafood),ChildItemList()));
        model_categories.add(new Model_Search_Parent(getString(R.string.produce),ChildItemList()));

    }
    private List<Model_Search_Child> ChildItemList()
    {
        List<Model_Search_Child> ChildItemList
                = new ArrayList<>();

        ChildItemList.add(new Model_Search_Child("Card 1"));
        ChildItemList.add(new Model_Search_Child("Card 2"));
        ChildItemList.add(new Model_Search_Child("Card 3"));
        ChildItemList.add(new Model_Search_Child("Card 4"));

        return ChildItemList;
    }

    private void initCategoryRecyclerViewAdapter(){
        //categoryRecyclerViewAdapter = new CategoryRecyclerViewAdapter(model_categories,"notcat",type);
        //cartegory_rv.setLayoutManager(new LinearLayoutManager(this));
        //cartegory_rv.setAdapter(categoryRecyclerViewAdapter);
        ItemSearchP = new ItemSearchRecyclerViewAdapterParent(model_categories);
        cartegory_rv.setLayoutManager(new LinearLayoutManager(this));
        cartegory_rv.setAdapter(ItemSearchP);
        ItemSearchP.notifyDataSetChanged();


    }
}