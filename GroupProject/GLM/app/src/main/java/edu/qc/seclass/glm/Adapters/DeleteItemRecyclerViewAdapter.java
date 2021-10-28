package edu.qc.seclass.glm.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.qc.seclass.glm.Models.Model_Items;
import edu.qc.seclass.glm.R;


import java.util.ArrayList;
import java.util.List;

public class DeleteItemRecyclerViewAdapter extends RecyclerView.Adapter<DeleteItemRecyclerViewAdapter.DeleteItemHolder> {
    private List<Model_Items> model_items;
    Button deleteItem_rv;
    List<Model_Items> selectedmodel_itemsList;
    public DeleteItemRecyclerViewAdapter(List<Model_Items> model_items, Button deleteItem_rv) {
        this.deleteItem_rv = deleteItem_rv;
        this.model_items = model_items;
        selectedmodel_itemsList=new ArrayList<>();
    }

    @NonNull
    @Override
    public DeleteItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.delete_item_row,parent,false);
        DeleteItemHolder deleteItemHolder = new DeleteItemHolder(view);
        return deleteItemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DeleteItemHolder holder, int position) {
        holder.itemName.setText(model_items.get(position).getCategoryName());
        holder.delete_cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    selectedmodel_itemsList.add(model_items.get(position));
                }else {
                    selectedmodel_itemsList.remove(model_items.get(position));
                }

            }
        });
        deleteItem_rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i=0;i<selectedmodel_itemsList.size();i++){
                    model_items.remove(selectedmodel_itemsList.get(i));
                }
                notifyDataSetChanged();

            }
        });

    }

    @Override
    public int getItemCount() {
        return model_items.size();
    }

    public static class DeleteItemHolder extends RecyclerView.ViewHolder {
        private TextView itemName;
        private CheckBox delete_cb;
        public DeleteItemHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.itemName_tv);
            delete_cb = itemView.findViewById(R.id.delete_cb);
        }

    }
}
