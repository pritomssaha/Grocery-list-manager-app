package edu.qc.seclass.glm.Activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import edu.qc.seclass.glm.Adapters.DeleteUserListRecyclerViewAdapter;
import edu.qc.seclass.glm.Models.Model_Lists;
import edu.qc.seclass.glm.R;
import edu.qc.seclass.glm.database.schema.GroceryList;
import edu.qc.seclass.glm.database.schema.ListWithGroceryItems;
import edu.qc.seclass.glm.viewmodel.DeleteListVM;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import java.util.ArrayList;
import java.util.List;

public class DeleteListActivity extends AppCompatActivity {


    List<Model_Lists> model_Lists = new ArrayList<>();
    private Button deleteList_btn;
    private RecyclerView deletelists_rv;
    private DeleteListVM deleteListVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_list);

        deleteListVM = new ViewModelProvider(this).get(DeleteListVM.class);

        initViews();
        initUserLists();
        initUserListsRecyclerViewAdapter();

        deleteList_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteListVM.deleteQueued();
                Intent intent = new Intent(DeleteListActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initViews() {
        deleteList_btn = findViewById(R.id.deleteList_btn);
        deletelists_rv = findViewById(R.id.deletelists_rv);
    }

    private void initUserLists() {
        model_Lists = new ArrayList<>();
        model_Lists.add(new Model_Lists("WeeklyList", "0"));
        model_Lists.add(new Model_Lists("ExistingList", "1"));
        model_Lists.add(new Model_Lists("NewList", "2"));
    }

    private void initUserListsRecyclerViewAdapter(){

        DeleteUserListRecyclerViewAdapter deleteUserListRecyclerViewAdapter = new DeleteUserListRecyclerViewAdapter();
        deleteUserListRecyclerViewAdapter.ToggleDeletion = new DeleteUserListRecyclerViewAdapter.ToggleDeletion(){
            @Override
            public void toggleDeletion(GroceryList list) {
                deleteListVM.toggleDeletion(list);
            }
        };
        deleteListVM.getGroceryLists().observe(this, new Observer<List<ListWithGroceryItems>>() {
            @Override
            public void onChanged(List<ListWithGroceryItems> listWithGroceryItems) {
                deleteUserListRecyclerViewAdapter.setListHolder(listWithGroceryItems);
            }
        });
        deletelists_rv.setLayoutManager(new LinearLayoutManager(this));
        deletelists_rv.setAdapter(deleteUserListRecyclerViewAdapter);


    }
}

