package com.example.cds121.volley_example;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cds121.navigation_with_slidepanel.R;

import java.util.ArrayList;

/**
 * Created by CDS121 on 13-06-2018.
 */

public class Vertical_adapter extends RecyclerView.Adapter {
    private Context mContext;
    ArrayList<VerticalModel> mdata;


    public Vertical_adapter(Context mContext, ArrayList<VerticalModel> data) {
        this.mContext = mContext;
        this.mdata=data;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        return new Vertical_adapter.HomeMenuHolder(inflater.inflate(R.layout.vertical_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof Vertical_adapter.HomeMenuHolder) {
            Log.d("Success","AAAA"+mdata.get(position).getDescription());
            ((Vertical_adapter.HomeMenuHolder) holder).heading.setText(mdata.get(position).getHeading());
            ((Vertical_adapter.HomeMenuHolder) holder).description.setText(mdata.get(position).getDescription());
        }
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }


    private class HomeMenuHolder extends RecyclerView.ViewHolder {
        TextView heading,description;


        HomeMenuHolder(View itemView) {
            super(itemView);


            heading = (TextView) itemView.findViewById(R.id.v_heading);
            description = (TextView) itemView.findViewById(R.id.v_dscription);

        }

    }
}