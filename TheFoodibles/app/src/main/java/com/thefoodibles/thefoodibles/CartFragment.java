package com.thefoodibles.thefoodibles;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;


/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment {


    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        Fragment fragment = new CheckoutFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.cart_items, fragment, "visible_fragment");
        ft.commit();
        TextView textView = (TextView) view.findViewById(R.id.cart_cost);
        textView.setText("Checkout amount - Rs. "+new DecimalFormat("##.##").format(Order.net_cost));
        ((Button) view.findViewById(R.id.cart_order)).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Order i : Order.orders) {
                    Order.pendingorders.add(i);
                }
            }
        });
        return view;
    }

}
