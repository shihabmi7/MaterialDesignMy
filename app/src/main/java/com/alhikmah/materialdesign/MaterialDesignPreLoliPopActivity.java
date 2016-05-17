package com.alhikmah.materialdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.rey.material.widget.Button;

public class MaterialDesignPreLoliPopActivity extends AppCompatActivity {


    /*
            material with Pre lolipop
    */
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_design_pre_loli_pop);


        button = (Button) findViewById(R.id.but_material);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_LONG).show();
            }
        });

    }
}
