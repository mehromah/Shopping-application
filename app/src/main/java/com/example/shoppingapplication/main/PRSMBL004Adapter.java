package com.example.shoppingapplication.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.shoppingapplication.model.PRSMBL004;

import java.util.ArrayList;

public class PRSMBL004Adapter extends RecyclerView.Adapter<PRSMBL004Adapter.PRSMBL004ViewHolder> {


    private ArrayList<PRSMBL004> Table1 = new ArrayList<>();

    public PRSMBL004Adapter(ArrayList<PRSMBL004> Table1) {
        this.Table1 = Table1;
    }

    @NonNull
    @Override
    public PRSMBL004ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PRSMBL004ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return Table1.size();
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


    public class PRSMBL004ViewHolder extends RecyclerView.ViewHolder {
//        private TextView productTitleTextView;


        public PRSMBL004ViewHolder(View itemView) {
            super(itemView);
//            productTitleTextView = itemView.findViewById(R.id.tv_product_title);

        }

//        public void bindProduct(Product product) {
//           productTitleTextView.setText(product.getCMBL003011());
//
//        }
    }
}
