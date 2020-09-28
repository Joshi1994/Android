package com.example.imageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    ImageView imageview;
    int n = 5;

    int []imageresource = new int[n];
    Switch visSwitch;
    TextView editTextName,editTextNum;
    EditText editTextCom;
    ImageButton left,right;
    int index = 0;


    String []name = {"LionKing","paris", "sports", "cyclone","strike"};
    String []comments = new String[n];



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        imageresource[0] = R.drawable.lionking;
        imageresource[1] = R.drawable.paris;
        imageresource[2] = R.drawable.sports;
        imageresource[3] = R.drawable.cyclone;
        imageresource[4] = R.drawable.strike;


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageview = findViewById(R.id.imageView);



        left = findViewById(R.id.left);
        right = findViewById(R.id.right);


        visSwitch = findViewById(R.id.visSwitch);
        editTextName = findViewById(R.id.editTextName);
        editTextNum = findViewById(R.id.editTextNum);
        editTextCom = findViewById(R.id.editTextCom);

        imageview.setImageResource(imageresource[index]);

        editTextName.setText(name[index]);
        left.setVisibility(View.INVISIBLE);
        editTextCom.setText(comments[index]);

        editTextNum.setText(String.valueOf(index +1)+ "/" + String.valueOf(n));




                visSwitch.setChecked(true);

        visSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked == true)
                {
                    editTextCom.setVisibility(View.VISIBLE);
                }
                else
                {
                    editTextCom.setVisibility(View.INVISIBLE);
                }


            }
        });





        left.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                comments[index] = editTextCom.getText().toString();
                index -= 1;
                if(index == 0)
                {
                    left.setVisibility(View.INVISIBLE);
                }

                if(index == n-2)
                {
                    right.setVisibility(View.VISIBLE);
                }

                imageview.setImageResource(imageresource[index]);
                editTextName.setText(name[index]);

                editTextNum.setText(String.valueOf(index +1)+ "/" + String.valueOf(n));
                editTextCom.setText(comments[index]);



            }
        });

            right.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    comments[index] = editTextCom.getText().toString();
                    index++;

                    if(index == n-1)
                    {
                        right.setVisibility(View.INVISIBLE);
                    }

                    if(index == 1)
                    {
                        left.setVisibility(View.VISIBLE);
                    }



                    imageview.setImageResource(imageresource[index]);
                    editTextName.setText(name[index]);

                    editTextNum.setText(String.valueOf(index +1)+ "/" + String.valueOf(n));
                    editTextCom.setText(comments[index]);




                }
            });



    }
}
