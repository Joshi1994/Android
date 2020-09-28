package com.example.androidclass_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {


    Button Add;
    Button Sub;
    Button Mul;
    Button Div;
    EditText num1editText;
    EditText num2editText;
    TextView testResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

         num1editText = findViewById(R.id.num1);
        num2editText = findViewById(R.id.num2);
         Add =  findViewById(R.id.add);
         Sub = findViewById(R.id.sub);
         Mul = findViewById(R.id.mul);
         Div = findViewById(R.id.div);
         testResult = findViewById(R.id.result_ans);



         Add.setOnClickListener(new View.OnClickListener() {
    @Override
        public void onClick(View v) {
            String aux = num1editText.getText().toString();
            String aux2 = num2editText.getText().toString();
            int num1 = Integer.parseInt(aux);
            int num2 = Integer.parseInt(aux2);




            int result  = num1 + num2;
        testResult.setText(String.valueOf(result));

    }
});
         Sub.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String aux = num1editText.getText().toString();
                 String aux2 = num2editText.getText().toString();
                 int num1 = Integer.parseInt(aux);
                 int num2 = Integer.parseInt(aux2);
                 int result  = num1 - num2;
                 testResult.setText(String.valueOf(result));
             }
         });
        Mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aux = num1editText.getText().toString();
                String aux2 = num2editText.getText().toString();
                int num1 = Integer.parseInt(aux);
                int num2 = Integer.parseInt(aux2);
                int result  = num1 * num2;
                testResult.setText(String.valueOf(result));
            }
        });
        Div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aux = num1editText.getText().toString();
                String aux2 = num2editText.getText().toString();
                int num1 = Integer.parseInt(aux);
                int num2 = Integer.parseInt(aux2);
                int result  = num1 / num2;
                testResult.setText(String.valueOf(result));
            }
        });




    }
}
