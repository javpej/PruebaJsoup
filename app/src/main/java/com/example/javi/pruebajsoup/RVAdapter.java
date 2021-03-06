package com.example.javi.pruebajsoup;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Javi on 25/5/17.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder> {

    ArrayList<Item> items;
    Context context;
    MyClickListener myClickListener;

    public RVAdapter(ArrayList<Item> items, Context context) {
        this.items = items;
        this.context = context;
        myClickListener = (MyClickListener) context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cards_layout, parent);

        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Item itemselected = items.get(position);

        holder.tvTitle.setText(itemselected.getsTitle());
        holder.tvDesc.setText(itemselected.getsDesc());
        Glide.with(context).load(itemselected.getsImgUrl()).fitCenter().into(holder.imNews);

    }

    public void setMyOnclickListener (MyClickListener myClickListener){

        myClickListener = this.myClickListener;
    }

    @Override
    public int getItemCount() {

        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tvTitle;
        TextView tvDesc;
        ImageView imNews;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.TvTitle);
            tvDesc = (TextView) itemView.findViewById(R.id.TvDesc);
            imNews = (ImageView) itemView.findViewById(R.id.ImgNews);

        }

        @Override
        public void onClick(View v) {

            myClickListener.MyOnClick(v, getAdapterPosition());

        }
    }
}
