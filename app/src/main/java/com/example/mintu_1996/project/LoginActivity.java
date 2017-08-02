package com.example.mintu_1996.project;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

/**
 * Created by cheekushivam on 8/2/2017.
 */

public class LoginActivity extends Activity {
    EditText username,password;
    TextInputLayout t1,t2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        username=(EditText)findViewById(R.id.user);
        password=(EditText)findViewById(R.id.pass);
        t1=(TextInputLayout)findViewById(R.id.ti2);
        t2=(TextInputLayout)findViewById(R.id.ti3);
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
                t2.setError("Invalid Password");
            }
        }
    }
}
