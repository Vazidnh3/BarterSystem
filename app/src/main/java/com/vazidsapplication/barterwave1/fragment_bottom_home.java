package com.vazidsapplication.barterwave1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class fragment_bottom_home extends Fragment {

    RecyclerView recyclerView;
    Adapter adapter;
    ArrayList<String> items;

    public fragment_bottom_home() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        items = new ArrayList<>();
        items.add("Chair and Table");
        items.add("Gaming Mouse");
        items.add("Laptop");
        items.add("Realme Phone");
        items.add("Airbuds");
        items.add("Book");

        View view = inflater.inflate(R.layout.fragment_bottom_home, container, false);
        recyclerView = view.findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new Adapter(getActivity(), items);
        recyclerView.setAdapter(adapter);

        return view;
    }
}