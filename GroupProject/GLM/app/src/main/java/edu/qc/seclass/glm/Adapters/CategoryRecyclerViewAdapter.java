 package edu.qc.seclass.glm.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.RecyclerView;
import edu.qc.seclass.glm.Activites.FilterCategory;
import edu.qc.seclass.glm.Models.Model_Category;
import edu.qc.seclass.glm.R;





import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CategoryRecyclerViewAdapter   extends RecyclerView.Adapter<CategoryRecyclerViewAdapter.CategoryHolder> implements Filterable {
    public List<Model_Category> model_categories ,filterList;
    private FilterCategory filter;
    private RadioButton selected;
    String type = "";

    String from;
    public CategoryRecyclerViewAdapter(List<Model_Category> model_categories,String from,String type) {
        this.model_categories = model_categories;
        this.filterList = model_categories;
        this.from = from;
        this.type = type;

    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_row,parent,false);
        CategoryHolder categoryHolder = new CategoryHolder(view);
        return categoryHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
        holder.catgoryName.setText(model_categories.get(position).getCategoryName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context;
                context = v.getContext();
                if (!from.equals("cat")){
//                    Intent intent = new Intent(context,AddItemActivity.class);
//                    intent.putExtra("category",model_categories.get(position).getCategoryName());
//                    intent.putExtra("category_id",model_categories.get(position).getId());
//                    context.startActivity(intent);
                }

            }
        });
        holder.tv1.setText(model_categories.get(position).getTv1());
        holder.tv2.setText(model_categories.get(position).getTv2());
        holder.tv3.setText(model_categories.get(position).getTv3());
        boolean isExpanded = model_categories.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.catgoryName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type.equals("cat"))
                {
                    Model_Category model_category = model_categories.get(position);
                    model_category.setExpanded(!model_category.isExpanded());
                    notifyItemChanged(position);
                }

            }
        });
        holder.checkBox.setVisibility(View.GONE);
        holder.radio.setVisibility(View.VISIBLE);

        if (from.equals("cat")){
            holder.checkBox.setVisibility(View.GONE);
            holder.radio.setVisibility(View.VISIBLE);
        }else {
            holder.checkBox.setVisibility(View.VISIBLE);
            holder.radio.setVisibility(View.GONE);
        }
        if (position == getItemCount() - 1) {
            if (selected == null) {
                holder.radio.setChecked(true);
                selected = holder.radio;
            }
        }

        holder.radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selected != null) {
                    selected.setChecked(false);
                }
                holder.radio.setChecked(true);
                selected = holder.radio;
            }
        });
    }

    @Override
    public int getItemCount() {
        return model_categories.size();
    }

    @Override
    public Filter getFilter() {
        if(filter ==null){
            filter = new FilterCategory(this,filterList);
        }
        return filter;
    }


    public static class CategoryHolder extends RecyclerView.ViewHolder {
        public TextView catgoryName,tv1,tv2,tv3;
        public AppCompatCheckBox checkBox;
        public RadioButton radio;
        RelativeLayout onLyoutClickExpand;
        LinearLayout expandableLayout;
        public CategoryHolder(@NonNull View itemView) {
            super(itemView);
            catgoryName = itemView.findViewById(R.id.category_row_name);
            //checkBox = itemView.findViewById(R.id.checkBox);
            radio = itemView.findViewById(R.id.radio);
            onLyoutClickExpand = itemView.findViewById(R.id.onLyoutClickExpand);
            //expandableLayout = itemView.findViewById(R.id.expandableLayout);
            //tv1 = itemView.findViewById(R.id.tv1);
            //tv2 = itemView.findViewById(R.id.tv2);
            //tv3 = itemView.findViewById(R.id.tv3);

        }

    }


}
