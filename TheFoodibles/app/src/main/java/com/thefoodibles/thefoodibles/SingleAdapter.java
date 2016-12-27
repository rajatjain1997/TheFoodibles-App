package com.thefoodibles.thefoodibles;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Rajat on 21-10-2016.
 */
public class SingleAdapter extends RecyclerView.Adapter<SingleAdapter.ViewHolder> {
    private Item[] items;
    private Listener listener;

    public SingleAdapter(Item[] items, Listener listener) {
        this.items = items;
        this.listener = listener;
    }

    public static interface Listener {
        public void onClick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        public ViewHolder(CardView v) {
            super(v);
            cardView=v;
        }
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public SingleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_menu, parent, false);
        return new ViewHolder(cv);
    }

    public void onBindViewHolder(ViewHolder holder, final int position) {
        CardView cardView = holder.cardView;
        new DownloadImageTask((ImageView) cardView.findViewById(R.id.info_image)).execute(items[position].getImage());
        TextView textView = (TextView) cardView.findViewById(R.id.info_name);
        textView.setText(items[position].getName());
        textView=(TextView) cardView.findViewById(R.id.info_day);
        textView.setText(items[position].getDay());
        textView=(TextView) cardView.findViewById(R.id.info_price);
        textView.setText("Rs. "+Double.toString(items[position].getCost()));
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }

    public int getItemCount() {
        return items.length;
    }
}