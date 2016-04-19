package com.alhikmah.materialdesign;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.Button;


/*
    SnackBar Only
*/
public class SnackBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("SnackBarActivity");
        setSupportActionBar(toolbar);


        Button button = (Button) findViewById(R.id.button_snack);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // can use the coordinator id as view
                // findViewById(R.id.myCoordinatorLayout)
                Snackbar.make(v, "SnackBar Example", Snackbar.LENGTH_INDEFINITE)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        }).show();
            }
        });

    }

}
