package com.example.exercise3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button addButton;
    ListView namesListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButton = findViewById(R.id.buttonAdd);
        namesListView = findViewById(R.id.listViewNames);
        updateList();
        DataModel.getInstance().loadData(MainActivity.this);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataModel.getInstance().itemSelected = -1;
                Intent intent = new
                        Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
        namesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                DataModel.getInstance().itemSelected = i;
                Intent intent = new
                        Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
        namesListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                DataModel.getInstance().names.remove(position);
                DataModel.getInstance().phone.remove(position);
                DataModel.getInstance().age.remove(position);
                DataModel.getInstance().address.remove(position);

                updateList();//update after delating
                return true;//it wont jump to second window
            }
        });
    }
    protected  void onResume(){
        super.onResume();
        updateList();
    }

    void updateList(){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                DataModel.getInstance().names
        );
        namesListView.setAdapter(adapter);
    }

}
