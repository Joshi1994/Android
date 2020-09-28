package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Store_load obj = new Store_load();
    Button addButton;
    ListView namesListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        addButton = findViewById(R.id.buttonAdd);
        namesListView = findViewById(R.id.listViewNames);


        //



        updateList();
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataModel.getInstance().itemSelected = -1;
                Intent intent = new
                        Intent(MainActivity.this,
                        DetailActivity.class);
                startActivity(intent);
            }
        });
        namesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int i, long l) {
                DataModel.getInstance().itemSelected = i;
                Intent intent = new
                        Intent(MainActivity.this,
                        DetailActivity.class);
                startActivity(intent);
            }
        });



        namesListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> arg0, View v,
                                           int i, long id) {

                DataModel.getInstance().names.remove(i);
                DataModel.getInstance().age.remove(i);
                DataModel.getInstance().address.remove(i);
                DataModel.getInstance().phnumber.remove(i);


                updateList();
                return true;

            }

        });

    }

    @Override
    protected void onResume() {
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
