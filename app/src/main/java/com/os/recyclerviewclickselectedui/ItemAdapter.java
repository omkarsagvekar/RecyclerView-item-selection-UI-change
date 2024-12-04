package com.os.recyclerviewclickselectedui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder>{
    ArrayList<String> arrList;
    Context context;
    public int selectedPosition  = -1;
    private OnItemClickListener onItemClickListener;

    public ItemAdapter(ArrayList<String> arrList, Context context) {
        this.arrList = arrList;
        this.context = context;
    }

    public void addOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tvFruitName.setText(arrList.get(position));
        if (selectedPosition == position){
            holder.tvFruitName.setTextAppearance(R.style.color_item_selected);
            holder.clItem.setBackgroundResource(R.drawable.bg_item_selected);

        }else{
            holder.tvFruitName.setTextAppearance(R.style.color_after_search_type_unselected);
            holder.clItem.setBackgroundResource(R.drawable.bg_for_item);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(arrList.get(position));

                selectedPosition = position;
                notifyItemChanged(selectedPosition);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvFruitName;
        ConstraintLayout clItem;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFruitName = itemView.findViewById(R.id.tvFruit);
            clItem = itemView.findViewById(R.id.clItem);
        }
    }
    public interface OnItemClickListener {
        void onItemClick(String fruit);
    }
}
