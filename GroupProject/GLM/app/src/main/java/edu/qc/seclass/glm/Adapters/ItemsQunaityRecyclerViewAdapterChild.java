package edu.qc.seclass.glm.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import edu.qc.seclass.glm.Activites.EditQuanityActivity;
import edu.qc.seclass.glm.Models.Item_Tab;
import edu.qc.seclass.glm.R;
import edu.qc.seclass.glm.database.schema.GroceryItem;
import edu.qc.seclass.glm.viewmodel.EditQuantityVM;
import edu.qc.seclass.glm.viewmodel.EditQuantityVMFactory;

public class ItemsQunaityRecyclerViewAdapterChild extends RecyclerView.Adapter<ItemsQunaityRecyclerViewAdapterChild.ChildViewHolder> {


    private List<GroceryItem> ChildItemList = new ArrayList<>();
    public itemCheckedListener itemCheckedListener;
    public itemDeleteListener itemDeleteListener;

    public interface itemCheckedListener {
        public void itemChecked(GroceryItem item);
    }

    public interface itemDeleteListener {
        public void itemDelete(GroceryItem item);
    }

    ItemsQunaityRecyclerViewAdapterChild(List<GroceryItem> childItemList) {
        this.ChildItemList = childItemList;
        System.out.println("Instantiating childAdapter");
    }

    @Override
    public int getItemCount() {
        return ChildItemList.size();
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tab, parent, false);

        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder holder, int position) {
        GroceryItem childItem
                = ChildItemList.get(position);

        // For the created instance, set title.
        // No need to set the image for
        // the ImageViews because we have
        // provided the source for the images
        // in the layout file itself
        System.out.println("Printing Item Names");
        System.out.println(childItem.itemId);
        holder
                .ChildItemTitle
                .setText("[" + childItem.getItemType() + "] " + childItem.getItemName());
        holder
                .ChildItemQuantity
                .setText(String.valueOf(childItem.getQuantity()));

        holder.item_tab_cb.setChecked(childItem.getCheckState());

        holder.item_tab_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemCheckedListener.itemChecked(childItem);

                notifyDataSetChanged();
            }
        });

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemDeleteListener.itemDelete(childItem);
                notifyDataSetChanged();
            }
        });


    }

//
//
//        switch (check)
//        {
//            case 'T':
//                holder.item_tab_cb.setChecked(true);
//                childItem.setCheck('T');
//                break;
//            case 'F':
//                holder.item_tab_cb.setChecked(false);
//                childItem.setCheck('F');
//                break;
//            default:
//                if(childItem.getCheck() == 'T')
//                {
//                    holder.item_tab_cb.setChecked(true);
//                }else
//                {
//                    holder.item_tab_cb.setChecked(false);
//                }
//        }
//
//        edit_quanity_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, EditQuanityActivity.class);
//                intent.putExtra("list", (Serializable) selectedmodel_itemsList);
//                context.startActivity(intent);
//
//            }
//        });
//
//        holder.item_tab_cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (buttonView.isChecked())
//                {
//                    holder.item_tab_cb.setChecked(true);
//                    childItem.setCheck('T');
//                }
//                else
//                {
//                    holder.item_tab_cb.setChecked(false);
//                    childItem.setCheck('F');
//                }
//            }
//        });
//    }

    class ChildViewHolder extends RecyclerView.ViewHolder {

        TextView ChildItemTitle;
        TextView ChildItemQuantity;
        CheckBox item_tab_cb;
        private FrameLayout deleteButton;


        ChildViewHolder(View itemView) {
            super(itemView);
            ChildItemTitle
                    = itemView.findViewById(
                    R.id.item_tab_name);
            ChildItemQuantity
                    = itemView.findViewById(
                    R.id.item_tab_quantity);
            item_tab_cb = itemView.findViewById(R.id.item_tab_cb);
            deleteButton = itemView.findViewById(R.id.delete_layout);
        }
    }

}
