package com.quentinrouet.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ButtonFragment.OnButtonClickedListener {

    private TexteFragment tf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tf = (TexteFragment) getFragmentManager()
                .findFragmentById(R.id.fragmentContainerTexte);

    }

    @Override
    public void onButtonClicked(String stringToSend) {
        tf.setTexte(stringToSend);
    }
}