package com.mvp.project_mvp.mvp.model;

import com.mvp.project_mvp.mvp.bean.NewsDetailInfo;
import com.mvp.project_mvp.network.MySubscriber;
import com.mvp.project_mvp.network.NetWorkRequest;

/**
 * by 12406 on 2016/5/30.
 */
public class NewsDetailModelImpl implements BaseModel.NewsDetailModel {

    @Override
    public void netWorkNewsDetail(int id, final BaseDataBridge.NewsDetailData newsDetailData) {

        NetWorkRequest.newsDetail(id, new MySubscriber<NewsDetailInfo>() {
            @Override
            public void onError(Throwable e) {
                super.onError(e);
                newsDetailData.error();
            }

            @Override
            public void onNext(NewsDetailInfo newsDetailInfo) {
                super.onNext(newsDetailInfo);
                newsDetailData.addData(newsDetailInfo);
            }
        });


    }
}
