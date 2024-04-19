package com.example.simpleui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn_create= findViewById(R.id.btn_create);
        Button btn_update=findViewById(R.id.btn_update);
        Button btn_retrieve= findViewById(R.id.btn_retrieve);
        Button btn_delete=findViewById(R.id.btn_delete);

        btn_retrieve.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openRetrieve();
            }
        });

         btn_update.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 openUpdate();
             }
         });
        btn_create.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openCreate();
            }
        });



        }


        public  void  openRetrieve(){
            Intent intent = new Intent(this, Retrieve.class);
            startActivity(intent);
        }

        public void openUpdate(){
            Intent intent = new Intent(this, Update.class);
            startActivity(intent);
        }
        public void openCreate(){
        Intent intent = new Intent(this, Create.class);
        startActivity(intent);
        }






}