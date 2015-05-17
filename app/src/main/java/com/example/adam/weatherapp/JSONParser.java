package com.example.adam.weatherapp;

import android.os.AsyncTask;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by Adam on 2015-05-04.
 */
public class JSONParser extends AsyncTask<String, Integer, String>
{
    private OkHttpClient client = new OkHttpClient();

    @Override
    protected String doInBackground(String... urls)
    {
        String jsonBody=null;
        Request request = new Request.Builder()
                .url(urls[0])
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert response != null;
        try {
        jsonBody = response.body().string();
            return jsonBody;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonBody;
    }
}
