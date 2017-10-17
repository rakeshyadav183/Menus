package com.example.rakeshyadav.menus;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.lang.reflect.Method;

public class SimpleMenuActivity extends AppCompatActivity {

    private ConstraintLayout clMain;
    private boolean isItem3Removed, isItem2Visible = true, addNewItem, removeGroup;
    private int itemId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_menu);
        clMain = (ConstraintLayout) findViewById(R.id.clMain);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.simple_menu, menu);

        if (isItem3Removed) {
            menu.removeItem(R.id.item3);
        }

        if (!isItem2Visible) {
            menu.findItem(R.id.item2).setVisible(false);
        }

        if (addNewItem) {
            //(GroupId, ItemId, Order, Title)
            for (int i = 0; i < itemId; i++) {
                if(i == 0) {
                    menu.add(Menu.NONE, i + 1, Menu.NONE, "Remove Group");
                }else {
                    menu.add(Menu.NONE, i + 1, Menu.NONE, "New Item " + (i + 1));
                }
            }
        }

        if(removeGroup) {
            menu.removeGroup(R.id.group);
        }
        return true;
    }

    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        if (menu != null) {
            if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
                try {
                    Method m = menu.getClass().getDeclaredMethod(
                            "setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (Exception e) {
                    Log.e(getClass().getSimpleName(),
                            "onMenuOpened...unable to set icons for overflow menu",
                            e);
                }
            }
        }
        return super.onPrepareOptionsPanel(view, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1: {

                Snackbar.make(clMain, "Item 1 Clicked, Item 2 Invisible", Snackbar.LENGTH_SHORT).show();
                isItem2Visible = false;
                invalidateOptionsMenu();
                break;
            }

            case R.id.item2: {
                Snackbar.make(clMain, "Item 2 Clicked", Snackbar.LENGTH_SHORT).show();
                break;
            }

            case R.id.item3: {
                Snackbar.make(clMain, "Item 3 Clicked, Removing Item 3", Snackbar.LENGTH_SHORT).show();
                //menu.removeItem(R.id.item3);
                isItem3Removed = true;
                invalidateOptionsMenu();
                break;
            }

            case R.id.groupItem1: {
                Snackbar.make(clMain, "Group Item 1 Clicked, Item 2 Visible", Snackbar.LENGTH_SHORT).show();
                isItem2Visible = true;
                invalidateOptionsMenu();
                break;
            }

            case R.id.groupItem2: {
                Snackbar.make(clMain, "Group Item 2 Clicked, new Item Added", Snackbar.LENGTH_SHORT).show();
                addNewItem = true;
                itemId ++;
                invalidateOptionsMenu();
                break;
            }

            case R.id.groupItem3: {
                Snackbar.make(clMain, "Group Item 3 Clicked", Snackbar.LENGTH_SHORT).show();
                break;
            }

            case 1: {
                Snackbar.make(clMain, "New Item 1 clicked, removing group", Snackbar.LENGTH_SHORT).show();
                removeGroup = true;
                invalidateOptionsMenu();
                break;

            }
        }

        return false;
    }
}
