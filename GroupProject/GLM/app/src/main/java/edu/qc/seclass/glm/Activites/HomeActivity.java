package edu.qc.seclass.glm.Activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import edu.qc.seclass.glm.Adapters.UserListsRecyclerViewAdapter;
import edu.qc.seclass.glm.Models.Model_Lists;
import edu.qc.seclass.glm.R;
import edu.qc.seclass.glm.database.schema.ListWithGroceryItems;
import edu.qc.seclass.glm.viewmodel.GLMViewModel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private Button newList_btn;
    private Button deleteList_btn;
    private RecyclerView lists_rv;
    List<Model_Lists> model_Lists = new ArrayList<>();

    private GLMViewModel glmViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViews();
        glmViewModel = new ViewModelProvider(this).get(GLMViewModel.class);

        newList_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CreateNewListActivity.class);
                startActivity(intent);
            }
        });

        deleteList_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, DeleteListActivity.class);
                startActivity(intent);
            }
        });
        initUserLists();
        initUserListsRecyclerViewAdapter();
    }

    private void initViews() {
        newList_btn = findViewById(R.id.newList_btn);
        deleteList_btn = findViewById(R.id.deleteList_btn);
        lists_rv = findViewById(R.id.lists_rv);

    }

    private void initUserLists() {
        model_Lists = new ArrayList<>();
        model_Lists.add(new Model_Lists("WeeklyList", "0"));
        model_Lists.add(new Model_Lists("ExistingList", "1"));
        model_Lists.add(new Model_Lists("NewList", "2"));
    }

    private void initUserListsRecyclerViewAdapter() {

//        UserListsRecyclerViewAdapter userListsRecyclerViewAdapter = new UserListsRecyclerViewAdapter(model_Lists);
//        lists_rv.setLayoutManager(new LinearLayoutManager(this));
//        lists_rv.setAdapter(userListsRecyclerViewAdapter);

        UserListsRecyclerViewAdapter userListsRecyclerViewAdapter = new UserListsRecyclerViewAdapter();
        userListsRecyclerViewAdapter.renameList = new UserListsRecyclerViewAdapter.RenameList() {
            @Override
            public void renameList(ListWithGroceryItems list, String newName) {
                glmViewModel.renameList(list, newName);
            }
        };

        glmViewModel.getGroceryLists().observe(this, new Observer<List<ListWithGroceryItems>>() {
            @Override
            public void onChanged(List<ListWithGroceryItems> listWithGroceryItems) {
                userListsRecyclerViewAdapter.setListHolder(listWithGroceryItems);
            }
        });

        lists_rv.setLayoutManager(new LinearLayoutManager(this));
        lists_rv.setAdapter(userListsRecyclerViewAdapter);


    }
}