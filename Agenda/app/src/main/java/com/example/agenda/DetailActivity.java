package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailActivity extends AppCompatActivity {

    Store_load obj = new Store_load();

    EditText    nameEditText;
    EditText    ageEditText;
    EditText    addressEditText;
    EditText    PhNoEditText;
    Button      backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        nameEditText    =   findViewById(R.id.editTextName);
        ageEditText      =   findViewById(R.id.editTextAge);
        addressEditText =   findViewById(R.id.editTextAddress);
        PhNoEditText    =   findViewById(R.id.editTextPhNo);

        backButton      =   findViewById(R.id.buttonBack);

        if(DataModel.getInstance().itemSelected == -1){
            nameEditText.setText("");
            ageEditText.setText("");
            addressEditText.setText("");
            PhNoEditText.setText("");
        }else{
            nameEditText.setText(
                    DataModel.getInstance().names.get(
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

            PhNoEditText.setText(
                    DataModel.getInstance().phnumber.get(
                            DataModel.getInstance().itemSelected
                    )
            );

        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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

            DataModel.getInstance().age.add(
                    ageEditText.getText().toString()
            );

            DataModel.getInstance().address.add(
                    addressEditText.getText().toString()
            );

            DataModel.getInstance().phnumber.add(
                    PhNoEditText.getText().toString()
            );
        }else{
            DataModel.getInstance().names.set(
                    DataModel.getInstance().itemSelected,
                    nameEditText.getText().toString()
            );

            DataModel.getInstance().age.set(
                    DataModel.getInstance().itemSelected,
                    ageEditText.getText().toString()
            );

            DataModel.getInstance().address.set(
                    DataModel.getInstance().itemSelected,
                    addressEditText.getText().toString()
            );

            DataModel.getInstance().phnumber.set(
                    DataModel.getInstance().itemSelected,
                    PhNoEditText.getText().toString()
            );



        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }


    @Override
    protected void onStop() {
        super.onStop();

        obj.saveData(this);


    }
}
