package com.mvp.project_mvp.mvp.presenter;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 *
 * Created by Administrator on 2016/9/26.
 */
public class BasePresenter {

    protected CompositeSubscription compositeSubscription;

    //Rxjava取消注册,以避免内存泄露
    public void onUnsubscribe() {
        if (compositeSubscription != null && compositeSubscription.hasSubscriptions()) {
            compositeSubscription.unsubscribe();
        }
    }

    //Rxjava注册
    public void addSubscription(Subscription subscripter){
        if (compositeSubscription == null){
            compositeSubscription = new CompositeSubscription();
        }
        compositeSubscription.add(subscripter);
    }

}
