package com.example.shoppingapplication.data;

import com.example.shoppingapplication.model.PRSMBL003;
import com.example.shoppingapplication.model.PRSMBL004;
import com.example.shoppingapplication.model.PRSMBL005;
import com.example.shoppingapplication.model.PRSMBL009;

import java.util.List;

import io.reactivex.Single;

public interface NewsDataSource {






//    Single<List<Product>> searchProduct(String keyword);



    Single<List<PRSMBL003>> getPRSMBL003();
    Single<List<PRSMBL004>> getPRSMBL004();
    Single<List<PRSMBL005>> getPRSMBL005();
    Single<List<PRSMBL009>> getPRSMBL009();




}
