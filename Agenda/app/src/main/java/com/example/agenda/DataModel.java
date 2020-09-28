package com.example.agenda;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class DataModel {
    private static final DataModel ourInstance = new DataModel();

    public static DataModel getInstance() {

        return ourInstance;
    }

    private DataModel() {
    }

    public int itemSelected = -1;
    public ArrayList<String> names = new ArrayList<>();
    public ArrayList<String> age = new ArrayList<>();
    public ArrayList<String> address = new ArrayList<>();
    public ArrayList<String> phnumber = new ArrayList<>();

}


 class Store_load {

        boolean loadData(Context context){
        try{
        InputStream inputStream=context.openFileInput("names.txt");
        InputStreamReader streamReader=new InputStreamReader(inputStream);
        BufferedReader reader=new BufferedReader(streamReader);
        //String data="";
        String line;
             ArrayList<String> names = new ArrayList<>();
        while((line=reader.readLine())!=null){
            DataModel.getInstance().names.add(line);
        //data=data+line+"\n";
        }
        //  dataEditText.setMaxLines(itens.size());
        // dataEditText.setText(data);
        reader.close();
        streamReader.close();
        inputStream.close();

        return true;

        }catch(Exception e){
        e.printStackTrace();
        }
        return false;
        }


        void saveData(Context context){
        try{
        OutputStream outputStream=context.openFileOutput("names.txt",context.MODE_PRIVATE);
        OutputStreamWriter writer=new OutputStreamWriter(outputStream);

        for(int i=0;i<DataModel.getInstance().names.size();i++){
        writer.write(DataModel.getInstance().names.get(i));
        writer.write("\n");
        }

        writer.flush();
        writer.close();
        outputStream.close();
        }catch(Exception e){
        e.printStackTrace();
        }
        }


}