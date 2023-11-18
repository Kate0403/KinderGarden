package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {
    /*
    String getURL = "https://api.europeana.eu/record/v2/search.json?lang=en&profile=standard&query=museum&rows=12&start=1&wskey=gswartier";
    String postUSL ="https://api.europeana.eu/record/v2/search.json?wskey=gswartier";
//Swager - https://pro.europeana.eu/page/api-rest-console?function=search&query=Paris&reusability=open&media=true
*/
/*
    public void get(){
        Request request = new Request.Builder().url(getURL).build();


        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("MyLogs", "Success request");
                        progressBar.setVisibility(View.GONE);
                        MuseumItems.setVisibility(View.VISIBLE);
                        parseJson(response);

                    }

                });

            }
        });
    }
    */

    /*
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    public void post(){

        final String json = "{ \"boost\": \"\", \"callback\": \"\", \"colourPalette\": [\"\"], \"cursor\": \"*\", \"facet\": [\"\"], \"hit\":{\"fl\": \"\", \"selectors\": \"\"}, \"landingPage\": true, \"lang\": \"en\", \"media\": true, \"profile\": [\"\"], \"qf\": [\"\"], \"query\": \"museum\", \"reusability\": [\"\"], \"rows\": 12, \"sort\": [\"\"], \"start\": 1, \"textFulltext\": true, \"theme\": \"\", \"thumbnail\": true}";
        RequestBody requestBody = RequestBody.create(json, JSON);
        Request request = new Request.Builder().url(postUSL).post(requestBody).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                runOnUiThread(new Runnable() {
                                  @Override
                                  public void run() {
                                      try {
                                          textView.setText(response.body().string());
                                      } catch (IOException e) {
                                          e.printStackTrace();
                                      }
                                  }
                              }

                );
            }
        });
    }

*/

    private RecyclerView MuseumItems;
    private ItemAdapter adapter;
    private Response response;
    private ArrayList<Item> itemArrayList;

    String getURL = "https://api.europeana.eu/record/v2/search.json?lang=en&profile=standard&query=museum&rows=12&start=1&wskey=gswartier";
    String postUSL ="https://api.europeana.eu/record/v2/search.json?wskey=gswartier";

   // final String json = "{ \"boost\": \"\", \"callback\": \"\", \"colourPalette\": [\"\"], \"cursor\": \"*\", \"facet\": [\"\"], \"hit\":{\"fl\": \"\", \"selectors\": \"\"}, \"landingPage\": true, \"lang\": \"en\", \"media\": true, \"profile\": [\"\"], \"qf\": [\"\"], \"query\": \"museum\", \"reusability\": [\"\"], \"rows\": 12, \"sort\": [\"\"], \"start\": 1, \"textFulltext\": true, \"theme\": \"\", \"thumbnail\": true}";
   // private ProgressBar progressBar;
   // OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //MuseumItems = findViewById(R.id.idMuseumItems);

        Fragment mainFragment = MainFragment.newInstance();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, mainFragment, "main_fragment");
        transaction.commit();


//        itemArrayList = new ArrayList<>();



       // buildRecyclerView();


    }

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

/*
    public void post() throws Exception{

        RequestBody requestBody = RequestBody.create(json, JSON);
        Request request = new Request.Builder().url(postUSL).post(requestBody).build();

        try (Response response = client.newCall(request).execute()) {
            if(!response.isSuccessful()) throw new IOException("Unexpected code "+response);

            parseJson(response);

        }

    }
    */

/*
    public void parseJson(Response response){
        try {
            String jsonData = response.body().string();
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray itemArray = jsonObject.getJSONArray("items");

            ArrayList<JSONObject> itemsArray = new ArrayList<>();
            for (int i=0; i<itemArray.length(); i++){
                itemsArray.add((JSONObject) itemArray.get(i));
            }

            for (int i=0; i < jsonObject.getInt("itemsCount"); i++){

               String test = String.valueOf(itemArray.get(i));

            }

            for (int i = 0; i < jsonObject.getInt("itemsCount"); i++){

                JSONObject oneItem = itemsArray.get(i);
                JSONArray CountryArr = oneItem.getJSONArray("country");
                String Country = (String) CountryArr.get(0);
                Log.d("MyLogs", Country);
                JSONArray TitleArr = oneItem.getJSONArray("dataProvider");
                String Title = (String) TitleArr.get(0);
                Log.d("MyLogs", Title);
                Long TimestampCreated = oneItem.getLong("timestamp_created_epoch");
                Log.d("MyLogs", String.valueOf(TimestampCreated));
                Long TimestampUpdate = oneItem.getLong("timestamp_update_epoch");
                Log.d("MyLogs", String.valueOf(TimestampUpdate));
                String ItemLink = oneItem.getString("link");
                Log.d("MyLogs", ItemLink);
                JSONArray linkToImageArr = oneItem.getJSONArray("edmPreview");
                String ImageLink = (String) linkToImageArr.get(0);
                Log.d("MyLogs", ImageLink);


                itemArrayList.add(new Item(Title, Country, TimestampCreated, TimestampUpdate, ImageLink, ItemLink));
                //  buildRecyclerView();

            }

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        }
*/

/*
    private void buildRecyclerView() {

        adapter = new ItemAdapter(itemArrayList);

        LinearLayoutManager manager = new LinearLayoutManager(this);

        MuseumItems.setHasFixedSize(true);
        MuseumItems.setLayoutManager(manager);
        MuseumItems.setAdapter(adapter);
    }
*/
}