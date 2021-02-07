package com.example.elegantmedia;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DetailActivity extends AppCompatActivity{


    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setTitle(R.string.detailTitle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        description = findViewById(R.id.itemDescription);

        //get Clicked itemID
        Intent i = getIntent();
        int item = i.getIntExtra("itemList", 0);
        Log.d("hello", "heloooooooooooooooooo" + item);

        description.setText(String.valueOf(item));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //go to Map
    public void onMapClick(MenuItem item){
        Intent intent = new Intent(this, MapActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}