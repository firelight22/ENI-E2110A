package com.quentinrouet.androkado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.quentinrouet.androkado.bo.Article;

public class InfoUrlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_url);
        Article monArticle = getIntent().getParcelableExtra(MainActivity.CLE_ARTICLE);
        TextView tv = findViewById(R.id.textViewUrl);
        tv.setText(monArticle.getUrl());
    }
}