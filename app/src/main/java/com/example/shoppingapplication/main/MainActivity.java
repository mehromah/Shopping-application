package com.example.shoppingapplication.main;

import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shoppingapplication.R;
import com.example.shoppingapplication.auth1.UserInfoManager1;
import com.example.shoppingapplication.base.BaseActivity;
import com.example.shoppingapplication.model.PRSMBL003;
import com.example.shoppingapplication.model.PRSMBL004;
import com.example.shoppingapplication.model.PRSMBL005;
import com.example.shoppingapplication.model.api.JSONUserResponse;
import com.example.shoppingapplication.model.api.JsonResponse;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private MainViewModel viewModel;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private BannerAdapter bannerAdapter;
    private Drawer drawer;
    private UserInfoManager1 userInfoManager;
    private PrimaryDrawerItem authDrawerItem;
    private ProfileDrawerItem profileDrawerItem;
    private AccountHeader accountHeader;
    private Typeface drawerFont;
    private TextView cartItemCountBadge;
    private PrimaryDrawerItem cartDrawerItem;
    private RecyclerView prsmbl003RecyclerView;
    private RecyclerView bannerRecyclerView;

    private PRSMBL003Adapter prsmbl003Adapter;
    private PRSMBL004Adapter prsmbl004Adapter;
    private PRSMBL005Adapter prsmbl005Adapter;
    private View progressBar;

    private Fragment homeFragment;
    private Fragment categoryListFragment;
    private Fragment bookmarkFragment;
    private Fragment videoNewsListFragment;
    private Stack<Integer> horizontalStack = new Stack<>();


//    private BottomNavigation bottomNavigation;



    private TextView timerTextView;

    private TextView mTextMessage;

    private List<PRSMBL003> data;
    private List<PRSMBL004> data1;
    private List<PRSMBL005> data2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextMessage = findViewById(R.id.message);
        setupViews();


        drawerFont = ResourcesCompat.getFont(this, R.font.primary_regular);
        userInfoManager = new UserInfoManager1(this);
        viewModel = new MainViewModel();
        //    setupDrawer();
        observe();
    }

    private void setupViews() {
//        progressBar = findViewById(R.id.frame_main_progressBarContainer);

//        bottomNavigation = findViewById(R.id.bottomNavigation_main);
//        bottomNavigation.setTypeface(ResourcesCompat.getFont(this, R.font.primary_bold));
//
//        bottomNavigation.setOnSelectedItemChangeListener(new OnSelectedItemChangeListener() {
//            @Override
//            public void onSelectedItemChanged(int i) {
//                progressBar.setVisibility(View.GONE);
//                horizontalStack.add(i);
//                switch (i) {
//                    case R.id.tab_home:
//                        if (homeFragment == null)
//                            homeFragment = new Fragment1();
////                        replaceTransaction(homeFragment);
//                        break;
//                    case R.id.tab_category:
//                        if (categoryListFragment == null)
//                            categoryListFragment = new Fragment2();
////                        replaceTransaction(categoryListFragment);
//                        break;
//                    case R.id.tab_bookmarks:
//                        if (bookmarkFragment == null)
//                            bookmarkFragment = new Fragment3();
////                        replaceTransaction(bookmarkFragment);
//                        break;
//                    case R.id.tab_videos:
//                        if (videoNewsListFragment == null)
//                            videoNewsListFragment = new Fragment4();
////                        replaceTransaction(videoNewsListFragment);
//                        break;
//                }
//            }
//        });

        prsmbl003RecyclerView = findViewById(R.id.rv_main_latestProducts);
        prsmbl003RecyclerView.setLayoutManager(new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, true
        ));

        bannerRecyclerView = findViewById(R.id.rv_main_slider);
        bannerRecyclerView.setLayoutManager(new LinearLayoutManager(
                this,LinearLayoutManager.HORIZONTAL,true
        ));
        bannerAdapter = new BannerAdapter();
        bannerRecyclerView.setAdapter(bannerAdapter);




    }

    private void setupDrawer() {
        accountHeader = new AccountHeaderBuilder()
                .addProfiles(
                        profileDrawerItem
                )

                .withActivity(this)
                .withTypeface(drawerFont)
                .withHeaderBackground(ContextCompat.getDrawable(MainActivity.this, R.color.colorPrimary))
                .build();

        cartDrawerItem = new PrimaryDrawerItem().withName("سبد خرید")

                .withTypeface(drawerFont)
                .withBadge("0")

                .withBadgeStyle(new BadgeStyle()
                        .withBadgeBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.shape_badge))
                        .withTextColor(ContextCompat.getColor(MainActivity.this, R.color.white)))
                .withSelectable(false);
        PrimaryDrawerItem orderHistoryDrawerItem = new PrimaryDrawerItem()
                .withName("سوابق سفارش")
                .withSelectable(false)
                .withTypeface(drawerFont);

        PrimaryDrawerItem personalOrder = new PrimaryDrawerItem()
                .withName("سفارشات شخصی")
                .withSelectable(false)
                .withTypeface(drawerFont);

        PrimaryDrawerItem ordersOfOthers = new PrimaryDrawerItem()
                .withName("سفارشات دیگران")
                .withSelectable(false)
                .withTypeface(drawerFont);

        PrimaryDrawerItem outputReports = new PrimaryDrawerItem()
                .withName("گزارشات خروجی")
                .withSelectable(false)
                .withTypeface(drawerFont);
        PrimaryDrawerItem documents = new PrimaryDrawerItem()
                .withName("پرونده ها")
                .withSelectable(false)
                .withTypeface(drawerFont);

        PrimaryDrawerItem products = new PrimaryDrawerItem()
                .withName("سرفصل کالاها")
                .withSelectable(false)
                .withTypeface(drawerFont);
        PrimaryDrawerItem setting = new PrimaryDrawerItem()
                .withName("تنظیمات")
                .withSelectable(false)
                .withTypeface(drawerFont);

        PrimaryDrawerItem about = new PrimaryDrawerItem()
                .withName("سوابق سفارش")
                .withSelectable(false)
                .withTypeface(drawerFont);

        PrimaryDrawerItem exit = new PrimaryDrawerItem()
                .withName("سوابق سفارش")
                .withSelectable(false)
                .withTypeface(drawerFont);


        drawer = new DrawerBuilder()
                .withActivity(this)
                .withSelectedItem(-1)
                .withAccountHeader(accountHeader)
                .addDrawerItems(cartDrawerItem, orderHistoryDrawerItem, authDrawerItem)
                .withDrawerGravity(Gravity.RIGHT)
                .build();
    }


    private void observe() {

        viewModel.call.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                if (response.body() != null && response.body().getPrsmbl003List().size() > 0) {
                    data = response.body().getPrsmbl003List();
                    Toast.makeText(MainActivity.this, "اطلاعات با موفقیت دریافت شد", Toast.LENGTH_LONG).show();

                }


            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "خطا در دریافت اطلاعات", Toast.LENGTH_LONG).show();

                Log.d("Error", t.getMessage());

            }
        });

        viewModel.callUser.enqueue(new Callback<JSONUserResponse>() {
            @Override
            public void onResponse(Call<JSONUserResponse> call, Response<JSONUserResponse> response) {
                if (response.body() != null && response.body().getTable().size() > 0) {
                    Toast.makeText(MainActivity.this, "اطلاعات با موفقیت دریافت شد", Toast.LENGTH_LONG).show();


                }


            }

            @Override
            public void onFailure(Call<JSONUserResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "خطا در دریافت اطلاعات", Toast.LENGTH_LONG).show();

                Log.d("Error", t.getMessage());




            }
        });







    }

    @Override
    protected void onResume() {
        super.onResume();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }


    @Override
    public int getCoordinatorLayoutId() {
        return R.id.coordinator_main;
    }

    @Override
    public void onClick(View v) {

    }
}
