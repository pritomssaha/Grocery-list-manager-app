package edu.qc.seclass.glm.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import edu.qc.seclass.glm.Activites.ListDetailsActivity;
import edu.qc.seclass.glm.Models.Model_Lists;
import edu.qc.seclass.glm.R;
import edu.qc.seclass.glm.database.schema.ListWithGroceryItems;


import java.util.ArrayList;
import java.util.List;

public class UserListsRecyclerViewAdapter extends RecyclerView.Adapter<UserListsRecyclerViewAdapter.userListsHolder> {
    List<ListWithGroceryItems> model_Lists_s = new ArrayList<>();
    public RenameList renameList;


//    public UserListsRecyclerViewAdapter(List<Model_Lists> model_Lists_s) {
//        this.model_Lists_s = model_Lists_s;
//    }

    public interface RenameList{
        void renameList(ListWithGroceryItems list, String newName);
    }
    @NonNull
    @Override
    public userListsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lists_row,parent,false);
        userListsHolder userListsHolder = new userListsHolder(view);
    return userListsHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull userListsHolder holder, int position) {
        holder.listType_tv.setText(model_Lists_s.get(position).list.getName());


        holder.editList_ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(v.getContext(), position);
            }
        });

        holder.listType_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context;
                context = v.getContext();
                Intent intent = new Intent(context,ListDetailsActivity.class);
                intent.putExtra("EXTRA_LIST_ID",model_Lists_s.get(position).list.getListId());
                context.startActivity(intent);
            }
        });

    }

    public void setListHolder(List<ListWithGroceryItems> list){
        this.model_Lists_s = list;

        // should not be used in final
        notifyDataSetChanged();
    }

    private void showDialog(Context context, int position) {
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle("Rename List");


        final EditText input = new EditText(context);
        alert.setView(input);


        alert.setPositiveButton("Rename", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
//                Toast.makeText(context, "renamed", Toast.LENGTH_SHORT).show();
                renameList.renameList(model_Lists_s.get(position), input.getText().toString());
            }
        });


        alert.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        Toast.makeText(context, "can", Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }

    @Override
    public int getItemCount() {
        return model_Lists_s.size();
    }

    public static class userListsHolder extends RecyclerView.ViewHolder {
      TextView listType_tv;
       ImageButton editList_ib;

        public userListsHolder(@NonNull View itemView) {
            super(itemView);

            listType_tv = itemView.findViewById(R.id.listType_tv);
            editList_ib = itemView.findViewById(R.id.editList_ib);




        }
    }

}
