package com.mvp.project_mvp.mvp.presenter;

/**
 *
 * Created by Administrator on 2016/9/26.
 */
public abstract class WeatherPresenter extends BasePresenter {

    public abstract void getWeahterData(String format, String city);
}
