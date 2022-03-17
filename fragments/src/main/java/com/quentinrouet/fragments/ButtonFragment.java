package com.quentinrouet.fragments;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;


public class ButtonFragment extends Fragment {
    OnButtonClickedListener onButtonClickedListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        onButtonClickedListener = (OnButtonClickedListener) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_button, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button buttonFragment = view.findViewById(R.id.button);
        buttonFragment.setOnClickListener((View v) -> onButtonClickedListener.onButtonClicked("Je suis ButtonFragment"));
    }

    public interface OnButtonClickedListener{
        void onButtonClicked(String stringToSend);
    }


}