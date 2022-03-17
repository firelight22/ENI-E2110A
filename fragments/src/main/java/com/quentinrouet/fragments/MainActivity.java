package com.quentinrouet.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TexteFragment tf = (TexteFragment) getFragmentManager()
                .findFragmentById(R.id.fragmentContainerTexte);
        tf.setTexte("Hello C'est moi MainActivity");
    }
}