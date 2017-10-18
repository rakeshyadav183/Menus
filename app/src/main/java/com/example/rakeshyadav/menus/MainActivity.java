package com.example.rakeshyadav.menus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnSimpleMenu, btnSubmenu, btnContextMenu, btnContextualActionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSimpleMenu = (Button) findViewById(R.id.btnSimpleMenu);
        btnSubmenu = (Button) findViewById(R.id.btnSubmenu);
        btnContextMenu = (Button) findViewById(R.id.btnContextMenu);
        btnContextualActionMode = (Button) findViewById(R.id.btnContextualActionMode);

        btnSimpleMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SimpleMenuActivity.class));
            }
        });

        btnSubmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SubmenuActivity.class));
            }
        });

        btnContextMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ContextMenuActivity.class));
            }
        });

        btnContextualActionMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ContextualActionModeMenuActivity.class));
            }
        });
    }
}
