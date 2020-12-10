package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.List;

public class BodyPartFragment extends Fragment {

    private List<Integer> mImageIds;

    private Integer mListIndex;

    private String type;

    private Integer containerId;

    public BodyPartFragment(String type) {
        this.type = type;
    }

    public BodyPartFragment(List<Integer> mImageIds) {
        this.mImageIds = mImageIds;
    }

    public void setmImageIds(List<Integer> mImageIds) {
        this.mImageIds = mImageIds;
    }

    public void setmListIndex(Integer mListIndex) {
        if (mListIndex == mImageIds.size() -1 ) {
            mListIndex = 0;
        }
        this.mListIndex = mListIndex;
    }


    public Integer getmListIndex() {
        return mListIndex;
    }

    public BodyPartFragment() {
        super();
    }

    private static final String TAG = "BodyPartFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
        final ImageView imageView = rootView.findViewById(R.id.body_image_view);
        imageView.setImageResource(mImageIds.get(mListIndex));

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mListIndex = mListIndex + 1;
                if (mListIndex == mImageIds.size()-1) {
                    mListIndex = 1;
                }
                imageView.setImageResource(mImageIds.get(mListIndex));
                Log.e(TAG, "onClick: ListIndex ADD by 1");


            }
        });

        return imageView;

    }


}
