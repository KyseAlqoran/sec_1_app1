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
    private Spinner spnLan;
    private TextView outputText;
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
        edtName = findViewById(R.id.edtName);
        spnLan = findViewById(R.id.spnLan);
        outputText = findViewById(R.id.outputText);
        showbtn = findViewById(R.id.showbtn);

        showbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String msg = "";

                if(!name.isEmpty()) {
                    msg = "Welcome " + name;
                    msg += ", " + spnLan.getSelectedItem();
                } else {
                    msg = "Please enter your name";
                }
                outputText.setText(msg);
            }
        });
    }
}