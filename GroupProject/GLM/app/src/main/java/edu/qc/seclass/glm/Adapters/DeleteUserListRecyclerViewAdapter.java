package edu.qc.seclass.glm.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.qc.seclass.glm.Models.Model_Lists;
import edu.qc.seclass.glm.R;
import edu.qc.seclass.glm.database.schema.GroceryItem;
import edu.qc.seclass.glm.database.schema.GroceryList;
import edu.qc.seclass.glm.database.schema.ListWithGroceryItems;

import java.util.ArrayList;
import java.util.List;

public class DeleteUserListRecyclerViewAdapter extends RecyclerView.Adapter<DeleteUserListRecyclerViewAdapter.DeleteUserListHolder> {
    List<ListWithGroceryItems> model_lists = new ArrayList<>();
    public ToggleDeletion ToggleDeletion;
//    public DeleteUserListRecyclerViewAdapter(List<Model_Lists> model_lists) {
//        this.model_lists = model_lists;
//    }

    public interface ToggleDeletion {
        void toggleDeletion(GroceryList list);
    }

    @NonNull
    @Override
    public DeleteUserListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.delete_list_row,parent,false);
        DeleteUserListHolder deleteUserListHolder = new DeleteUserListHolder(view);

        return deleteUserListHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DeleteUserListHolder holder, int position) {
        holder.listName_tv.setText(model_lists.get(position).list.getName());

        holder.deleteList_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Inner Delete List");
                ToggleDeletion.toggleDeletion(model_lists.get(position).list);

                // TODO: See if this notify is needed. May not be needed since itemChecked eventually leads to re-rendering.
                notifyDataSetChanged();
            }
        });

    }

    public void setListHolder(List<ListWithGroceryItems> list){
        this.model_lists = list;

        // Makes update.
        // TODO: Figure out how this usage can be optimized. See video below for context. @ Timestamp
        // https://youtu.be/reSPN7mgshI?t=784
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount()
    {
        return model_lists.size();
    }

    public static class DeleteUserListHolder extends RecyclerView.ViewHolder {
        TextView listName_tv;
        CheckBox deleteList_cb;

        public DeleteUserListHolder(@NonNull View itemView) {
            super(itemView);
            listName_tv = itemView.findViewById(R.id.listName_tv);
            deleteList_cb = itemView.findViewById(R.id.deleteList_cb);


        }
    }
}