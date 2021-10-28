package edu.qc.seclass.glm.Adapters;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.qc.seclass.glm.Models.Item_Tab;
import edu.qc.seclass.glm.Models.Model_Items;
import edu.qc.seclass.glm.R;


import java.util.List;

public class EditItemQuanityRecyclerViewAdapter extends RecyclerView.Adapter<EditItemQuanityRecyclerViewAdapter.EditQuanityHolder>{
    List<Item_Tab> model_items;

    public EditItemQuanityRecyclerViewAdapter(List<Item_Tab> model_items) {
        this.model_items = model_items;
    }

    @NonNull
    @Override
    public EditQuanityHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.edit_item_quanity_row,parent,false);
        EditQuanityHolder editQuanityHolder = new EditQuanityHolder(view);
        return editQuanityHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EditQuanityHolder holder, int position) {
        holder.item_name.setText(model_items.get(position).getItem_tab_name());
        holder.item_quanity.setText(model_items.get(position).getQuantity());

        holder.item_quanity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                }

                catch (Exception e){
                    e.getStackTrace();
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return model_items.size();
    }

    public static class EditQuanityHolder extends RecyclerView.ViewHolder {
        private TextView item_name;
        private EditText item_quanity;
        public EditQuanityHolder(@NonNull View itemView) {
            super(itemView);
            item_name = itemView.findViewById(R.id.itemName_tv);
            item_quanity =itemView.findViewById(R.id.itemQuanity_tv);
        }
    }
}
