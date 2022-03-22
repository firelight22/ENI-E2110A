package com.quentinrouet.library;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    ArrayList<Planete> alPlanet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alPlanet= new ArrayList<>();

        OkHttpClient client = new OkHttpClient();
        Request requestPlanets = new Request.Builder()
                .url("https://swapi.dev/api/planets/")
                .build();
        client.newCall(requestPlanets).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.e(TAG, "onFailure: " + e.getMessage() );
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String respBodyPlanets = response.body().string();
                if(response.code() == 200){
                    try {
                        JSONObject jsonObject = new JSONObject(respBodyPlanets);
                        JSONArray results = jsonObject.getJSONArray("results");
                        for (int i =0; i<results.length(); i++){
                            JSONObject planete = results.getJSONObject(i);
                            Log.i(TAG, "onResponse: Planete :"+planete.getString("name"));
                            alPlanet.add(new Planete(
                                    planete.getString("name"),
                                    planete.getString("climate")
                            ));
                        }



                        //GSON
                        //Deserialiser JSON string -> Objet JAVA (BO)
                        Gson gson= new Gson();
                        Type alPlaneteType = new TypeToken<ArrayList<Planete>>(){}.getType();
                        alPlanet = gson.fromJson(results.toString(), alPlaneteType);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
            }
        });


        //String isbn = "2070541274";
        //Request requestLibrary = new Request.Builder().url("https://openlibrary.org/isbn/" + isbn + ".json").build();
        //client.newCall(requestLibrary).enqueue(new Callback() {
        //    @Override
        //    public void onFailure(@NonNull Call call, @NonNull IOException e) {
        //        Log.e(TAG, "onFailure: " + "Erreur serveur inaccessible. Vérifiez votre connexion");
        //    }
//
        //    @Override
        //    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
        //        //Body est ma réponse. Tout mon livre en JSON (format String)
        //        String body = response.body().string();
        //        Log.i(TAG, "onResponse: "+body);
        //        try {
//
        //            //Libraire JSON forunit avec le SDK
        //            JSONObject bodyJson = new JSONObject(body);
        //            String description = bodyJson.getJSONObject("description").getString("value");
        //            String title = bodyJson.getString("title");
        //            String date = bodyJson.getJSONObject("created").getString("value");
        //            int dateYear = Integer.parseInt(date.substring(0,4));
        //            Log.i(TAG, "onResponse:" + title + description.substring(0,40)+ dateYear);
        //        } catch (JSONException e) {
        //            e.printStackTrace();
        //        }
        //    }
        //});

    }
}