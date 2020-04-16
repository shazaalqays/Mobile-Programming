package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;

public class opmenu extends AppCompatActivity {

    Button popupButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        popupButton = findViewById(R.id.popup);
        popupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupMenu();
            }
        });
    }

    private void popupMenu() {
        PopupMenu p = new PopupMenu(opmenu.this, popupButton);
        p.getMenuInflater().inflate(R.menu.activity_menu, p .getMenu());
        p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profile:
                        startActivity(new Intent(opmenu.this, profile.class));
                        return true;
                    case R.id.email:
                        startActivity(new Intent(opmenu.this, sendEmail.class));
                        return true;
                    case R.id.note:
                        startActivity(new Intent(opmenu.this, AddNote.class));
                        return true;
                    case R.id.contacts:
                        startActivity(new Intent(opmenu.this, contacts.class));
                        return true;
                    case R.id.settings:
                        startActivity(new Intent(opmenu.this, settings.class));
                        return true;
                    case R.id.logout:
                        finish();
                        return true;
                    default:
                        return super.onMenuItemClick(item);
                }
            }
        });
    }

}
