package edu.qc.seclass.glm.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.qc.seclass.glm.Models.Model_Search_Child;
import edu.qc.seclass.glm.R;

public class ItemSearchRecyclerViewAdapterChild extends RecyclerView.Adapter<ItemSearchRecyclerViewAdapterChild.SearchChildViewHolder>
{
    private List<Model_Search_Child> SearchChildern =  new ArrayList<>();

    public ItemSearchRecyclerViewAdapterChild(List<Model_Search_Child> SearchChildern)
    {
        this.SearchChildern = SearchChildern;
    }

    @NonNull
    @Override
    public SearchChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(
                        R.layout.category_tab,
                        parent, false);
        return new SearchChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchChildViewHolder holder, int position)
    {
        Model_Search_Child SearchChild = SearchChildern.get(position);
        holder.SearchChildName.setText(SearchChild.getCategory_tab_name());
    }

    @Override
    public int getItemCount() {
        return SearchChildern.size();
    }

    public class SearchChildViewHolder extends RecyclerView.ViewHolder
    {
        private TextView SearchChildName;
        public SearchChildViewHolder(@NonNull View itemView)
        {
            super(itemView);
            SearchChildName = itemView.findViewById(R.id.category_tab_name);
        }
    }
}
