package com.example.tigerearth.newproject;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardHolder> {

    private TypedArray titleArray;
    private TypedArray logoArray;

    //Constructor
    CardAdapter(Context context) {
        titleArray = context.getResources().obtainTypedArray(R.array.title_place);
        logoArray = context.getResources().obtainTypedArray(R.array.logo_drawable);
    }

    //OnCreate Inflat view
    @Override
    public CardAdapter.CardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_card
                , parent, false);
        return new CardHolder(v);
    }

    //Logic
    @Override
    public void onBindViewHolder(CardAdapter.CardHolder holder, int position) {
        holder.logoImageView.setImageResource(logoArray.getResourceId(position
                , R.drawable.logo));
        holder.titleTextView.setText(titleArray.getString(position));
    }

    //return no of Data
    @Override
    public int getItemCount() {
        return titleArray.length();
    }

    //Binding View
    static class CardHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.card_view)
        CardView cardView;

        @BindView(R.id.logo_image)
        ImageView logoImageView;

        @BindView(R.id.foundation_name)
        TextView titleTextView;

        CardHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}
