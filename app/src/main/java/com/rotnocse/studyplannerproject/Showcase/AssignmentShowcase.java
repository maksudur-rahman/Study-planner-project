package com.rotnocse.studyplannerproject.Showcase;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.rotnocse.studyplannerproject.Data.Assignment;
import com.rotnocse.studyplannerproject.Data.Course;
import com.rotnocse.studyplannerproject.Data.Time;
import com.rotnocse.studyplannerproject.R;
import com.rotnocse.studyplannerproject.Utils.ShowcaseAssignmentHolder;

import java.util.ArrayList;
import java.util.Calendar;

import uk.co.deanwild.materialshowcaseview.IShowcaseListener;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;


public class AssignmentShowcase extends Fragment {


    public AssignmentShowcase() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_assignment_showcase, container, false);
        AdView mAdView = (AdView)view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        Calendar oneMonth = Calendar.getInstance();
        oneMonth.add(Calendar.MONTH, 1);

        Course english = new Course(
                "Sophomore English",
                "Mr. Dennis",
                new Time(true, true, false, false, null, System.currentTimeMillis(), (long) oneMonth.get(Calendar.HOUR_OF_DAY) * 3600000, oneMonth.getTimeInMillis()),
                "203",
                "Exploring how literature shapes and reflect our collective culture through the study of myths, archetypes, plays, and novels.",
                null,
                Color.BLUE
        );

        Assignment bookWork = new Assignment(
                "Read Chapters 2-5 in To Kill a Mockingbird",
                System.currentTimeMillis(),
                english,
                0,
                "",
                null
        );

        Assignment essay = new Assignment(
                "Finish Essay Rough Draft",
                System.currentTimeMillis(),
                english,
                0,
                "",
                null
        );


        ArrayList<Assignment> assignments = new ArrayList<>(2);
        assignments.add(bookWork);
        assignments.add(essay);

        ShowcaseAssignmentHolder holder = new ShowcaseAssignmentHolder(getContext(), assignments);
        ((ListView)view.findViewById(R.id.showcase_assignment_list_view)).setAdapter(holder);

        new MaterialShowcaseView.Builder(getActivity())
                .setTarget(view.findViewById(R.id.showcase_assignment))
                .withRectangleShape()
                .setTitleText("Assignments")
                .setContentText("Assignments are at the core of Study Planner, allowing you to get reminders and see what's coming up.")
                .setDismissText("Continue")
                .setListener(new IShowcaseListener() {
                    @Override
                    public void onShowcaseDisplayed(MaterialShowcaseView materialShowcaseView) {
                    }

                    @Override
                    public void onShowcaseDismissed(MaterialShowcaseView materialShowcaseView) {
                        SyncShowcase showFrag = new SyncShowcase();

                        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.showcase_fragments, showFrag);
                        transaction.addToBackStack(null);

                        transaction.commit();
                    }
                })
                .show();

        // Inflate the layout for this fragment
        return view;
    }

}
