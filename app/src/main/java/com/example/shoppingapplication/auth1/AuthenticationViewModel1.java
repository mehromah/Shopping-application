package com.example.shoppingapplication.auth1;

import com.example.shoppingapplication.model.api.ApiService;
import com.example.shoppingapplication.model.api.JSONUserResponse;
import com.example.shoppingapplication.providers.ApiServiceProvider;

import io.reactivex.subjects.BehaviorSubject;
import retrofit2.Call;

public class AuthenticationViewModel1 {

    private ApiService apiService = ApiServiceProvider.provideApiService();
    private BehaviorSubject<Boolean> isInLoginMode = BehaviorSubject.create();
    private BehaviorSubject<Boolean> progressBarVisiblitySubject = BehaviorSubject.create();

    Call<JSONUserResponse> callUser = apiService.getUsersJSON();

//    public Completable authenticate(Context context, String email, String password) {
//        progressBarVisiblitySubject.onNext(true);
//        Single<PRSMBL009> singleUser ;
//        if (isInLoginMode.getValue() == null || isInLoginMode.getValue()) {
//
//            singleUser = apiService.getUser(
//                    email, password);
//        }
//        else {
//            singleUser = apiService.registerUser(email, password)
//                    .flatMap(successResponse -> apiService.getUser(email, password));
//        }
//        final UserInfoManager1 userInfoManager1 = new UserInfoManager1(context);
//        return singleUser.doOnSuccess(new Consumer<PRSMBL009>() {
//            @Override
//            public void accept(PRSMBL009 user) throws Exception {
//                    userInfoManager1.saveEmail(email);
//
//
//            }
//        })
//                .doOnEvent(new BiConsumer<PRSMBL009, Throwable>() {
//                    @Override
//                    public void accept(PRSMBL009 user, Throwable throwable) throws Exception {
//                        progressBarVisiblitySubject.onNext(false);
//
//                    }
//
//
//                })
//                .toCompletable();
//    }


    public BehaviorSubject<Boolean> getProgressBarVisiblitySubject() {
        return progressBarVisiblitySubject;
    }
}
