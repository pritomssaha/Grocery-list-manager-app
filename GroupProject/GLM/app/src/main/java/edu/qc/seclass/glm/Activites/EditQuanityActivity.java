package edu.qc.seclass.glm.Activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import edu.qc.seclass.glm.Adapters.EditItemQuanityRecyclerViewAdapter;
import edu.qc.seclass.glm.Models.Item_Tab;
import edu.qc.seclass.glm.Models.Model_Items;
import edu.qc.seclass.glm.R;

import android.os.Bundle;
import android.widget.Button;


import java.util.ArrayList;
import java.util.List;

public class EditQuanityActivity extends AppCompatActivity {
    private List<Item_Tab> model_items;
    private EditItemQuanityRecyclerViewAdapter editItemQuanityRecyclerViewAdapter;
    private RecyclerView edit_quanity_rv;
    private Button edit_quanity_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_quanity);
        edit_quanity_rv = findViewById(R.id.editQuanity_rv);
        edit_quanity_btn = findViewById(R.id.editQuanity_btn);

        initItems();
        initItemRecyclerViewAadapter();


    }

    private void initItems() {
        model_items = new ArrayList<>();
        model_items.addAll((List<Item_Tab>) getIntent().getSerializableExtra("list"));

    }

    private void initItemRecyclerViewAadapter() {
        editItemQuanityRecyclerViewAdapter = new EditItemQuanityRecyclerViewAdapter(model_items);
        edit_quanity_rv.setLayoutManager(new LinearLayoutManager(this));
        edit_quanity_rv.setAdapter(editItemQuanityRecyclerViewAdapter);
    }
}