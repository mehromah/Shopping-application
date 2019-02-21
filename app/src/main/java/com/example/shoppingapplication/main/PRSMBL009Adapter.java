package com.example.shoppingapplication.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.shoppingapplication.model.PRSMBL009;

import java.util.ArrayList;

public class PRSMBL009Adapter extends RecyclerView.Adapter<PRSMBL009Adapter.PRSMBL009ViewHolder> {
    private ArrayList<PRSMBL009> Table = new ArrayList<>();

    public PRSMBL009Adapter(ArrayList<PRSMBL009> Table1) {
        this.Table = Table1;
    }

    @NonNull
    @Override
    public PRSMBL009Adapter.PRSMBL009ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PRSMBL009Adapter.PRSMBL009ViewHolder holder, int position) {

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


    public class PRSMBL009ViewHolder extends RecyclerView.ViewHolder {
//        private TextView productTitleTextView;


        public PRSMBL009ViewHolder(View itemView) {
            super(itemView);
//            productTitleTextView = itemView.findViewById(R.id.tv_product_title);

        }

//        public void bindProduct(Product product) {
//           productTitleTextView.setText(product.getCMBL003011());
//
//        }
    }
}
