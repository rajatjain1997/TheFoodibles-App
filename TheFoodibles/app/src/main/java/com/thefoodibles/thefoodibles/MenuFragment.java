package com.thefoodibles.thefoodibles;


import android.app.FragmentTransaction;
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
public class MenuFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static int time_pos;
    private Item[] items;

    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRecyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_menu, container, false);
        mLayoutManager= new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
//        switch (time_pos) {
//            case 0:
//                populate(Item.breakfast);
//                break;
//            case 1:
//                populate(Item.lunch);
//                break;
//            case 2:
//                populate(Item.dinner);
//                break;
//            case 3:
//                populate(Item.bulk);
//                break;
//        }
        //Mock Item allocation right now. The real one is above ^
        items = new Item[10];
        for(int i=0;i<10;i++) {
            items[i] = new Item();
        }
        mAdapter = new SingleAdapter(items, new SingleAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Fragment fragment = new ItemFragment();
                ItemFragment.item = items[position];
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, fragment, "visible_fragment");
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        mRecyclerView.setAdapter(mAdapter);
        return mRecyclerView;
    }

    private void populate(ArrayList<Item> pop) {
        items = new Item[pop.size()];
        for(int i=0;i<pop.size();i++) {
            items[i] = pop.get(i);
        }
    }

}
