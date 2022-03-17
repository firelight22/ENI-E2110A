package com.quentinrouet.androkado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.TextView;

import com.quentinrouet.androkado.bo.Article;
import com.quentinrouet.androkado.databinding.ActivityInfoUrlBinding;

public class InfoUrlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityInfoUrlBinding aiub = DataBindingUtil.setContentView(this,R.layout.activity_info_url);
        Article monArticle = getIntent().getParcelableExtra(MainActivity.CLE_ARTICLE);
        aiub.textViewUrl.setText(monArticle.getUrl());
    }
}