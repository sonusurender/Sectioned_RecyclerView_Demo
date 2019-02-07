package com.sectionedrecyclerviewdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

/**
 * Created by sonu on 24/07/17.
 */

public class RecyclerViewActivity extends AppCompatActivity {

    protected static final String RECYCLER_VIEW_TYPE = "recycler_view_type";
    private RecyclerViewType recyclerViewType;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_activity);

        //get enum type passed from MainActivity
        recyclerViewType = (RecyclerViewType) getIntent().getSerializableExtra(RECYCLER_VIEW_TYPE);
        setUpToolbarTitle();
        setUpRecyclerView();
        populateRecyclerView();
    }

    //set toolbar title and set back button
    private void setUpToolbarTitle() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        switch (recyclerViewType) {
            case LINEAR_HORIZONTAL:
                getSupportActionBar().setTitle(getResources().getString(R.string.linear_sectioned_recyclerview_horizontal));
                break;
            case LINEAR_VERTICAL:
                getSupportActionBar().setTitle(getResources().getString(R.string.linear_sectioned_recyclerview_vertical));
                break;
            case GRID:
                getSupportActionBar().setTitle(getResources().getString(R.string.grid_sectioned_recyclerview));
                break;

        }
    }

    //setup recycler view
    private void setUpRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.sectioned_recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    //populate recycler view
    private void populateRecyclerView() {
        ArrayList<SectionModel> sectionModelArrayList = new ArrayList<>();
        //for loop for sections
        for (int i = 1; i <= 5; i++) {
            ArrayList<String> itemArrayList = new ArrayList<>();
            //for loop for items
            for (int j = 1; j <= 10; j++) {
                itemArrayList.add("Item " + j);
            }

            //add the section and items to array list
            sectionModelArrayList.add(new SectionModel("Section " + i, itemArrayList));
        }

        SectionRecyclerViewAdapter adapter = new SectionRecyclerViewAdapter(this, recyclerViewType, sectionModelArrayList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
