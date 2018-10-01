package com.example.vaibhav.k_login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login_2_wsdActivity extends AppCompatActivity implements View.OnClickListener{

    public Button btnSubmit,btnReg;
    public EditText etUser,etPass;
    public TextView tvText;
    public String gId,gPass;
    public String fId = "iammuaj@gmail.com";
    public String fPass = "asdfgh";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_2_wsd);

        btnSubmit = findViewById(R.id.btn_submit);
        btnReg = findViewById(R.id.btn_reg);
        btnSubmit.setOnClickListener(this);
        btnReg.setOnClickListener(this);


    etUser = findViewById(R.id.et_user);
    etPass = findViewById(R.id.et_pass);

    }

    @Override
    public void onClick(View v) {




        if(v.getId() == R.id.btn_submit ){
            gId = etUser.getText().toString();
            gPass = etPass.getText().toString();


            if(gId.equals(fId)){
                if (gPass.equals(fPass)){
                    Toast.makeText(this, "Successfully Login",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(this, "Password not match",Toast.LENGTH_SHORT).show();
                }
            }
            else Toast.makeText(this, "Email not match",Toast.LENGTH_SHORT).show();


        }
        if(v.getId() == R.id.btn_reg){

            dbInit.populateAsync(AppDatabase.getAppDatabase(this));
            Log.d("Database", "Initing!!");

            Intent intent = new Intent(Login_2_wsdActivity.this,Registration.class);
            startActivity(intent);
            finish();
        }
    }
}
