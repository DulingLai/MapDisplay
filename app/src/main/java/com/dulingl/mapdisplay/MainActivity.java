package com.dulingl.mapdisplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateListView();
        registerClickCallback();
    }

    private void populateListView() {
        // Creat list of items
        String[] listItems = {"restaurant","school","bank","hospital"};

        // Build Adapter
        ArrayAdapter<String> ListAdapter = new ArrayAdapter<String>(this,R.layout.list_layout,listItems);

        // Configure the list view
        ListView list=(ListView) findViewById(R.id.listViewMain);
        list.setAdapter(ListAdapter);
    }

    private void registerClickCallback() {
        ListView list=(ListView) findViewById(R.id.listViewMain);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                String selectedCategory = textView.getText().toString();
                String message = "Displaying " + selectedCategory + " nearby";
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
                Intent intent_selected = new Intent(MainActivity.this,RestaurantsOnMap.class);
                intent_selected.putExtra("selectedCategory",selectedCategory);
                startActivity(intent_selected);
            }
        });
    }
}
