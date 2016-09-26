package com.mvp.project_mvp.api;

import com.mvp.project_mvp.mvp.bean.WeatherBean;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 *
 * Created by Administrator on 2016/9/26.
 */
public class ApiManager {

    private static final String ENDPOINT = "http://v.juhe.cn";

    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();

    private static final ApiManagerService apiManager = retrofit.create(ApiManagerService.class);

    public static Observable<WeatherBean> getWeatherData(String format, String city) {
        return apiManager.getWeatherData(format, city, "ad1d20bebafe0668502c8eea5ddd0333");
    }

}
