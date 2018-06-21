package com.example.cds121.volley_example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.cds121.navigation_with_slidepanel.R;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    Vertical_adapter vertical_adapter;

    RecyclerView vertical_recyclerview;
    ArrayList shoplist = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        vertical_recyclerview = (RecyclerView) findViewById(R.id.vertical_recyclerview);
        vertical_recyclerview.setLayoutManager(new LinearLayoutManager(this));
        vertical_recyclerview.setItemAnimator(new DefaultItemAnimator());
        String url="http://mindmade.co/crm/site/mshoplocations?user_id=46&dealer_id=13&route_id=56";
        Shopurl(url);
    }




    private void Shopurl(String url) {
        try {
                Log.d("success", "URL" + url);
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                JsonObjectRequest request = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("shopresponse", "" + response);
                        try {
                            ArrayList<VerticalModel> movieList = new ArrayList<>();
                            if (response.getString("status").equals("success")) {
                                JSONArray array = response.getJSONArray("stores");
                                for (int i = 0; i < array.length(); i++) {
                                    Log.d("shoplist", "array" + array);
                                    VerticalModel looper = new VerticalModel(this);
                                    JSONObject object = array.getJSONObject(i);
                                    looper.setDescription(object.getString("address"));
                                    looper.setHeading(object.getString("store_name"));
                                    movieList.add(looper);

                                }
                                vertical_adapter = new Vertical_adapter(getApplicationContext(), movieList);
                                 vertical_recyclerview.setAdapter(vertical_adapter);

                            } else if (response.getString("status").equals("failure")) {

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d("Error:shop " + error.getMessage());
                        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                        } else if (error instanceof AuthFailureError) {

                        } else if (error instanceof ServerError) {

                        } else if (error instanceof NetworkError) {

                        } else if (error instanceof ParseError) {
                        }
                    }
                });
                int socketTimeout = 40000;
                RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, 2, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                request.setRetryPolicy(policy);
                queue.add(request);
        }catch (Exception ex){
            Log.d("Error",""+ex);
        }
    }
}
