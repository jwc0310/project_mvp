package com.mvp.project_mvp.mvp.view;

import com.mvp.project_mvp.mvp.bean.WeatherBean;

/**
 *
 * Created by Andy on 2016/9/26.
 */
public interface WeatherView {
    void showProgress();
    void hideProgress();
    void loadWeather(WeatherBean weatherBean);  //填充ui控件数据
}
