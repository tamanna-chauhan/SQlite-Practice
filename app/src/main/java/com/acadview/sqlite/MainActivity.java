package com.acadview.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,pwd, phnNo,type;
    Button button;

    private  DBClass dbClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        pwd =  findViewById(R.id.pwd);
        phnNo = findViewById(R.id.num);
        type = findViewById(R.id.type);
        button = findViewById(R.id.button);

        dbClass = new DBClass(this);



        dbClass.oonAddData("","","","");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1 = name.getText().toString();
                String pwd1 = pwd.getText().toString();
                String phn1 = phnNo.getText().toString();
                String type1 = type.getText().toString();

                boolean isSuccesfull = dbClass.oonAddData(name1,pwd1,phn1,type1);

                if(isSuccesfull){
                    Toast.makeText(MainActivity.this,"Succesfully Stored",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);


                }else {
                    Toast.makeText(MainActivity.this,"Unsuccesful",Toast.LENGTH_SHORT).show();
                }






                }
        });

    }
}
