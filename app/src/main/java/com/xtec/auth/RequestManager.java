package com.xtec.auth;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.Call;
import okhttp3.Callback;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

//nuevo
import com.xtec.pvalidarDATIC;
import com.xtec.MainActivity;
import com.xtec.R;


public class RequestManager {

    public static String recent_data;
    public static String ID;

    public static void GET(int option, String parameter) {
        Log.d("data", parameter);
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(parameter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (jsonArray != null && jsonArray.length() > 0) {
            JSONObject childJsonArray = jsonArray.optJSONObject(0);
            try {
                if (option == 1){
                    pvalidarDATIC.getClaveDatic = childJsonArray.getString("uS_contra");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static OkHttpClient client = new OkHttpClient();

    public static void POST(int option, String data){
        String URL;
        //if (option == 1) {
            URL = "https://carpoolingtecwebapi22019.azurewebsites.net/api/Usuario/POST/";
       // }

        try{
            MediaType JSON = MediaType.parse("application/json; charset=utf-8");
            RequestBody body = RequestBody.create(JSON, data);
            final Request request = new Request.Builder()
                    .url(URL)
                    .post(body)
                    .build();
            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.e("Error", "request ->" + call);
                    e.printStackTrace();
                }
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    SAVE_RESPONSE_DATA(response.body().string());
                    Log.i("Response", GET_REQUEST_DATA());
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void SAVE_RESPONSE_DATA(String data) {
        recent_data = data;
    }

    public static String GET_REQUEST_DATA() {
        return recent_data;
    }

    public static void wait_for_response(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
