package com.example.rakeshyadav.menus;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ContextMenuActivity extends AppCompatActivity {

    private Button btnShowContext;
    private ConstraintLayout clMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);

        clMain = (ConstraintLayout) findViewById(R.id.clMain);
        btnShowContext = (Button) findViewById(R.id.btnShowContext);
        registerForContextMenu(btnShowContext);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menuReply: {
                Snackbar.make(clMain, "Sending Reply", Snackbar.LENGTH_SHORT).show();
                break;
            }
            case R.id.menuForward: {
                Snackbar.make(clMain, "Forwarding Selected Item", Snackbar.LENGTH_SHORT).show();
                break;
            }

            case R.id.menuDelete: {
                Snackbar.make(clMain, "Deleting Selected Item", Snackbar.LENGTH_SHORT).show();
                break;
            }

        }
        return super.onContextItemSelected(item);
    }
}
