package com.sectionedrecyclerviewdemo;

import java.util.ArrayList;

/**
 * Created by sonu on 24/07/17.
 */

public class SectionModel {
    private String sectionLabel;
    private ArrayList<String> itemArrayList;

    public SectionModel(String sectionLabel, ArrayList<String> itemArrayList) {
        this.sectionLabel = sectionLabel;
        this.itemArrayList = itemArrayList;
    }

    public String getSectionLabel() {
        return sectionLabel;
    }

    public ArrayList<String> getItemArrayList() {
        return itemArrayList;
    }
}
