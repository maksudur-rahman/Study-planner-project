package com.rotnocse.studyplannerproject.Notes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.rotnocse.studyplannerproject.R;

/**
 * Created by MD.ISRAFIL MAHMUD on 7/15/2017.
 */

public class NoteViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_view);
        TextView titleview=(TextView)findViewById(R.id.title_view);
        TextView textview=(TextView)findViewById(R.id.text_view);
        AdView mAdView = (AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        String sub_id = getIntent().getStringExtra("id");
        String title=getIntent().getStringExtra("title");
        String text=getIntent().getStringExtra("text");
        titleview.setText(title);
        textview.setText(text);
    }
}
