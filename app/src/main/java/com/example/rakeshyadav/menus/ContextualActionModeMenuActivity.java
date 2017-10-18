package com.example.rakeshyadav.menus;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ContextualActionModeMenuActivity extends AppCompatActivity {

    private Button btnShowContext;
    private ConstraintLayout clMain;
    private ActionMode mActionMode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contextual_menu);

        clMain = (ConstraintLayout) findViewById(R.id.clMain);
        btnShowContext = (Button) findViewById(R.id.btnShowContext);

        btnShowContext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mActionMode == null) {
                    mActionMode = startSupportActionMode(mActionModeCallback);
                    view.setSelected(true);
                }
            }
        });

        /*btnShowContext.setOnLongClickListener(new View.OnLongClickListener() {
            // Called when the user long-clicks on someView
            public boolean onLongClick(View view) {
                if (mActionMode != null) {
                    return false;
                }

                // Start the CAB using the ActionMode.Callback defined above
                mActionMode = startSupportActionMode(mActionModeCallback);
                view.setSelected(true);
                return true;
            }
        });*/
    }


    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {

        // Called when the action mode is created; startActionMode() was called
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            // Inflate a menu resource providing context menu items
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.menu_contextual_action_mode, menu);
            return true;
        }

        // Called each time the action mode is shown. Always called after onCreateActionMode, but
        // may be called multiple times if the mode is invalidated.
        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false; // Return false if nothing is done
        }

        // Called when the user selects a contextual menu item
        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            /*switch (item.getItemId()) {
                case R.id.menu_share:
                    shareCurrentItem();
                    mode.finish(); // Action picked, so close the CAB
                    return true;
                default:
                    return false;
            }*/

            return false;
        }

        // Called when the user exits the action mode
        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null;
        }
    };


}
