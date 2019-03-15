package com.concordia.cejv669.sharedprefs1;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nameTxt = findViewById(R.id.edit_name);
        EditText productTxt = findViewById(R.id.edit_product);
        RatingBar rating = findViewById(R.id.ratingBar);

        SharedPreferences sharedpreferences = getSharedPreferences("com.prefmgr.demo2",
                Context.MODE_PRIVATE);

        if (sharedpreferences.contains("username")){
            TextView tvname = findViewById(R.id.txt_begin);
            tvname.setText(sharedpreferences.getString("username","N/A"));
            nameTxt.setText(sharedpreferences.getString("username","N/A"));
        }

        if(sharedpreferences.contains("productname")){
            productTxt.setText(sharedpreferences.getString("productname","N/A"));
        }

        if(sharedpreferences.contains("rating")){
            rating.setRating(sharedpreferences.getFloat("rating",0));
        }

        Button b = findViewById(R.id.btn_save);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nameTxt = findViewById(R.id.edit_name);
                EditText productTxt = findViewById(R.id.edit_product);
                RatingBar rating = findViewById(R.id.ratingBar);

                SharedPreferences sharedpreferences = getSharedPreferences("com.prefmgr.demo2",
                        Context.MODE_PRIVATE);

                if (sharedpreferences.contains("username")){
                    TextView tvname = findViewById(R.id.txt_begin);
                    tvname.setText(sharedpreferences.getString("username","N/A"));
                }

                //apply is a little bit faster than commit

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString("username", nameTxt.getText().toString());
                editor.putString("productname", productTxt.getText().toString());
                editor.putFloat("rating",rating.getRating());

                editor.commit();
            }
        });
    }
}
