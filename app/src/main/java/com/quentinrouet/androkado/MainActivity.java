package com.quentinrouet.androkado;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.quentinrouet.androkado.bo.Article;
import com.quentinrouet.androkado.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static final String CLE_ARTICLE = "macleArticle";
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        Article croissant = new Article(
                "Croissant",
                "https://wikipedia.org/wiki/Croissant",
                "Une viennoiserie avec du beurre",
                1.1f,
                4.0f,
                false
        );
        binding.setArticle(croissant);

        binding.imageButtonUrl.setOnClickListener((View view)->{
            onClickButtonUrl(view,croissant);
        });
    }

    public void onClickButtonUrl(View v, Article article){
        Toast.makeText(this, article.getUrl(), Toast.LENGTH_SHORT).show();
        Intent intentToInfoUrl = new Intent(MainActivity.this,InfoUrlActivity.class);
        //Ajoute l'article dans un extra
        intentToInfoUrl.putExtra(CLE_ARTICLE,article);
        startActivity(intentToInfoUrl);
    }

}