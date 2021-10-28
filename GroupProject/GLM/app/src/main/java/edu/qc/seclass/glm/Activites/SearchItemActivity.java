package edu.qc.seclass.glm.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import edu.qc.seclass.glm.R;
import edu.qc.seclass.glm.database.schema.ListWithGroceryItems;
import edu.qc.seclass.glm.viewmodel.GLMViewModel;

import java.util.ArrayList;
import java.util.List;

public class SearchItemActivity extends AppCompatActivity {
    private Button searchCancel;
    private Button search_btn;
    private EditText searchInput;
    //private RecyclerView Search_Box;
    private String Input = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_item);
        initViews();

        searchCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchItemActivity.this, ListDetailsActivity.class);
                startActivity(intent);
            }
        });

        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(ListDetailsActivity.this,EditQuanityActivity.class);
                //startActivity(intent);
            }
        });
    }

    private void initViews() {
        searchCancel = findViewById(R.id.searchCancel);
        search_btn = findViewById(R.id.search_btn);
        searchInput = findViewById(R.id.searchInput);
        //Search_Box = findViewById(R.id.Search_Box);
        Input = searchInput.getText().toString();

    }
}