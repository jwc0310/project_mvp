package com.mvp.project_mvp.mvp.model;

import com.mvp.project_mvp.api.ApiManager;
import com.mvp.project_mvp.mvp.bean.WeatherBean;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 *
 * Created by Administrator on 2016/9/26.
 */
public class WeatherModelImpl implements WeatherModel {

    private WeatherOnListener weatherOnListener;

    public WeatherModelImpl(WeatherOnListener weatherOnListener){
        this.weatherOnListener = weatherOnListener;
    }

    @Override
    public Subscription getWeatherData(String format, String city) {
        Observable<WeatherBean> request = ApiManager.getWeatherData(format, city);
        Subscription subscription = request.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<WeatherBean>() {
                    @Override
                    public void call(WeatherBean weatherBean) {
                        weatherOnListener.onSuccess(weatherBean);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        weatherOnListener.onFailure(throwable);
                    }
                });

        return subscription;
    }

    /**
     * 回调接口
     */
    public interface WeatherOnListener{
        void onSuccess(WeatherBean s);
        void onFailure(Throwable t);
    }

}
