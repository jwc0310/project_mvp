package com.mvp.project_mvp.network;

import com.mvp.project_mvp.mvp.bean.BaseBean;
import com.mvp.project_mvp.mvp.bean.JokePicBean;
import com.mvp.project_mvp.mvp.bean.JokeTextBean;
import com.mvp.project_mvp.mvp.bean.NewsDetailInfo;
import com.mvp.project_mvp.mvp.bean.TabNewsInfo;
import com.mvp.project_mvp.utils.LogUtils;
import com.mvp.project_mvp.utils.RxUtils;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * by y on 2016/5/6.
 */
public class NetWorkRequest {


    public static void newsDetail(int id, Subscriber<NewsDetailInfo> subscriber) {
        RxUtils.unsubscribe();
        RxUtils.subscription = Network.getTngouApi().getNewsDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void newsList(int id, int page, Subscriber<BaseBean.NewsListBean> subscriber) {
        RxUtils.unsubscribe();
        RxUtils.subscription = Network.getTngouApi().getNewsList(id, page)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void tabNews(Subscriber<BaseBean.TabNewsBean> subscriber) {
        RxUtils.unsubscribe();
        RxUtils.subscription = Network.getTngouApi().getTabNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void imageDetail(int id, Subscriber<BaseBean.ImageDetailBean> subscriber) {
        RxUtils.unsubscribe();
        RxUtils.subscription = Network.getTngouApi().getImageDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void imageList(int id, int page, Subscriber<BaseBean.ImageListBean> subscriber) {
        RxUtils.unsubscribe();
        RxUtils.subscription = Network.getTngouApi().getImageList(id, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void imageNew(int id, int rows, Subscriber<BaseBean.ImageNewBean> subscriber) {
        RxUtils.unsubscribe();
        RxUtils.subscription = Network.getTngouApi().getImageNews(id, rows)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void tabName(Subscriber<BaseBean.TabNameBean> subscriber) {
        RxUtils.unsubscribe();
        RxUtils.subscription = Network.getTngouApi().getTabName()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


    /////////////////////////////////////////////////////////////

    public static void jokeTextList(int page, Subscriber<JokeTextBean> subscriber) {
        RxUtils.unsubscribe();
        RxUtils.subscription = Network.getBaiDuApi().getJokeText(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void jokePicList(int page, Subscriber<JokePicBean> subscriber) {
        RxUtils.unsubscribe();
        RxUtils.subscription = Network.getBaiDuApi().getJokePic(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


}
