package com.quentinrouet.listener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import java.util.ArrayList;

//On implémente l'interface et on définit la méthhode onOiseauClick
public class MainActivity extends AppCompatActivity implements OiseauAdapter.OnOiseauClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Oiseau> oiseaux= new ArrayList<>();
        //On envoie l'instance du listener à notre Adapter
        //C'est ce qui permettre à l'adapter de déclencher l'événement "onOiseauClick"
        OiseauAdapter adapter = new OiseauAdapter(oiseaux, this);

        RecyclerView rvOiseaux = findViewById(R.id.recyclerViewOiseau);

        rvOiseaux.setLayoutManager(new LinearLayoutManager(this));

        rvOiseaux.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.monSuperMenu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    //Que faire lors d'un clic sur un oiseau
    //le clic sur oiseau a été délégué à l'activité
    @Override
    public void onOiseauClick(Oiseau oiseau) {
        Toast.makeText(this,
                "C'est moi, je suis oiseau "+oiseau.famille,
                Toast.LENGTH_SHORT).show();
        //J'affiche la page wiki
        //J'affiche des infos supplémentaires dans une autre page
    }
}