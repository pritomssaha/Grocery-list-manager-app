package edu.qc.seclass.glm.Activites;

import android.widget.Filter;


import java.util.ArrayList;
import java.util.List;

import edu.qc.seclass.glm.Adapters.CategoryRecyclerViewAdapter;
import edu.qc.seclass.glm.Models.Model_Category;

public class FilterCategory extends Filter {
    private CategoryRecyclerViewAdapter categoryRecyclerViewAdapter;
    private List<Model_Category> filterList;

    public FilterCategory(CategoryRecyclerViewAdapter categoryRecyclerViewAdapter, List<Model_Category> filterList) {
        this.categoryRecyclerViewAdapter = categoryRecyclerViewAdapter;
        this.filterList = filterList;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults filterResults = new FilterResults();

        //validating data with the help of query

        if (constraint != null && constraint.length() > 0) {
            //search thr required material
            constraint = constraint.toString().toUpperCase();

            List<Model_Category> filteredModels = new ArrayList<>();

            //search by product Name
            for (int i = 0; i < filterList.size(); i++) {
                if (filterList.get(i).getCategoryName().toUpperCase().contains(constraint)) {

                    //adding filtered data to list row

                    filteredModels.add(filterList.get(i));

                }


            }

            filterResults.count = filteredModels.size();
            filterResults.values = filteredModels;

        } else {

            // did not search anything if does not contain anything related to search. will return all the orignal list
            filterResults.count = filterList.size();
            filterResults.values = filterList;

        }
        //change null to return results after applying search button
        return filterResults;

    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        categoryRecyclerViewAdapter.model_categories = (List<Model_Category>) results.values;
        categoryRecyclerViewAdapter.notifyDataSetChanged();

    }
}
