package com.example.tigerearth.newproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerCardView;

    @BindView(R.id.recycler_card_view)
    RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);

        setAdapter();

        setCardAdapter();

    }

    private void setCardAdapter() {

    }

    private void setAdapter() {
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(new PlaceAdapter(this));

        RecyclerView.LayoutManager layoutManager2 =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerCardView.setLayoutManager(layoutManager2);
        mRecyclerCardView.setAdapter(new CardAdapter(this));
    }
}
