package com.example.tigerearth.newproject;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlacesHolder> {
    private TypedArray titleArray;
    private TypedArray logoArray;

    PlaceAdapter(Context context) {
        titleArray = context.getResources().obtainTypedArray(R.array.title_place);
        logoArray = context.getResources().obtainTypedArray(R.array.logo_drawable);
    }

    @Override
    public PlacesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_places
                , parent, false);
        return new PlacesHolder(v);
    }

    @Override
    public void onBindViewHolder(PlacesHolder holder, int position) {
        holder.logoImageView.setImageResource(logoArray.getResourceId(position
                , R.drawable.logo));
        holder.titleTextView.setText(titleArray.getString(position));

        if(position == 1){
            holder.nextButton.setImageResource(R.drawable.star);
        }else{
            holder.nextButton.setImageResource(R.drawable.next);
        }
    }

    @Override
    public int getItemCount() {
        return titleArray.length();
    }

    class PlacesHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title_text_view)
        TextView titleTextView;
        @BindView(R.id.logo_image_view)
        ImageView logoImageView;
        @BindView(R.id.next_button)
        ImageView nextButton;

        PlacesHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}
