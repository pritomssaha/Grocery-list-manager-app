package edu.qc.seclass.glm.Activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import edu.qc.seclass.glm.R;
import edu.qc.seclass.glm.viewmodel.GLMViewModel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class CreateNewListActivity extends AppCompatActivity {
    private GLMViewModel glmViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_list);


        glmViewModel = new ViewModelProvider(this).get(GLMViewModel.class);
        EditText newNameTextBox = findViewById(R.id.listName_et);
        Button CreateList = findViewById(R.id.createList_btn);
        CreateList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                glmViewModel.addList(newNameTextBox.getText().toString());
                finish();
            }
        });
    }
}