package com.retrofit_library;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.retrofit_library.API_Calling.APIClient;
import com.retrofit_library.API_Calling.Api_Interface;
import com.retrofit_library.Adapter.DetailsAdapter;
import com.retrofit_library.Model.Contact;
import com.retrofit_library.Model.Example;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    DetailsAdapter detailsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.listview);

        Api_Interface apiService = APIClient.getClient().create(Api_Interface.class);

        Call<Example> call = apiService.getResponse();

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {


                if (response.isSuccessful()){

                    List<Contact> contactList = response.body().getContacts();
                    String[] items = new String[contactList.size()];

                    final ArrayList<String> list = new ArrayList<String>();

                    for (int i = 0; i < contactList.size(); i++) {
                        items[i] = contactList.get(i).getName();
                       list.add(items[i]);
                    }

                    detailsAdapter = new DetailsAdapter(MainActivity.this,list);
                    listview.setAdapter(detailsAdapter);

                    Log.e("TAG", "onResponse: " +  response.body().getContacts().get(0).getAddress() + ",," + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("TAG", t.toString());
            }
        });
    }
}
