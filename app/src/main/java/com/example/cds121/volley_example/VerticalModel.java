package com.example.cds121.volley_example;

import com.android.volley.Response;

import org.json.JSONObject;

/**
 * Created by CDS121 on 13-06-2018.
 */

public class VerticalModel {
    String date;
    String time;
    String heading;



    String description;

    public VerticalModel(Response.Listener<JSONObject> listener) {
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
