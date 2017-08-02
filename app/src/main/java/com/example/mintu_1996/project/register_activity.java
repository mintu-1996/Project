package com.example.mintu_1996.project;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;

public class register_activity extends Activity {
    EditText et1,et2,et3,et4;
    RadioGroup rb;
    RadioButton rb1,rb2;
    String gender="Male";
    TextInputLayout ti1,ti2,ti3,ti4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_activity);
        et1=(EditText)findViewById(R.id.register_email);
        et2=(EditText)findViewById(R.id.register_pass);
        et3=(EditText)findViewById(R.id.register_repass);
        et4=(EditText)findViewById(R.id.register_dob);
        rb1=(RadioButton)findViewById(R.id.radio_male);
        rb2=(RadioButton)findViewById(R.id.radio_female);
        ti1=(TextInputLayout)findViewById(R.id.register_email_ti);
        ti2=(TextInputLayout)findViewById(R.id.register_pass_ti);
        ti3=(TextInputLayout)findViewById(R.id.register_repass_ti);
        ti4=(TextInputLayout)findViewById(R.id.register_dob_ti);
        rb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked)
                    gender="Female";
                else
                    gender="Male";
            }
        });
        et4.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    final DatePickerDialog dpd = new DatePickerDialog(register_activity.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            // Toast.makeText(register_activity.this,year+" "+month+" "+dayOfMonth, Toast.LENGTH_SHORT).show();
                            et4.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                        }
                    }, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
                    dpd.getDatePicker().setMaxDate(System.currentTimeMillis());
                    dpd.show();
                    return true;
                }
                else
                    return false;
            }
        });
    }
    public void registerUser(View view)
    {
        String email=et1.getText().toString().trim();
        String pass=et2.getText().toString().trim();
        String repass=et3.getText().toString().trim();
        String dob=et4.getText().toString().trim();
        if(email.isEmpty())
        {
            et1.requestFocus();
            ti1.setError("Enter A Valid Email-Id");
        }
        else if(dob.isEmpty())
        {
            et4.requestFocus();
            ti1.setError("");
            ti4.setError("Enter A Valid DOB");
        }
        else if(pass.isEmpty())
        {
            et2.requestFocus();
            ti1.setError("");
            ti4.setError("");
            ti2.setError("Enter A Valid Password");
        }
        else if(repass.isEmpty())
        {
            et3.requestFocus();
            ti1.setError("");
            ti4.setError("");
            ti2.setError("");
            ti3.setError("Please Re-Enter Password");
        }
        Intent i=new Intent(this,LoginActivity.class);
        startActivity(i);
    }
}
