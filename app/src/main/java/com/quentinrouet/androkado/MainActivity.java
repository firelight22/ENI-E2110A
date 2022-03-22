package com.quentinrouet.androkado;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
        setTitle("BONJOUR");
        new Thread(()->{
            //dfmlkdhjslfksdhjflsd
            runOnUiThread(()-> Toast.makeText(
                    MainActivity.this,
                    "Lefkjdslfj",
                    Toast.LENGTH_SHORT).show());
        }).run();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemNumero:
                Toast.makeText(this, "Item Numéro 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemdeux:
                Toast.makeText(this, "Item Numéro 2", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClickButtonUrl(View v, Article article){
        Toast.makeText(this, article.getUrl(), Toast.LENGTH_SHORT).show();
        Intent intentToInfoUrl = new Intent(MainActivity.this,InfoUrlActivity.class);
        Intent intentToBrowser = new Intent(Intent.ACTION_VIEW, Uri.parse(article.getUrl()));
        //Ajoute l'article dans un extra
        intentToInfoUrl.putExtra(CLE_ARTICLE,article);
        //startActivity(intentToInfoUrl);
        startActivity(intentToBrowser);
    }

}