package edu.qc.seclass.glm.Activites;

import androidx.appcompat.app.AppCompatActivity;
import edu.qc.seclass.glm.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class CreateItemActivity extends AppCompatActivity {
    private Button confirmItemName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_item);
        confirmItemName = findViewById(R.id.confirmItemName);


        confirmItemName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateItemActivity.this,CategoryActivity.class);
                startActivity(intent);
            }
        });
    }
}