package com.example.flowerapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowerapp.R;
import com.example.flowerapp.model.Group;
import com.example.flowerapp.model.flower;

import java.util.List;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.ViewHolder> {
    private Context context;
    private List<Group> groupList;
    private List<flower> featuredList;
    private List<flower> recommendList;

    public GroupAdapter(Context context, List<Group> groupList, List<flower> featuredList, List<flower> recommendList) {
        this.context = context;
        this.groupList = groupList;
        this.featuredList = featuredList;
        this.recommendList = recommendList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.group_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.groupTitle.setText(groupList.get(position).getGrubTitle());
        holder.groupButton.setText(groupList.get(position).getGrubButtonTitle());
        holder.setList(holder.recyclerView,position);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        private TextView groupTitle;
        private AppCompatButton groupButton;
        private RecyclerView recyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            groupTitle = itemView.findViewById(R.id.group_title);
            groupButton = itemView.findViewById(R.id.group_Button);
            recyclerView = itemView.findViewById(R.id.group_RV);
        }
        public void setList(RecyclerView recyclerView, int position){
            switch (position){
                case 0:
                    setRecommendList(recyclerView);
                    break;
                case 1:
                    setFeaturedList(recyclerView);
                    break;
            }

        }

        private void setRecommendList(RecyclerView recyclerView) {
            RecommendFlowerAdapter adapter = new RecommendFlowerAdapter(context,recommendList);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(context,recyclerView.HORIZONTAL,false));
            recyclerView.setNestedScrollingEnabled(true);

            
        }

        private void setFeaturedList(RecyclerView recyclerView) {
            FeaturedFlowersAdapter adapter = new FeaturedFlowersAdapter(context,featuredList);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(context,recyclerView.HORIZONTAL,false));
            recyclerView.setNestedScrollingEnabled(true);
        }


    }
}
