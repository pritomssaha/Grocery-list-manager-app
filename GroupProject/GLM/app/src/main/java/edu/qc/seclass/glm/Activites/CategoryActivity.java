package edu.qc.seclass.glm.Activites;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import edu.qc.seclass.glm.Adapters.CategoryRecyclerViewAdapter;
import edu.qc.seclass.glm.Models.Model_Category;
import edu.qc.seclass.glm.R;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    List<Model_Category> model_categories;
    private RecyclerView cartegory_rv;
    private CategoryRecyclerViewAdapter categoryRecyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        cartegory_rv = findViewById(R.id.cartegory_rv);
        initCategory();
        initCategoryRecyclerViewAdapter();
        findViewById(R.id.addnewcat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(CategoryActivity.this);
                builder.setTitle("Add new category");
                View viewInflated = LayoutInflater.from(CategoryActivity.this).inflate(R.layout.text_add_item, (ViewGroup) findViewById(android.R.id.content), false);
                final EditText input = (EditText) viewInflated.findViewById(R.id.input);
                builder.setView(viewInflated);

                builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        if (!input.getText().toString().equals("")){
                            String nameAdded = input.getText().toString();
                            model_categories.add(new Model_Category(nameAdded,"5"));
                        }

                    }
                });
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });
    }

    private void initCategory(){
        model_categories = new ArrayList<>();
        model_categories.add(new Model_Category(getString(R.string.dairy),"0"));
        model_categories.add(new Model_Category(getString(R.string.meat),"1"));
        model_categories.add(new Model_Category(getString(R.string.frozen),"2"));
        model_categories.add(new Model_Category(getString(R.string.fishseafood),"3"));
        model_categories.add(new Model_Category(getString(R.string.produce),"4"));

    }
    private void initCategoryRecyclerViewAdapter(){
        categoryRecyclerViewAdapter = new CategoryRecyclerViewAdapter(model_categories,"cat","cat");
        cartegory_rv.setLayoutManager(new LinearLayoutManager(this));
        cartegory_rv.setAdapter(categoryRecyclerViewAdapter);

    }
}