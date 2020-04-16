# Mobile-Programming
We want to make an application simillar to email application.
## Prerequisites
* Android Studio
* Android SKD
* JDK
* Android Emulator
* JRE
* Gradle
# Starting up
First of all, we create 'login.java' class
```
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button b1,b2, b3;
    EditText ed1,ed2;

    TextView tx1;
    int counter = 3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        b1 = (Button)findViewById(R.id.btn_login);
        ed1 = (EditText)findViewById(R.id.et_email);
        ed2 = (EditText)findViewById(R.id.et_password);

        b2 = (Button)findViewById(R.id.btn_cancel);
        tx1 = (TextView)findViewById(R.id.attempts);

        tx1.setVisibility(View.GONE);

        b3 = (Button)findViewById(R.id.btn_register);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1.getText().toString().equals("admin") &&
                        ed2.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();

                    tx1.setVisibility(View.VISIBLE);
                    tx1.setBackgroundColor(Color.RED);
                    counter--;
                    tx1.setText(Integer.toString(counter));

                    if (counter == 0) {
                        b1.setEnabled(false);
                    }
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });
    }
}
```
After creating the login class we need to define its design in xml we call it `activity_login`
```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".activity_login">

    <TextView
        android:id="@+id/tv_title"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Login"
        android:textSize="50sp"
        android:fontFamily="@font/indigo_daisy"
        android:layout_marginStart="25dp"
        android:layout_marginBottom="10dp"
        android:layout_above="@id/et_email"/>


    <EditText
        android:id="@+id/et_email"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:hint="e-mail"
        android:layout_marginLeft="20dp"
        android:layout_marginRight="20dp"
        android:padding="15dp"
        android:inputType="textEmailAddress"
        android:fontFamily="@font/roboto_regular"
        android:layout_above="@id/et_password"
        android:background="@drawable/et_custom"
        android:textSize="15sp" />

    <EditText
        android:id="@+id/et_password"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:hint="password"
        android:layout_marginLeft="20dp"
        android:layout_marginRight="20dp"
        android:layout_marginTop="10dp"
        android:padding="15dp"
        android:fontFamily="@font/roboto_regular"
        android:inputType="textPassword"
        android:layout_centerInParent="true"
        android:background="@drawable/et_custom"
        android:textSize="15sp" />

    <TextView
        android:id="@+id/attempts"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Attempts Left:"
        android:textSize="20dp"
        android:fontFamily="@font/indigo_daisy"
        android:layout_marginStart="25dp"
        android:layout_marginBottom="10dp"
        android:layout_below="@+id/btn_cancel"/>

    <Button
        android:id="@+id/btn_login"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/et_password"
        android:background="@drawable/btn_custom"
        android:layout_marginLeft="20dp"
        android:layout_marginRight="20dp"
        android:layout_marginTop="15dp"
        android:fontFamily="@font/roboto_regular"
        android:textColor="@android:color/white"
        android:text="Login"/>

    <Button
        android:id="@+id/btn_cancel"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/btn_register"
        android:background="@drawable/btn_custom"
        android:layout_marginLeft="20dp"
        android:layout_marginRight="20dp"
        android:layout_marginTop="15dp"
        android:fontFamily="@font/roboto_regular"
        android:textColor="@android:color/white"
        android:text="Cancel" />

    <Button
        android:id="@+id/btn_register"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/btn_login"
        android:background="@drawable/btn_custom"
        android:layout_marginLeft="20dp"
        android:layout_marginRight="20dp"
        android:layout_marginTop="15dp"
        android:fontFamily="@font/roboto_regular"
        android:textColor="@android:color/white"
        android:text="Register" />
</RelativeLayout>
```
The result design will be similar to ![picture alt](http://via.placeholder.com/200x150 "Title is optional")
Login activity will lead us to register activity, so we create `register.java`
