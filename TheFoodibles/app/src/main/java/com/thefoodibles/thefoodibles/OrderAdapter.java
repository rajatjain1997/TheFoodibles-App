package com.thefoodibles.thefoodibles;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * Created by Rajat on 23-10-2016.
 */
public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder>{
    private Order[] orders;

    public OrderAdapter(Order[] orders) {
        this.orders = orders;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        public ViewHolder(CardView v) {
            super(v);
            cardView=v;
        }
    }

    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_order, parent, false);
        return new ViewHolder(cv);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        CardView cardView = holder.cardView;
        new DownloadImageTask((ImageView) cardView.findViewById(R.id.order_image)).execute(orders[position].getItem().getImage());
        TextView value;
        value = (TextView) cardView.findViewById(R.id.order_name);
        value.setText(orders[position].getItem().getName());
        value = (TextView) cardView.findViewById(R.id.order_date);
        value.setText("Delivery: "+orders[position].getDelivery_date().getDate()+"/"+orders[position].getDelivery_date().getMonth()+"/"+orders[position].getDelivery_date().getYear());
        value = (TextView) cardView.findViewById(R.id.order_qty);
        value.setText("Qty: "+Integer.toString(orders[position].getQuantity()));
        value = (TextView) cardView.findViewById(R.id.order_price);
        value.setText("Rs. "+new DecimalFormat("##.##").format(orders[position].getAmount()));
    }

    public int getItemCount() {
        return orders.length;
    }

}
