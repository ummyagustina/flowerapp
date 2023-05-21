package com.example.flowerapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowerapp.Adapter.GroupAdapter;
import com.example.flowerapp.R;
import com.example.flowerapp.model.Group;
import com.example.flowerapp.model.flower;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    private Context mContext;
    private RecyclerView recyclerView;
    private List<Group> groupList;
    private List<flower> featuredList;
    private List<flower> recommendList;

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setAdapterType(view);
        setAdapter();

    }


    private void setAdapter() {
        initGroupData();
        initFlowerData();

        GroupAdapter adapter = new GroupAdapter(mContext, groupList, featuredList, recommendList);
        recyclerView.setAdapter(adapter);


    }


    private void initGroupData() {
        groupList = new ArrayList<>();
        groupList.add(new Group("Recommend","More"));
        groupList.add(new Group("Featured","More"));

    }

    private void initFlowerData() {
        recommendList= new ArrayList<>();
        featuredList = new ArrayList<>();
        recommendList.add(new flower("Hazel","Korea","$350",R.drawable.img2));
        recommendList.add(new flower("Lily","China","$450",R.drawable.img));
        recommendList.add(new flower("Azalea","jpg","$250",R.drawable.img3));

        featuredList.add(new flower("buttin","indo","$500",R.drawable.btn1));
    }



        private void setAdapterType(View view) {
            recyclerView = view.findViewById(R.id.home_RV);
            recyclerView.setLayoutManager(new LinearLayoutManager(mContext));


        }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }
}
