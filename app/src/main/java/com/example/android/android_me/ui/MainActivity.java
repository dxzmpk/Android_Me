package com.example.android.android_me.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.android.android_me.R;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

//        MasterListFragment fragment = new MasterListFragment();
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction()
//                .add(R.id.master_list_fragment,fragment)
//                .commit();
    }

    @Override
    public void onImageSelected(int position) {
        Toast.makeText(this, "Position Clicked = " + position, Toast.LENGTH_SHORT).show();
    }
}
