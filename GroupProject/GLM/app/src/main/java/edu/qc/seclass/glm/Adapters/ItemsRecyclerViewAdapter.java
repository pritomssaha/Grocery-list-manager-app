package edu.qc.seclass.glm.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.qc.seclass.glm.Models.Model_Items;
import edu.qc.seclass.glm.R;


import java.util.List;

public class ItemsRecyclerViewAdapter extends RecyclerView.Adapter<ItemsRecyclerViewAdapter.ItemsHolder>{
    List<Model_Items> model_items;


    public ItemsRecyclerViewAdapter(List<Model_Items> model_items) {
        this.model_items = model_items;

    }

    @NonNull
    @Override
    public ItemsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_row,parent,false);
        ItemsHolder itemsHolder = new ItemsHolder(view);
        return itemsHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsHolder holder, int position) {
        holder.itemName.setText(model_items.get(position).getCategoryName());

    }

    @Override
    public int getItemCount() {
        return model_items.size();
    }


    public static class ItemsHolder extends RecyclerView.ViewHolder {
        TextView itemName;
        public ItemsHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.itemName_tv);
        }
    }
}
