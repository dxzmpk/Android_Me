package com.example.android.android_me.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    private Integer headIndex;

    private Integer bodyIndex;

    private Integer legIndex;

    BodyPartFragment headFragment;
    FragmentManager fragmentManager;
    BodyPartFragment bodyFragment;
    BodyPartFragment legFragment;

    {
        headIndex = 0;
        bodyIndex = 0;
        legIndex = 0;
    }

    private boolean mTwoPane;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if (findViewById(R.id.android_me_linear_layout) != null) {
            mTwoPane = true;
            Log.e("MAIN", "onCreate: TABLET");

            Button button = (Button) findViewById(R.id.button_next);
            button.setVisibility(View.GONE);

            GridView gridView =  (GridView)findViewById(R.id.master_list_grid);
            gridView.setNumColumns(2);

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



        } else {
            mTwoPane = false;
        }

//        MasterListFragment fragment = new MasterListFragment();
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction()
//                .add(R.id.master_list_fragment,fragment)
//                .commit();


    }

    @Override
    public void onImageSelected(int position) {
        int bodyPartNumber = position/12;
        int listIndex = position - 12*bodyPartNumber;

        if (mTwoPane) {
            BodyPartFragment fragment = new BodyPartFragment();
            switch (bodyPartNumber) {
                case 0:
                    fragment.setmImageIds(AndroidImageAssets.getHeads());
                    fragment.setmListIndex(listIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.head_container, fragment)
                            .commit();
                    break;
                case 1:
                    fragment.setmImageIds(AndroidImageAssets.getBodies());
                    fragment.setmListIndex(listIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.body_container, fragment)
                            .commit();
                    break;
                case 2:
                    fragment.setmImageIds(AndroidImageAssets.getLegs());
                    fragment.setmListIndex(listIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.leg_container, fragment)
                            .commit();
                    break;
                default:
                    break;
            }

        } else {
                switch (bodyPartNumber) {
                    case 0:
                        headIndex = listIndex;
                        break;
                    case 1:
                        bodyIndex = listIndex;
                        break;
                    case 2:
                        legIndex = listIndex;
                        break;
                    default:
                        break;
                }

                Toast.makeText(this, "Position Clicked = " + position, Toast.LENGTH_SHORT).show();

                Bundle bundle = new Bundle();
                bundle.putInt("headIndex", headIndex);
                bundle.putInt("bodyIndex", bodyIndex);
                bundle.putInt("legIndex", legIndex);

                final Intent intent = new Intent(this, AndroidMeActivity.class);
                intent.putExtras(bundle);

                Button button = (Button)findViewById(R.id.button_next);
                button.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        startActivity(intent);
                    }
                });
        }

    }
}
