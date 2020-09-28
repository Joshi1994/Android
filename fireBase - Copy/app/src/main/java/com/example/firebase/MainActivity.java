package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button addButton;
    EditText editText;
    ArrayList<String> itens = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        rootRef.child("name").setValue("Mark");
        rootRef.child("age").setValue(38);
        rootRef.child("money").setValue(32.5);
        rootRef.child("boolean").setValue(true);

        itens.add("banana");
        itens.add("apple");
        itens.add("pineapple");

        rootRef.child("itens").setValue(itens);

        DatabaseReference itensRef = rootRef.child("itens");
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String data = "";
                ArrayList<String> array = new ArrayList<>();
                for(DataSnapshot ds:dataSnapshot.getChildren()){
                    //ds.getKey()
                    data = data + ds.getKey() + ":" + ds.getValue();
                    array.add((String) ds.getValue());
                }
                editText.setMaxLines(array.size());
                editText.setText(data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        itensRef.addValueEventListener(eventListener);
    }
}
