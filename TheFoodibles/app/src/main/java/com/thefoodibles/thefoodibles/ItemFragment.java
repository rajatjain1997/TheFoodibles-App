 package com.thefoodibles.thefoodibles;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.text.DecimalFormat;


 /**
 * A simple {@link Fragment} subclass.
 */
public class ItemFragment extends Fragment {

    public static Item item;

    public ItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_item, container, false);
        setup(layout);
        return layout;
    }

    public void setup(View view) {
        TextView value;
        new DownloadImageTask((ImageView) view.findViewById(R.id.item_image)).execute(item.getImage());
        value = (TextView) view.findViewById(R.id.item_name);
        value.setText(item.getName());
        value = (TextView) view.findViewById(R.id.item_day);
        value.setText(item.getDay());
        final TextView p_value = (TextView) view.findViewById(R.id.item_price);
        p_value.setText("Rs. "+new DecimalFormat("##.##").format(item.getCost()));
        final NumberPicker np = (NumberPicker) view.findViewById(R.id.item_num);
        np.setMinValue(1);
        np.setMaxValue(10);
        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                p_value.setText("Rs. "+new DecimalFormat("##.##").format(item.getCost()*i1));
            }
        });
        Button button = (Button) view.findViewById(R.id.item_order);
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Order.orders.add(new Order(item, np.getValue()));
                Fragment fragment = new CartFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, fragment, "visible_fragment");
                ft.addToBackStack(null);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        });
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
