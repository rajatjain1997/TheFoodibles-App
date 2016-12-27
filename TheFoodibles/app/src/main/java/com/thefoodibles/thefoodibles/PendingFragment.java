package com.thefoodibles.thefoodibles;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PendingFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static Order[] orders;
    public PendingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRecyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_pending, container, false);
        mLayoutManager= new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        populate(Order.pendingorders);
        mAdapter = new OrderAdapter(orders);
        mRecyclerView.setAdapter(mAdapter);
        return mRecyclerView;
    }

    private void populate(ArrayList<Order> pop) {
        orders = new Order[pop.size()];
        for(int i=0;i<pop.size();i++) {
            orders[i] = pop.get(i);
        }
    }

}
