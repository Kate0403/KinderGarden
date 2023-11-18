package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements ItemAdapter.ItemClickListener {

    private Response response;
    OkHttpClient client = new OkHttpClient();

    String getURL = "https://api.europeana.eu/record/v2/search.json?profile=standard&query=museum&rows=12&start=1&wskey=gswartier";

    private ArrayList<Item> itemArrayList = new ArrayList<>();
    private ItemAdapter adapter = new ItemAdapter(itemArrayList, this);
    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_main, container, false);
        //get();
        initRecyclerView(view);
        get();
        return view;
    }

    private void initRecyclerView(View view){
        RecyclerView recyclerView = view.findViewById(R.id.idMuseumItems);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
       // recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(manager);

        recyclerView.setAdapter(adapter);
      //  get();
        //ItemAdapter adapter = new ItemAdapter(itemArrayList, this);



    }
    private void builListData(){

    }

    @Override
    public void onItemClick(Item item) {

        Fragment fragment = ItemDetailsFragment.newInstance(item.getTitle(), item.getImageLink());

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment, "fragment_item_details");
        transaction.addToBackStack(null);
        transaction.commit();


    }

    public void get(){
        Request request = new Request.Builder().url(getURL).build();


        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                /*
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("MyLogs", "Success request");
                        progressBar.setVisibility(View.GONE);
                        MuseumItems.setVisibility(View.VISIBLE);
                        parseJson(response);

                    }*/
                    if(response.isSuccessful()){
                        try{
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Log.d("MyLogs", "Success request");
                                    parseJson(response);
                                    adapter.notifyDataSetChanged();

                                }

                            });



                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }

               // });

            }
        });
    }
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
                String  TimestampCreated = oneItem.getString("timestamp_created");
                Log.d("MyLogs", String.valueOf(TimestampCreated));
                String TimestampUpdate = oneItem.getString("timestamp_update");
                Log.d("MyLogs", String.valueOf(TimestampUpdate));
                String ItemLink = oneItem.getString("link");
                Log.d("MyLogs", ItemLink);
                JSONArray linkToImageArr = oneItem.getJSONArray("edmPreview");
                String ImageLink = (String) linkToImageArr.get(0);
                Log.d("MyLogs", ImageLink);


                itemArrayList.add(new Item(Title, Country, TimestampCreated, TimestampUpdate, ImageLink, ItemLink));
               // initRecyclerView(view);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    /*
    void TestAdapter(){

        itemArrayList.add(new Item("Ttiti", "dfgv", 365678774L, 3465L, "wefrgwv", "wrfrgwr"));
        itemArrayList.add(new Item("Ttiti", "dfgv", 365678774L, 3465L, "wefrgwv", "wrfrgwr"));

        itemArrayList.add(new Item("Ttiti", "dfgv", 365678774L, 3465L, "wefrgwv", "wrfrgwr"));

    }
*/
}