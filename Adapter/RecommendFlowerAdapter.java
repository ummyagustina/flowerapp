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

public class RecommendFlowerAdapter extends RecyclerView.Adapter<RecommendFlowerAdapter.ViewHolder>{
    private Context context;
    private List<flower> recommendList;

    public RecommendFlowerAdapter(Context context, List<flower> recommendList) {
        this.context = context;
        this.recommendList = recommendList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recomend_item_flower,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendFlowerAdapter.ViewHolder holder, int position) {

        holder.flowerImage.setImageResource(recommendList.get(position).getFlowerImage());
        holder.flowerCountry.setText(recommendList.get(position).getFlowerCountry());
        holder.flowerName.setText(recommendList.get(position).getFlowerName());
        holder.flowerPrice.setText(recommendList.get(position).getFlowerPrice());

    }

    @Override
    public int getItemCount() {
        return recommendList.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{
        private ImageView flowerImage;
        private TextView flowerCountry,flowerName,flowerPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            flowerImage = itemView.findViewById(R.id.recomend_item_flower_picture);
            flowerCountry = itemView.findViewById(R.id.recomend_item_flower_country);
            flowerName = itemView.findViewById(R.id.recomend_item_flower_tittle);
            flowerPrice = itemView.findViewById(R.id.featured_item_flower_price);
        }
    }
}
