package edu.qc.seclass.glm.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.qc.seclass.glm.Models.Model_Search_Parent;
import edu.qc.seclass.glm.R;

public class ItemSearchRecyclerViewAdapterParent extends RecyclerView.Adapter<ItemSearchRecyclerViewAdapterParent.SearchParentViewHolder>
{
    private List<Model_Search_Parent> SearchParents = new ArrayList<>();
    private boolean expanded = false;

    private RecyclerView.RecycledViewPool
            viewPool
            = new RecyclerView
            .RecycledViewPool();

    public ItemSearchRecyclerViewAdapterParent(List<Model_Search_Parent> SearchParents)
    {
        this.SearchParents = SearchParents;
    }

    @NonNull
    @Override
    public SearchParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_row, parent, false);
        SearchParentViewHolder SPVH = new SearchParentViewHolder(view);
        return SPVH;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchParentViewHolder holder, int position)
    {
        Model_Search_Parent Search_Parents = SearchParents.get(position);
        holder.category_row_name.setText(Search_Parents.getCategory_row_name());

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(
                holder
                        .category_row_rv
                        .getContext(),
                LinearLayoutManager.VERTICAL,
                false);

        ItemSearchRecyclerViewAdapterChild childCategoryAdapter = new ItemSearchRecyclerViewAdapterChild(Search_Parents.getChildren());

        holder.category_row_rv.setLayoutManager(layoutManager);
        holder.category_row_rv.setAdapter(childCategoryAdapter);
        holder.category_row_rv.setRecycledViewPool(viewPool);

        boolean expanded = Search_Parents.isExpanded();
        holder.category_row_rv.setVisibility(expanded ? View.VISIBLE : View.GONE);

        holder.itemView.setOnClickListener(v ->
        {
            this.expanded = Search_Parents.isExpanded();
            Search_Parents.toggleExpanded();
            notifyItemChanged(position);
        });
    }

    @Override
    public int getItemCount() {
        return SearchParents.size();
    }

    public class SearchParentViewHolder extends RecyclerView.ViewHolder
    {
        private TextView category_row_name;
        private RecyclerView category_row_rv;

        public SearchParentViewHolder(@NonNull View itemView) {
            super(itemView);
            category_row_name = itemView.findViewById(R.id.category_row_name);
            category_row_rv = itemView.findViewById(R.id.category_row_rv);
        }
    }
}
