package edu.qc.seclass.glm.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.qc.seclass.glm.Models.Model_Lists;
import edu.qc.seclass.glm.R;

public class AddItemViewAdapter extends RecyclerView.Adapter<AddItemViewAdapter.AddItemHolder>
{
    List<Model_Lists> model_lists;

    public AddItemViewAdapter(List<Model_Lists> model_lists)
    {
        this.model_lists = model_lists;
    }

    @NonNull
    @Override
    public AddItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_results_row, parent, false);
        return new AddItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddItemHolder holder, int position)
    {
        holder.searchItem_tv.setText(model_lists.get(position).getUserList());
    }

    @Override
    public int getItemCount()
    {
        return model_lists.size();
    }

    class AddItemHolder  extends RecyclerView.ViewHolder
    {
        private CheckBox searchItem_cb;
        private TextView searchItem_tv;

        public AddItemHolder(@NonNull View itemView)
        {
          super(itemView);
            searchItem_tv = itemView.findViewById(R.id.searchItem_tv);
            searchItem_cb = itemView.findViewById(R.id.searchItem_cb);
        }
    }
}
