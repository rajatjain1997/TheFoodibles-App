package com.thefoodibles.thefoodibles;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {

    User user = new User();

    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_user, container, false);
        setuppage(layout);
        return layout;
    }

    private void setuppage(View view) {
        TextView value;
        value = (TextView) view.findViewById(R.id.userusername);
        value.setText(user.getUsername());
        value = (TextView) view.findViewById(R.id.useremail);
        value.setText(user.getEmail());
        value = (TextView) view.findViewById(R.id.useraddress1);
        value.setText(user.getAddress1());
        value = (TextView) view.findViewById(R.id.useraddress2);
        value.setText(user.getAddress2());
    }


}
