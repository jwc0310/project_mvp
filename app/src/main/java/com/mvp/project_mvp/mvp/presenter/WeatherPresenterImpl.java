package com.mvp.project_mvp.mvp.presenter;

import android.util.Log;

import com.mvp.project_mvp.mvp.bean.WeatherBean;
import com.mvp.project_mvp.mvp.model.WeatherModel;
import com.mvp.project_mvp.mvp.model.WeatherModelImpl;
import com.mvp.project_mvp.mvp.view.WeatherView;

/**
 *
 * Created by Administrator on 2016/9/26.
 */
public class WeatherPresenterImpl extends WeatherPresenter implements WeatherModelImpl.WeatherOnListener {

    /**
     * WeatherModel和WeatherView都是通过接口来实现，这就Java设计原则中依赖倒置原则使用
     */
    private WeatherModel weatherModel;
    private WeatherView weatherView;

    public WeatherPresenterImpl(WeatherView weatherView){
        this.weatherView = weatherView;
        this.weatherModel = new WeatherModelImpl(this);
    }

    @Override
    public void onSuccess(WeatherBean s) {
        weatherView.loadWeather(s);
        weatherView.hideProgress();
        Log.d("-------", "onSuccess() called with: " + "s = [" + s.toString() + "]");
    }

    @Override
    public void onFailure(Throwable t) {
        weatherView.hideProgress();
        Log.d("-------", "onFailure" + t.getMessage());
    }

    @Override
    public void getWeahterData(String format, String city) {
        weatherView.showProgress();
        addSubscription(weatherModel.getWeatherData(format, city));
    }
}
