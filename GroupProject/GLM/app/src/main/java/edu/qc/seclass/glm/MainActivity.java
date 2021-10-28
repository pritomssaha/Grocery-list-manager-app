package edu.qc.seclass.glm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import edu.qc.seclass.glm.Activites.HomeActivity;
import edu.qc.seclass.glm.database.schema.ListWithGroceryItems;
import edu.qc.seclass.glm.viewmodel.EditQuantityVMFactory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button loginBtn;
    private EditQuantityVMFactory editQuantityVMFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        initViews();
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();

        //login_btn listner
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

//        glmViewModel.getGroceryLists().observe(this, new Observer<List<ListWithGroceryItems>>() {
//            @Override
//            public void onChanged(List<ListWithGroceryItems> listWithGroceryItems) {
//                userListsRecyclerViewAdapter.setListHolder(listWithGroceryItems);
//            }
//        });
    }

    private void initViews() {
        loginBtn = findViewById(R.id.login_btn);
    }
}