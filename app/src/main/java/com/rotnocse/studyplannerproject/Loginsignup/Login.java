package com.rotnocse.studyplannerproject.Loginsignup;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ProgressDialog;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.rotnocse.studyplannerproject.Dashboard;
import com.rotnocse.studyplannerproject.R;

public class Login extends Fragment {
    View view;
    EditText emailET, passwordET;
    Button login;
    TextView forget_password;

    //firebase auth object
    private FirebaseAuth firebaseAuth;

    //progress dialog
    private ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);

        firebaseAuth = FirebaseAuth.getInstance();

        //if the objects getcurrentuser method is not null
        //means user is already logged in
        if(firebaseAuth.getCurrentUser() != null){
            //close this activity
            getActivity().finish();
            //opening profile activity
            startActivity(new Intent(getActivity(), Dashboard.class));
        }

        emailET = view.findViewById(R.id.email);
        passwordET = view.findViewById(R.id.password);

        login = view.findViewById(R.id.log);

        progressDialog = new ProgressDialog(getActivity());

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailET.getText().toString().trim();
                String password  = passwordET.getText().toString().trim();


                //checking if email and passwords are empty
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(getActivity(),"Please enter email",Toast.LENGTH_LONG).show();
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    Toast.makeText(getActivity(),"Please enter password",Toast.LENGTH_LONG).show();
                    return;
                }

                //if the email and password are not empty
                //displaying a progress dialog

                progressDialog.setMessage("Logging Please Wait...");
                progressDialog.show();

                //logging in the user
                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressDialog.dismiss();
                                if(task.isSuccessful()){
                                    startActivity(new Intent(getActivity(), Dashboard.class));
                                    getActivity().finish();
                                }
                            }
                        });
            }
        });

        forget_password = view.findViewById(R.id.forget);
        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }
}