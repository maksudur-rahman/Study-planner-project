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
import android.widget.Toast;
import android.app.ProgressDialog;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.rotnocse.studyplannerproject.Dashboard;
import com.rotnocse.studyplannerproject.R;

public class Register extends Fragment {
    View view;
    EditText emailET, passwordET, usernameET;
    Button signup;

    private ProgressDialog progressDialog;


    //defining firebaseauth object
    private FirebaseAuth firebaseAuth;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_register, container, false);

        //initializing firebase auth object
        firebaseAuth = FirebaseAuth.getInstance();

        //if getCurrentUser does not returns null
        if(firebaseAuth.getCurrentUser() != null){
            //that means user is already logged in
            //so close this activity
            getActivity().finish();

            //and open profile activity
            startActivity(new Intent(getActivity(), Dashboard.class));
        }

        emailET = view.findViewById(R.id.email);
        passwordET = view.findViewById(R.id.password);
        usernameET = view.findViewById(R.id.username);
        progressDialog = new ProgressDialog(getActivity());

        signup = view.findViewById(R.id.reg);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailET.getText().toString().trim();
                String password  = passwordET.getText().toString().trim();
                final String userName = usernameET.getText().toString().trim();
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

                progressDialog.setMessage("Registering Please Wait...");
                progressDialog.show();

                //creating a new user
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                //checking if success
                                if(task.isSuccessful()){
                                    FirebaseUser user = firebaseAuth.getCurrentUser();

                                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                            .setDisplayName(userName).build();

                                    user.updateProfile(profileUpdates);
                                    getActivity().finish();
                                    startActivity(new Intent(getActivity(), Dashboard.class));
                                }else{
                                    //display some message here
                                    Toast.makeText(getActivity(),"Registration Error", Toast.LENGTH_LONG).show();
                                }
                                progressDialog.dismiss();
                            }
                        });
            }
        });

        return view;
    }
}