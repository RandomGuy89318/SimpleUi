package com.example.simpleui;

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

public class Create extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        EditText txt_username= findViewById(R.id.username);
        EditText txt_password= findViewById(R.id.password);
        EditText txt_email= findViewById(R.id.email);
        Button btn_save= findViewById(R.id.btn_save);
        Button btn_back=findViewById(R.id.btn_back);
        TextView errorhehe= (TextView) findViewById(R.id.error);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname=txt_username.getText().toString();
                String pword=txt_password.getText().toString();
                String mail=txt_email.getText().toString();

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://192.168.1.108/android_crud/create.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if (response.equals("Success")){
                                    Toast.makeText(Create.this, "Data Added", Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(Create.this, "Data Failed to Add to Database", Toast.LENGTH_SHORT).show();
                                    Toast.makeText(Create.this, response, Toast.LENGTH_SHORT).show();
//                                    error.setText(response);
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // textView.setText("That didn't work!");
                        errorhehe.setText(error.toString());

                    }
                }){
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("uname", uname);
                        paramV.put("pword", pword);
                        paramV.put("email", mail);
                        return paramV;
                    }
                };
                queue.add(stringRequest);
            }
        });



    }public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}