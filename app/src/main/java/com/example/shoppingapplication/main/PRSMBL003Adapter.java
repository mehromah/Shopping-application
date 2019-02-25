package com.example.shoppingapplication.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shoppingapplication.R;
import com.example.shoppingapplication.model.PRSMBL003;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class PRSMBL003Adapter extends RecyclerView.Adapter<PRSMBL003Adapter.PRSMBL003ViewHolder> {
    private List<PRSMBL003> Table ;

    public PRSMBL003Adapter(List<PRSMBL003> Table) {
        this.Table = Table;
    }

    @NonNull
    @Override
    public PRSMBL003ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_prsmbl003, parent, false);

        return new PRSMBL003Adapter.PRSMBL003ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PRSMBL003ViewHolder holder, int position) {
        Picasso.get().load("http://192.168.200.10:6139/images/"+Table.get(position).getCMBL003010()+".jpg").into(holder.PRSMBL003ImageView);

        holder.PRSMBL003TitleTextView.setText(Table.get(position).getCMBL003011());
        holder.PRSMBL003StockTextView.setText(Table.get(position).getNMBL003015());
        holder.PRSMBL003GroupNameTextView.setText(Table.get(position).getCMBL003016());

    }

    @Override
    public int getItemCount() {
        return Table.size();
    }
    /*

    private List<Product> products = new ArrayList<>();

    public ProductAdapter(List<Product> products) {
        this.products = products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }
    */


    public class PRSMBL003ViewHolder extends RecyclerView.ViewHolder {
        private ImageView PRSMBL003ImageView;
        private TextView PRSMBL003TitleTextView;
        private TextView PRSMBL003StockTextView;
        private TextView PRSMBL003GroupNameTextView;



        public PRSMBL003ViewHolder(View itemView) {
            super(itemView);
            PRSMBL003ImageView = itemView.findViewById(R.id.iv_prsmbl003_image);
            PRSMBL003TitleTextView = itemView.findViewById(R.id.tv_prsmbl003_title);
            PRSMBL003StockTextView = itemView.findViewById(R.id.tv_prsmbl003_stock);
            PRSMBL003GroupNameTextView = itemView.findViewById(R.id.tv_prsmbl003_groupName);
        }

//        public void bindProduct(Product product) {
//           productTitleTextView.setText(product.getCMBL003011());
//
//        }
    }
}

