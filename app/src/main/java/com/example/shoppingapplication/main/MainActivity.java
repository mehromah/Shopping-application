package com.example.shoppingapplication.main;

import android.content.Intent;
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
import android.widget.ImageView;
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
import com.example.shoppingapplication.slider.MainSliderAdapter;
import com.example.shoppingapplication.slider.PicassoImageLoadingService;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ss.com.bannerslider.Slider;

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
    private RecyclerView productRecyclerView;

    private ProductAdapter productAdapter;
    private PRSMBL003Adapter prsmbl003Adapter;
    private PRSMBL004Adapter prsmbl004Adapter;
    private PRSMBL005Adapter prsmbl005Adapter;
    private View progressBar;

    private Fragment homeFragment;
    private Fragment categoryListFragment;
    private Fragment bookmarkFragment;
    private Fragment videoNewsListFragment;
    private Stack<Integer> horizontalStack = new Stack<>();


    private ImageView menuBtn;
    public Drawer result;



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
       addDrawer();
//              setupDrawer();

        menuBtn=findViewById(R.id.iv_main_menu);

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.openDrawer();


            }
        });


        drawerFont = ResourcesCompat.getFont(this, R.font.primary_regular);
        userInfoManager = new UserInfoManager1(this);
        viewModel = new MainViewModel();
        observe();
    }

    private void addDrawer() {
        new DrawerBuilder().withActivity(this).build();

        //if you want to update the items at a later time it is recommended to keep it in a variable
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("صفحه نخست");
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(2).withName("تنظیمات");
        SecondaryDrawerItem item3 = new SecondaryDrawerItem().withIdentifier(2).withName("اطلاعات تماس");



        // Create the AccountHeader
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .addProfiles(
                        new ProfileDrawerItem().withName("سامانه همراه مالی").withEmail("http://www.hesabsazanparsian.com/")
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();

//create the drawer and remember the `Drawer` result object
        result = new DrawerBuilder()
                .withActivity(this)
                // .withToolbar(toolbar)
                .withDrawerGravity(Gravity.RIGHT)

                .addDrawerItems(
                        item1,
                        new DividerDrawerItem(),
                        item2,
                        new SecondaryDrawerItem().withName("حساب کاربری"),
                        new SecondaryDrawerItem().withName("سفارشات شخصی"),
                        new SecondaryDrawerItem().withName("سفارشات دیگران"),
                        new SecondaryDrawerItem().withName("سرفصل کالاها"),
                        new SecondaryDrawerItem().withName("پرونده ها"),
                        new SecondaryDrawerItem().withName("گزارشات خروجی"),
                        new SecondaryDrawerItem().withName("تنظیمات"),
                        new DividerDrawerItem(),


                        new SecondaryDrawerItem().withName("خروج"),
                        item3
                )

                .withAccountHeader(headerResult)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D

                        if (drawerItem != null) {
                            Intent intent = null;
                            if (drawerItem.getIdentifier() == 1) {
                                intent = new Intent(MainActivity.this,ReportActivity.class);
                            } else if (drawerItem.getIdentifier() == 2) {
                                intent = new Intent(MainActivity.this,OrdersActivity.class);
                            }
                            /*else if (drawerItem.getIdentifier() == 3) {
                                intent = new Intent(DrawerActivity.this, MultiDrawerActivity.class);
                            } else if (drawerItem.getIdentifier() == 4) {
                                intent = new Intent(DrawerActivity.this, NonTranslucentDrawerActivity.class);
                            } else if (drawerItem.getIdentifier() == 5) {
                                intent = new Intent(DrawerActivity.this, AdvancedActivity.class);
                            } else if (drawerItem.getIdentifier() == 7) {
                                intent = new Intent(DrawerActivity.this, EmbeddedDrawerActivity.class);
                            } else if (drawerItem.getIdentifier() == 8) {
                                intent = new Intent(DrawerActivity.this, FullscreenDrawerActivity.class);
                            } else if (drawerItem.getIdentifier() == 9) {
                                intent = new Intent(DrawerActivity.this, CustomContainerActivity.class);
                            } else if (drawerItem.getIdentifier() == 10) {
                                intent = new Intent(DrawerActivity.this, MenuDrawerActivity.class);
                            } else if (drawerItem.getIdentifier() == 11) {
                                intent = new Intent(DrawerActivity.this, MiniDrawerActivity.class);
                            } else if (drawerItem.getIdentifier() == 12) {
                                intent = new Intent(DrawerActivity.this, FragmentActivity.class);
                            } else if (drawerItem.getIdentifier() == 13) {
                                intent = new Intent(DrawerActivity.this, CollapsingToolbarActivity.class);
                            } else if (drawerItem.getIdentifier() == 14) {
                                intent = new Intent(DrawerActivity.this, PersistentDrawerActivity.class);
                            } else if (drawerItem.getIdentifier() == 15) {
                                intent = new Intent(DrawerActivity.this, CrossfadeDrawerLayoutActvitiy.class);
                            } else if (drawerItem.getIdentifier() == 20) {
                                intent = new LibsBuilder()
                                        .withFields(R.string.class.getFields())
                                        .withActivityStyle(Libs.ActivityStyle.LIGHT_DARK_TOOLBAR)
                                        .intent(DrawerActivity.this);
                            }*/
//                            if (intent != null) {
//                                MainActivity.this.startActivity(intent);
//                            }
                        }

                        return false;
                    }
                })

                .withShowDrawerOnFirstLaunch(true)
                .build();


        //set the selection to the item with the identifier 1
        result.setSelection(1);
//set the selection to the item with the identifier 2
        result.setSelection(item2);
//set the selection and also fire the `onItemClick`-listener
        result.setSelection(1, true);





//the result object also allows you to add new items, remove items, add footer, sticky footer, ..
        result.addItem(new DividerDrawerItem());
//        result.addStickyFooterItem(new PrimaryDrawerItem().withName("StickyFooterItem"));

//remove items with an identifier
        result.removeItem(2);


//open / close the drawer
        result.openDrawer();
        result.closeDrawer();

//get the reference to the `DrawerLayout` itself
        result.getDrawerLayout();


    }




   private void setupViews() {
       Slider.init(new PicassoImageLoadingService(this));

       Slider slider = findViewById(R.id.banner_slider1);
       slider.setAdapter(new MainSliderAdapter());

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

        productRecyclerView = findViewById(R.id.rv_main_popularProducts);
        productRecyclerView.setLayoutManager(new LinearLayoutManager(
                this, LinearLayoutManager.HORIZONTAL, true
        ));

        prsmbl003RecyclerView = findViewById(R.id.rv_main_latestProducts);
        prsmbl003RecyclerView.setLayoutManager(new LinearLayoutManager(
                this, LinearLayoutManager.HORIZONTAL, true
        ));

//        bannerRecyclerView = findViewById(R.id.rv_main_slider);
//        bannerRecyclerView.setLayoutManager(new LinearLayoutManager(
//                this,LinearLayoutManager.HORIZONTAL,true
//        ));
//        bannerAdapter = new BannerAdapter();
//        bannerRecyclerView.setAdapter(bannerAdapter);




    }

//    private void setupDrawer() {
//        accountHeader = new AccountHeaderBuilder()
//                .addProfiles(
//                        profileDrawerItem
//                )
//
//                .withActivity(this)
//                .withTypeface(drawerFont)
//                .withHeaderBackground(ContextCompat.getDrawable(MainActivity.this, R.color.colorPrimary))
//                .build();
//
//        cartDrawerItem = new PrimaryDrawerItem().withName("سبد خرید")
//
//                .withTypeface(drawerFont)
//                .withBadge("0")
//
//                .withBadgeStyle(new BadgeStyle()
//                        .withBadgeBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.shape_badge))
//                        .withTextColor(ContextCompat.getColor(MainActivity.this, R.color.white)))
//                .withSelectable(false);
//        PrimaryDrawerItem orderHistoryDrawerItem = new PrimaryDrawerItem()
//                .withName("سوابق سفارش")
//                .withSelectable(false)
//                .withTypeface(drawerFont);
//
//        PrimaryDrawerItem personalOrder = new PrimaryDrawerItem()
//                .withName("سفارشات شخصی")
//                .withSelectable(false)
//                .withTypeface(drawerFont);
//
//        PrimaryDrawerItem ordersOfOthers = new PrimaryDrawerItem()
//                .withName("سفارشات دیگران")
//                .withSelectable(false)
//                .withTypeface(drawerFont);
//
//        PrimaryDrawerItem outputReports = new PrimaryDrawerItem()
//                .withName("گزارشات خروجی")
//                .withSelectable(false)
//                .withTypeface(drawerFont);
//        PrimaryDrawerItem documents = new PrimaryDrawerItem()
//                .withName("پرونده ها")
//                .withSelectable(false)
//                .withTypeface(drawerFont);
//
//        PrimaryDrawerItem products = new PrimaryDrawerItem()
//                .withName("سرفصل کالاها")
//                .withSelectable(false)
//                .withTypeface(drawerFont);
//        PrimaryDrawerItem setting = new PrimaryDrawerItem()
//                .withName("تنظیمات")
//                .withSelectable(false)
//                .withTypeface(drawerFont);
//
//        PrimaryDrawerItem about = new PrimaryDrawerItem()
//                .withName("سوابق سفارش")
//                .withSelectable(false)
//                .withTypeface(drawerFont);
//
//        PrimaryDrawerItem exit = new PrimaryDrawerItem()
//                .withName("سوابق سفارش")
//                .withSelectable(false)
//                .withTypeface(drawerFont);
//
//
//        drawer = new DrawerBuilder()
//                .withActivity(this)
//                .withSelectedItem(-1)
//                .withAccountHeader(accountHeader)
//                .addDrawerItems(cartDrawerItem, orderHistoryDrawerItem, authDrawerItem)
//                .withDrawerGravity(Gravity.LEFT)
//                .build();
//    }


    private void observe() {

        viewModel.call.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                if (response.body() != null && response.body().getPrsmbl003List().size() > 0) {
                    data = response.body().getPrsmbl003List();
                    data1 = response.body().getPrsmbl004List();
                    data2 = response.body().getPrsmbl005List();
                    prsmbl003Adapter = new PRSMBL003Adapter(data);
                    prsmbl003RecyclerView.setAdapter(prsmbl003Adapter);
                    productAdapter = new ProductAdapter(data,data1,data2);
                    productRecyclerView.setAdapter(productAdapter);



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
