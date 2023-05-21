package com.example.flowerapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowerapp.R;
import com.example.flowerapp.model.flower;

import java.util.List;

public class FeaturedFlowersAdapter extends RecyclerView.Adapter<FeaturedFlowersAdapter.ViewHolder> {
    private Context context;
    private List<flower> featuredList;

    public FeaturedFlowersAdapter(Context context, List<flower> featuredList) {
        this.context = context;
        this.featuredList = featuredList;
    }

    @NonNull
    @Override
    public FeaturedFlowersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.featured_plant_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedFlowersAdapter.ViewHolder holder, int position) {
        holder.flowerImage.setImageResource(featuredList.get(position).getFlowerImage());
        holder.flowerName.setText(featuredList.get(position).getFlowerName());
        holder.flowerCountry.setText(featuredList.get(position).getFlowerCountry());
        holder.flowerPrice.setText(featuredList.get(position).getFlowerPrice());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        private ImageView flowerImage;
        private TextView flowerName,flowerCountry,flowerPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            flowerImage = itemView.findViewById(R.id.featured_item_flower_picture);
            flowerName = itemView.findViewById(R.id.featured_item_flower_tittle);
            flowerCountry = itemView.findViewById(R.id.featured_item_flower_country);
            flowerPrice= itemView.findViewById(R.id.featured_item_flower_price);
        }
    }
}
