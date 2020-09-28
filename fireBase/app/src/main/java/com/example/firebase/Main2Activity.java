package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Main2Activity extends AppCompatActivity {
    EditText nameEditText;
    EditText phoneEditText;
    EditText ageEditText;
    EditText addressEditText;
    Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        nameEditText = findViewById(R.id.editTextName);
        phoneEditText = findViewById(R.id.editTextPhone);
        ageEditText = findViewById(R.id.editTextAge);
        addressEditText = findViewById(R.id.editTextAddress);
        backButton = findViewById(R.id.buttonBack);
        if(DataModel.getInstance().itemSelected ==-1){
            nameEditText.setText("");
            phoneEditText.setText("");
            ageEditText.setText("");
            addressEditText.setText("");

        }else {
            nameEditText.setText(
                    DataModel.getInstance().names.get(
                            DataModel.getInstance().itemSelected
                    )
            );
            phoneEditText.setText(
                    DataModel.getInstance().phone.get(
                            DataModel.getInstance().itemSelected
                    )
            );
            ageEditText.setText(
                    DataModel.getInstance().age.get(
                            DataModel.getInstance().itemSelected
                    )
            );
            addressEditText.setText(
                    DataModel.getInstance().address.get(
                            DataModel.getInstance().itemSelected
                    )
            );
        }
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeData();
                finish();
            }
        });
    }
    void storeData(){
        if(DataModel.getInstance().itemSelected == -1){
            DataModel.getInstance().names.add(
                    nameEditText.getText().toString()
            );
            DataModel.getInstance().phone.add(
                    phoneEditText.getText().toString()
            );
            DataModel.getInstance().age.add(
                    ageEditText.getText().toString()
            );
            DataModel.getInstance().address.add(
                    addressEditText.getText().toString()
            );
        }else{
            DataModel.getInstance().names.set(
                    DataModel.getInstance().itemSelected,
                    nameEditText.getText().toString()
            );
            DataModel.getInstance().phone.set(
                    DataModel.getInstance().itemSelected,
                    phoneEditText.getText().toString()
            );
            DataModel.getInstance().age.set(
                    DataModel.getInstance().itemSelected,
                    ageEditText.getText().toString()
            );
            DataModel.getInstance().address.set(
                    DataModel.getInstance().itemSelected,
                    addressEditText.getText().toString()
            );

        }
        DataModel.getInstance().saveData(Main2Activity.this);

    }

    public void onBackPressed(){
        super.onBackPressed();
        storeData();
    }
}