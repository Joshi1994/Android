package com.example.exercise3;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class DataModel {
    private static final DataModel ourInstance =
            new DataModel();


    public static DataModel getInstance() {

        return ourInstance;
    }

    private DataModel() {
    }
    public int itemSelected = -1;//flag for addbutton
    public ArrayList<String> names = new ArrayList<>();
    public ArrayList<String> phone = new ArrayList<>();
    public ArrayList<String> age = new ArrayList<>();
    public ArrayList<String> address = new ArrayList<>();

    boolean loadData(Context context){
        try{
            InputStream inputStream = context.openFileInput("names.txt");
            InputStreamReader streamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(streamReader);
            String line;
            names = new ArrayList<>();
            while ((line = reader.readLine()) != null){
                names.add(line);

            }
            //namesListView.setMaxLines(itens.size());
            //namesListView.setText(data);
            reader.close();
            streamReader.close();
            inputStream.close();
            InputStream inputStream1 = context.openFileInput("phone.txt");
            InputStreamReader streamReader1 = new InputStreamReader(inputStream1);
            BufferedReader reader1 = new BufferedReader(streamReader1);
            String line1;
            phone = new ArrayList<>();
            while ((line1 = reader1.readLine()) != null){
                phone.add(line1);
            }
            //namesListView.setMaxLines(itens.size());
            //namesListView.setText(data);
            reader1.close();
            streamReader1.close();
            inputStream1.close();
            InputStream inputStream2 = context.openFileInput("age.txt");
            InputStreamReader streamReader2 = new InputStreamReader(inputStream2);
            BufferedReader reader2 = new BufferedReader(streamReader2);
            String line2;
            age = new ArrayList<>();
            while ((line2 = reader2.readLine()) != null){
                age.add(line2);
            }
            //namesListView.setMaxLines(itens.size());
            //namesListView.setText(data);
            reader2.close();
            streamReader2.close();
            inputStream2.close();
            InputStream inputStream3 = context.openFileInput("address.txt");
            InputStreamReader streamReader3 = new InputStreamReader(inputStream3);
            BufferedReader reader3 = new BufferedReader(streamReader3);
            String line3;
            address = new ArrayList<>();
            while ((line3 = reader3.readLine()) != null){
                address.add(line3);
            }
            //namesListView.setMaxLines(itens.size());
            //namesListView.setText(data);
            reader3.close();
            streamReader3.close();
            inputStream3.close();

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
        }
    void saveData(Context context){
        try {
            OutputStream outputStream = context.openFileOutput("names.txt",context.MODE_PRIVATE);
            OutputStreamWriter writer = new OutputStreamWriter(outputStream);

            for (int i=0; i<names.size();i++){
                writer.write(names.get(i));
                writer.write("\n");
            }

            writer.flush();
            writer.close();
            outputStream.close();

            OutputStream outputStream1 = context.openFileOutput("phone.txt",context.MODE_PRIVATE);
            OutputStreamWriter writer1 = new OutputStreamWriter(outputStream1);

            for (int i=0; i<phone.size();i++){
                writer1.write(phone.get(i));
                writer1.write("\n");
            }

            writer1.flush();
            writer1.close();
            outputStream1.close();
            OutputStream outputStream2 = context.openFileOutput("age.txt",context.MODE_PRIVATE);
            OutputStreamWriter writer2 = new OutputStreamWriter(outputStream2);

            for (int i=0; i<age.size();i++){
                writer2.write(age.get(i));
                writer2.write("\n");
            }

            writer2.flush();
            writer2.close();
            outputStream2.close();
            OutputStream outputStream3 = context.openFileOutput("address.txt",context.MODE_PRIVATE);
            OutputStreamWriter writer3 = new OutputStreamWriter(outputStream3);

            for (int i=0; i<address.size();i++){
                writer3.write(address.get(i));
                writer3.write("\n");
            }

            writer3.flush();
            writer3.close();
            outputStream3.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    }


