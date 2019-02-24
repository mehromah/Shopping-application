package com.example.shoppingapplication.sortList;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shoppingapplication.R;


public class SortAdapter extends RecyclerView.Adapter<SortAdapter.SortViewHolder> {
    private String[] sortTypeIds = new String[]{
            "مواد غذایی",
            "حبوبات",
            "چای",
            "لوازم خانگی",
            "مواد بهداشتی و آرایشی",
            "مواد بهداشتی",
            "مواد پاک کننده و سفید کننده",
            "مواد شوینده",
            "کفش",
            "مواد پروتئینی",
            "ترشیجات و سس",
            "بیمه نوین",
            " اسباب بازی",
            " قند و شکر",
            "پوشاک و پارچه",
            "کامپیوتر و لوازم جانبی",
            "لوازم التحریر"
    };
    private Context context;
    private int selectedSortType;
    private OnSortClickListener onSortClickListener;

    public SortAdapter(Context context, int selectedSortType, OnSortClickListener onSortClickListener) {
        this.context = context;
        this.selectedSortType = selectedSortType;
        this.onSortClickListener = onSortClickListener;
    }

    @NonNull
    @Override
    public SortViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SortViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_sort_chips, parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull final SortViewHolder holder, int position) {
        holder.titleTextView.setText(sortTypeIds[position]);
        if (position == selectedSortType) {
            holder.titleTextView.setBackgroundResource(R.drawable.shape_chips_selected);
            holder.titleTextView.setTextColor(ContextCompat.getColor(context, R.color.white));
        } else {
            holder.titleTextView.setBackgroundResource(R.drawable.shape_chips_unselected);
            holder.titleTextView.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.getAdapterPosition() != selectedSortType) {
                    onSortClickListener.onClick(holder.getAdapterPosition());
                    notifyItemChanged(selectedSortType);
                    selectedSortType = holder.getAdapterPosition();
                    notifyItemChanged(selectedSortType);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return sortTypeIds.length;
    }

    public class SortViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;

        public SortViewHolder(View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView;
        }
    }

    public interface OnSortClickListener {
        void onClick(int sortType);
    }
}
