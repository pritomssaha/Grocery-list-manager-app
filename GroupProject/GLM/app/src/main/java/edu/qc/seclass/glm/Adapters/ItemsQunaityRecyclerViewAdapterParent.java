package edu.qc.seclass.glm.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.transition.TransitionManager;

import edu.qc.seclass.glm.Models.Model_Items;
import edu.qc.seclass.glm.R;
import edu.qc.seclass.glm.database.schema.GroceryItem;


import java.util.ArrayList;
import java.util.List;

public class ItemsQunaityRecyclerViewAdapterParent extends RecyclerView.Adapter<ItemsQunaityRecyclerViewAdapterParent.itemsHolder> {
    private List<Model_Items> model_items = new ArrayList<>();

    //List<Model_Items> selectedmodel_itemsList = new ArrayList<>();
    private boolean expanded = false;
    private char check = 'N';
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private Button edit_quanity_btn;
    private Context context;
    public ItemsQunaityRecyclerViewAdapterChild.itemCheckedListener itemCheckedListener;
    public ItemsQunaityRecyclerViewAdapterChild.itemDeleteListener itemDeleteListener;


//    public ItemsQunaityRecyclerViewAdapterParent(List<Model_Items> model_itemsList) {
//        this.model_items = model_itemsList;
//
//    }


//    public interface itemCheckedListener {
//        public void itemChecked(GroceryItem item);
//    }

    public void setModelList(List<Model_Items> mil){
        model_items = mil;
    }

    @NonNull
    @Override
    public itemsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_quanity_row, parent, false);
        itemsHolder itemsHolder = new itemsHolder(view);
        return itemsHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull itemsHolder holder, int position) {
        Model_Items modelItem = model_items.get(position);

        holder.itemName_tv.setText(modelItem.getCategoryName());


        LinearLayoutManager layoutManager
                = new LinearLayoutManager(
                holder
                        .ChildRecyclerView
                        .getContext(),
                LinearLayoutManager.VERTICAL,
                false);


        ItemsQunaityRecyclerViewAdapterChild childItemAdapter = new ItemsQunaityRecyclerViewAdapterChild(modelItem.getChildItemList());


        holder
                .ChildRecyclerView
                .setLayoutManager(layoutManager);
        holder
                .ChildRecyclerView
                .setAdapter(childItemAdapter);
        holder
                .ChildRecyclerView
                .setRecycledViewPool(viewPool);

        childItemAdapter.itemCheckedListener = itemCheckedListener;
        childItemAdapter.itemDeleteListener = itemDeleteListener;

        boolean expanded = modelItem.isExpanded();
        // Set the visibility based on state
        holder.ChildRecyclerView.setVisibility(expanded ? View.VISIBLE : View.GONE);
//        holder.ChildRecyclerView.setActivated(expanded);

        holder.itemView.setOnClickListener(v -> {
            this.expanded = modelItem.isExpanded();
            modelItem.toggleExpanded();
//            TransitionManager.beginDelayedTransition(holder.ChildRecyclerView);
            // Notify the adapter that item has changed
            notifyItemChanged(position);
        });

    }

    @Override
    public int getItemCount() {
        return model_items.size();
    }

    public static class itemsHolder extends RecyclerView.ViewHolder {
        private TextView itemName_tv;
        private RecyclerView ChildRecyclerView;

        public itemsHolder(@NonNull View itemView) {
            super(itemView);

            itemName_tv = itemView.findViewById(R.id.itemName_tv);
            ChildRecyclerView
                    = itemView
                    .findViewById(
                            R.id.child_recyclerview);


        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}

