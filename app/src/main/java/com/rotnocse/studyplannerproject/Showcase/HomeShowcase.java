package com.rotnocse.studyplannerproject.Showcase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.rotnocse.studyplannerproject.R;

import uk.co.deanwild.materialshowcaseview.IShowcaseListener;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;


public class HomeShowcase extends Fragment {


    public HomeShowcase() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view= inflater.inflate(R.layout.fragment_home_showcase, container, false);
        AdView mAdView = (AdView) view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        AdView mAddView = (AdView) view.findViewById(R.id.addView);
        AdRequest addRequest = new AdRequest.Builder().build();
        mAddView.loadAd(addRequest);
         return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        new MaterialShowcaseView.Builder(getActivity())
                .setTitleText("Welcome to Study Planner")
                .setContentText("The app to unify your school life")
                .setDismissText("Continue")
                .setTarget(view.findViewById(R.id.showcase_home_layout))
                .withRectangleShape()
                .setListener(new IShowcaseListener() {
                    @Override
                    public void onShowcaseDisplayed(MaterialShowcaseView materialShowcaseView) {

                    }

                    @Override
                    public void onShowcaseDismissed(MaterialShowcaseView materialShowcaseView) {
                        CourseShowcase courseShow = new CourseShowcase();

                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        transaction.replace(R.id.showcase_fragments, courseShow);
                        transaction.addToBackStack(null);

                        transaction.commit();
                    }
                })
                .show();
    }
}
