package com.example.mintu_1996.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by cheekushivam on 8/2/2017.
 */

public class LoginActivity extends Activity {
    EditText username,password;
    TextInputLayout t1,t2;
    TextView tv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        username=(EditText)findViewById(R.id.user);
        password=(EditText)findViewById(R.id.pass);
        t1=(TextInputLayout)findViewById(R.id.ti2);
        t2=(TextInputLayout)findViewById(R.id.ti3);
        tv=(TextView)findViewById(R.id.login_forgot);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Ok", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void login(View v)
    {
        String uname=username.getText().toString().trim();
        String pass=password.getText().toString().trim();
        if(uname.isEmpty())
        {
            username.requestFocus();
            t1.setError("Please Enter Valid EmailId");
        }
        else
        {
            if(pass.isEmpty())
            {
                password.requestFocus();
                t2.setError("Please Enter Password");
            }
            else
            {
                Intent i=new Intent(this,ThreaterMoviesActivity.class);
                startActivity(i);
            }
        }
    }
}
