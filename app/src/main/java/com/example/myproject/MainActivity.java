package com.example.myproject;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myproject.dataaccess.PLDataAccess;

import java.sql.Array;

public class MainActivity extends AppCompatActivity {
    private EditText edtName;
    private Spinner spnPL;
    private TextView txtResult;
    private Button showbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupViews();
        // This is new code for testing ...
        // for GitHub

        showbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String name = edtName.getText().toString();
               String msg = "";

               if(!name.isEmpty()) {
                   msg = "Welcome " + name;
                   msg += ", " + spnPL.getSelectedItem().toString();
               } else {
                   msg = "Please enter your name";
               }

               txtResult.setText(msg);
           }
        });
    }

    private void setupViews() {
        edtName = findViewById(R.id.edtName);
        spnPL = findViewById(R.id.spnPL);
        txtResult = findViewById(R.id.txtResult);
        showbtn = findViewById(R.id.showbtn);

        String[] arrPL = PLDataAccess.getPL();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_spinner_item, arrPL);

        spnPL.setAdapter(adapter);
    }

}