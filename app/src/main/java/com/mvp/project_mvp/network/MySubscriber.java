package com.mvp.project_mvp.network;

import com.mvp.project_mvp.utils.LogUtils;

import rx.Subscriber;

/**
 * by y on 2016/5/6.
 */
public class MySubscriber<T> extends Subscriber<T> {

    @Override
    public void onStart() {
        super.onStart();
        LogUtils.e("MySubscriber", "onStart被调用了");
    }

    @Override
    public void onCompleted() {
        LogUtils.e("MySubscriber", "onCompleted被调用了");
    }

    @Override
    public void onError(Throwable e) {
        LogUtils.e("Throwable", e.getMessage());
        LogUtils.e("MySubscriber", "onError被调用了");
    }

    @Override
    public void onNext(T t) {
        LogUtils.e("MySubscriber", "onNext被调用了");
    }
}
