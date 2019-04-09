package com.rotnocse.studyplannerproject.Utils;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;



public class SetPersistance extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
