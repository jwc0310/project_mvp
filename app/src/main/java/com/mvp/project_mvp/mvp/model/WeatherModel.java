package com.mvp.project_mvp.mvp.model;

import rx.Subscription;

/**
 *
 * Created by Administrator on 2016/9/26.
 */
public interface WeatherModel {
    /**
     * 获取天气信息
     * @param format
     * @param city
     * @return
     */
    Subscription getWeatherData(String format, String city);
}
