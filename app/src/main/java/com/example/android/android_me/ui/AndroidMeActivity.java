/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {

    // TODO (1) Create a layout file that displays one body part image named fragment_body_part.xml
        // This layout should contain a single ImageView

    // TODO (2) Create a new class called BodyPartFragment to display an image of an Android-Me body part
        // In this class, you'll need to implement an empty constructor and the onCreateView method
        // TODO (3) Show the first image in the list of head images
            // Soon, you'll update this image display code to show any image you want
    BodyPartFragment headFragment;
    FragmentManager fragmentManager;
    BodyPartFragment bodyFragment;
    BodyPartFragment legFragment;
    private static final String TAG = "AndroidMeActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "onCreate: MAIN");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);



        if (savedInstanceState == null) {
            headFragment = new BodyPartFragment();
            headFragment.setmImageIds(AndroidImageAssets.getHeads());
            bodyFragment = new BodyPartFragment();
            bodyFragment.setmImageIds(AndroidImageAssets.getBodies());
            legFragment = new BodyPartFragment();
            legFragment.setmImageIds(AndroidImageAssets.getLegs());

            headFragment.setmListIndex(getIntent().getIntExtra("headIndex",0));
            bodyFragment.setmListIndex(getIntent().getIntExtra("bodyIndex",0));
            legFragment.setmListIndex(getIntent().getIntExtra("legIndex",0));

            fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .add(R.id.head_container, headFragment)
                    .add(R.id.body_container, bodyFragment)
                    .add(R.id.leg_container, legFragment)
                    .commit();
        }


        // TODO (5) Create a new BodyPartFragment instance and display it using the FragmentManager
    }


//    public void nextPicHead(View view) {
//        BodyPartFragment newHeadFragment = new BodyPartFragment();
//        newHeadFragment.setmImageIds(AndroidImageAssets.getHeads());
//        newHeadFragment.setmListIndex(headFragment.getmListIndex()+1);
//        headFragment = newHeadFragment;
//        fragmentManager.beginTransaction()
//                .replace(R.id.head_container, newHeadFragment)
//                .commit();
//    }
//
//    public void nextPicBody(View view) {
//        BodyPartFragment newHeadFragment = new BodyPartFragment();
//        newHeadFragment.setmImageIds(AndroidImageAssets.getBodies());
//        newHeadFragment.setmListIndex(bodyFragment.getmListIndex()+1);
//        bodyFragment = newHeadFragment;
//        fragmentManager.beginTransaction()
//                .replace(R.id.body_container, newHeadFragment)
//                .commit();
//    }
//
//    public void nextPicLeg(View view) {
//        BodyPartFragment newHeadFragment = new BodyPartFragment();
//        newHeadFragment.setmImageIds(AndroidImageAssets.getLegs());
//        newHeadFragment.setmListIndex(legFragment.getmListIndex()+1);
//        legFragment = newHeadFragment;
//        fragmentManager.beginTransaction()
//                .replace(R.id.leg_container, newHeadFragment)
//                .commit();
//    }
}
