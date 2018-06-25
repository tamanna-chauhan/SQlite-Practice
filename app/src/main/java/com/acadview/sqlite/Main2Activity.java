package com.acadview.sqlite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private ListView listView;
    DBClass dbClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView  = findViewById(R.id.list);

        dbClass = new DBClass(this);

        Cursor cursor = dbClass.getdata();

        getAllUser();

        final ArrayList<String> arrayList = new ArrayList<>();

        if(cursor.moveToFirst()){
            do {
                String name = cursor.getString(cursor.getColumnIndex("Name"));
                String password = cursor.getString(cursor.getColumnIndex("Password"));
                String number = cursor.getString(cursor.getColumnIndex("Number"));
                String type = cursor.getString(cursor.getColumnIndex("Type"));

                String totalData = name + "\n" + password + "\n" + number + "\n" + type;
                arrayList.add(totalData);

            }while (cursor.moveToNext());
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                String data = arrayList.get(position);
                String[] arr = data.split("\n");
                String name = arr[0];

                dbClass.onDelete(name);
                getAllUser();


            }
        });




    }

    private  void getAllUser(){
        Cursor cursor = dbClass.getdata();


    }
}
