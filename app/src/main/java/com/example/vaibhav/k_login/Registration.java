package com.example.vaibhav.k_login;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity implements View.OnClickListener {

    private Button btnSignUp;
    private EditText etFname,etLname,etMail,etPass;

    public SharedPreferences sharePref;
    public String MyPreference = "com.example.vaibhav.k_login";

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Registration Page");

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        btnSignUp = findViewById(R.id.btn_signUp);
        btnSignUp.setOnClickListener(this);

        etFname = findViewById(R.id.et_fname);
        etLname = findViewById(R.id.et_lname);
        etMail = findViewById(R.id.et_email);
        etPass = findViewById(R.id.et_password);

//        sharePref = getSharedPreferences(MyPreference, MODE_PRIVATE);



    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_signUp){
            SharedPreferences.Editor editor = getSharedPreferences(MyPreference, MODE_PRIVATE).edit();

            editor.putBoolean("status", true);
            editor.putString("fname", String.valueOf(etFname));
            editor.putString("lname", String.valueOf(etLname));
            editor.putString("mail", String.valueOf(etMail));
            editor.putString("pass", String.valueOf(etPass));

            editor.commit();

            SharedPreferences fetch = getSharedPreferences(MyPreference,MODE_PRIVATE);
            boolean dataFetch = fetch.getBoolean("status",  false);

            if(dataFetch){
                String data = fetch.getString("fname", "Not found");
                Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
            }


            Toast.makeText(this, "Registration Complete", Toast.LENGTH_SHORT).show();
        }
        else    Toast.makeText(this, "Something wrong !!", Toast.LENGTH_SHORT).show();


    }
}
