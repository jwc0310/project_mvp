package com.mvp.project_mvp.api;

import com.mvp.project_mvp.mvp.bean.WeatherBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 *
 * Created by Administrator on 2016/9/26.
 */
public interface ApiManagerService {

    @GET("/weather/index")
    Observable<WeatherBean> getWeatherData(@Query("format") String format, @Query("cityname") String cityname, @Query("key") String key);

}
