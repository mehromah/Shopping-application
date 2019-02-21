package com.example.shoppingapplication.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.shoppingapplication.model.PRSMBL005;

import java.util.ArrayList;

public class PRSMBL005Adapter extends RecyclerView.Adapter<PRSMBL005Adapter.PRSMBL005ViewHolder> {


    private ArrayList<PRSMBL005> Table2 = new ArrayList<>();

    public PRSMBL005Adapter(ArrayList<PRSMBL005> Table2) {
        this.Table2 = Table2;
    }

    @NonNull
    @Override
    public PRSMBL005ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PRSMBL005ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return Table2.size();
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


    public class PRSMBL005ViewHolder extends RecyclerView.ViewHolder {
//        private TextView productTitleTextView;


        public PRSMBL005ViewHolder(View itemView) {
            super(itemView);
//            productTitleTextView = itemView.findViewById(R.id.tv_product_title);

        }

//        public void bindProduct(Product product) {
//           productTitleTextView.setText(product.getCMBL003011());
//
//        }
    }
}
