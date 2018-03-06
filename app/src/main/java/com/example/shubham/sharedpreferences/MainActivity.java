package com.example.shubham.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etname , etroll;
    Button btns , btnr;
    TextView tvres;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences=this.getSharedPreferences("MyInfo" , MODE_PRIVATE);
        editor = sharedPreferences.edit();

        etname = findViewById(R.id.etname);
        etroll = findViewById(R.id.etroll);

        btns= findViewById(R.id.btns);
        btnr = findViewById(R.id.btnr);

        tvres= findViewById(R.id.tvres);

        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=etname.getText().toString();
                String rollno=etroll.getText().toString();
                editor.putString("Name", name);
                editor.putString("Roll", rollno);
                editor.commit();

            }
        });
        btnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getName=sharedPreferences.getString("Name" , "");
                String getRoll=sharedPreferences.getString("Roll" , "");
                tvres.setText("Name : "+getName+"\n"+"Roll No."+getRoll);

            }
        });

    }
}
