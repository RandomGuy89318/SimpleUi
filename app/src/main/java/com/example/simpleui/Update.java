package com.example.simpleui;

import static com.example.simpleui.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Update extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_update);

        EditText txt_id= findViewById(R.id.ID);
        EditText txt_username= findViewById(R.id.username);
        EditText txt_password= findViewById(R.id.password);
        EditText txt_email= findViewById(R.id.email);
        Button btn_update= findViewById(R.id.btn_update);
        Button btn_back=findViewById(R.id.btn_back);
        TextView error= (TextView) findViewById(R.id.error);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=txt_id.getText().toString();
                String uname=txt_username.getText().toString();
                String pword=txt_password.getText().toString();
                String mail=txt_email.getText().toString();


                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://192.168.1.108/android_crud/update.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if (response.equals("Success")){
                                    Toast.makeText(Update.this, "Data Updated", Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(Update.this, "Data Failed to Update", Toast.LENGTH_SHORT).show();
                                    Toast.makeText(Update.this, response, Toast.LENGTH_SHORT).show();
                                    error.setText(response);
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // textView.setText("That didn't work!");
                    }
                }){
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("id", id);
                        paramV.put("uname", uname);
                        paramV.put("pword", pword);
                        paramV.put("email", mail);
                        return paramV;
                    }
                };
                queue.add(stringRequest);
            }
        });


    }public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}