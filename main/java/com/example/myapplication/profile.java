package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class profile extends AppCompatActivity {
    EditText ed1, ed2, ed3, ed4, ed5, ed6;
    Button b1;

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Name = "nameKey";
    public static final String Gender = "genderKey";
    public static final String Height = "heightKey";
    public static final String Weight = "weightKey";
    public static final String Age = "ageKey";
    public static final String Appmode = "appmodeKey";

    SharedPreferences sharedpreferences;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ed1 = (EditText) findViewById(R.id.name);
        ed2 = (EditText) findViewById(R.id.gender);
        ed3 = (EditText) findViewById(R.id.height);
        ed4 = (EditText) findViewById(R.id.weight);
        ed5 = (EditText) findViewById(R.id.age);
        ed6 = (EditText) findViewById(R.id.appmode);
        b1 = (Button) findViewById(R.id.profilebttn);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = ed1.getText().toString();
                String g = ed2.getText().toString();
                String h = ed3.getText().toString();
                String w = ed4.getText().toString();
                String a = ed5.getText().toString();
                String ap = ed6.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(Name, n);
                editor.putString(Gender, g);
                editor.putString(Height, h);
                editor.putString(Weight, w);
                editor.putString(Age, a);
                editor.putString(Appmode, ap);
                editor.commit();
                Toast.makeText(profile.this, "Thanks", Toast.LENGTH_LONG).show();
            }
        });
    }
}