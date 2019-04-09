package com.rotnocse.studyplannerproject.Loginsignup;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.api.services.classroom.ClassroomScopes;
import com.rotnocse.studyplannerproject.R;

public class LoginSignupActivity extends AppCompatActivity {

    public static final String[] SCOPES = { ClassroomScopes.CLASSROOM_COURSES_READONLY, ClassroomScopes.CLASSROOM_ROSTERS_READONLY, ClassroomScopes.CLASSROOM_COURSEWORK_ME_READONLY };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);


        Login fragobj = new Login();
        getFragmentManager().beginTransaction().replace(R.id.frame_content, fragobj).commit();

        final TextView login = (TextView) findViewById(R.id.login);
        final TextView register = (TextView) findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View view) {
                register.setBackground(null);
                login.setBackgroundResource(R.mipmap.button2);
                Login fragobj = new Login();
                getFragmentManager().beginTransaction().replace(R.id.frame_content, fragobj).commit();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View view) {
                login.setBackground(null);
                register.setBackgroundResource(R.mipmap.button2);
                Register fragobj = new Register();
                getFragmentManager().beginTransaction().replace(R.id.frame_content, fragobj).commit();
            }
        });

    }
}
