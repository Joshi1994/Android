package com.example.androidclass_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    android.widget.EditText nameEditText;
    EditText namePassword;
    Button okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEditText = findViewById(R.id.username_1);
        namePassword = findViewById(R.id.password_1);
        okButton = findViewById(R.id.button11);


        /*okButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                if(name.equalsIgnoreCase("Joshi")){
                    Toast.makeText(MainActivity.this,"ok",Toast.LENGTH_LONG)
                            .show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Wrong Text",Toast.LENGTH_LONG)
                            .show();
                }

            }
        });

*/

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nameEditText.getText().toString();
                String pass = namePassword.getText().toString();

                if((name.equalsIgnoreCase("Joshi"))&& (pass.equalsIgnoreCase("qwerty123")))
                {
                    Toast.makeText(MainActivity.this,"ok",Toast.LENGTH_LONG)
                            .show();

                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"username and password",Toast.LENGTH_LONG)
                            .show();

                    Intent intent = new Intent(MainActivity.this,Main3Activity.class);
                    startActivity(intent);
                }




            }
        });


    }
}
