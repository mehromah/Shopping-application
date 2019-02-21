package com.example.shoppingapplication.auth1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shoppingapplication.R;
import com.example.shoppingapplication.base.BaseActivity;
import com.example.shoppingapplication.main.MainActivity;
import com.example.shoppingapplication.model.PRSMBL009;
import com.example.shoppingapplication.model.api.JSONUserResponse;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthenticationActivity extends BaseActivity {
    private EditText emailET;
    private EditText passwordEt;
    private Button authenticationButton;
    private AuthenticationViewModel1 viewModel;
    private View progressBar;
    private PRSMBL009[] userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        viewModel = new AuthenticationViewModel1();
        setupViews();
        observe();
    }

    private void observe() {

        Disposable progressBarDisposable = viewModel.getProgressBarVisiblitySubject().subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(shouldShowProgressBar -> progressBar.setVisibility(shouldShowProgressBar ? View.VISIBLE : View.GONE));


    }

    private void setupViews() {
        emailET = findViewById(R.id.et_auth_email);
        passwordEt = findViewById(R.id.et_auth_password);
        progressBar = findViewById(R.id.ll_auth_progressBar);

        authenticationButton = findViewById(R.id.button_auth_authentication);
        authenticationButton.setOnClickListener(view -> {
//            KeyboardUtil.closeKeyboard(getCurrentFocus());
            if (emailET.getText().toString().isEmpty()) {
                Toast.makeText(this, "لطفا نام کاربری را وارد کنید", Toast.LENGTH_SHORT).show();


            } else if (passwordEt.getText().toString().isEmpty()) {
                Toast.makeText(this, "لطفا رمز عبور را وارد کنید ", Toast.LENGTH_SHORT).show();


            } else if (emailET.getText().toString().equals("ADMIN")) {
                if (passwordEt.getText().toString().equals("123456")) {

                    viewModel.callUser.enqueue(new Callback<JSONUserResponse>() {
                        @Override
                        public void onResponse(Call<JSONUserResponse> call, Response<JSONUserResponse> response) {
                            JSONUserResponse jsonUserResponse = response.body();
                            assert jsonUserResponse != null;
//                            userData = jsonUserResponse.getTable()
                            startActivity(new Intent(AuthenticationActivity.this, MainActivity.class));
                            Toast.makeText(AuthenticationActivity.this, "خوش آمدید", Toast.LENGTH_LONG).show();


                        }

                        @Override
                        public void onFailure(Call<JSONUserResponse> call, Throwable t) {
                            Log.d("Error", t.getMessage());

                        }
                    });
                } else {
                    Toast.makeText(this, "نام کاربری یا رمز عبور اشتباه است", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "نام کاربری یا رمز عبور اشتباه است", Toast.LENGTH_SHORT).show();
            }


        });


    }


    @Override
    public int getCoordinatorLayoutId() {
        return R.id.relativeLayout_auth_root;
    }
}
