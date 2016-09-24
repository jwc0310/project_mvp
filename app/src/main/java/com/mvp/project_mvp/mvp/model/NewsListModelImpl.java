package com.mvp.project_mvp.mvp.model;

import com.mvp.project_mvp.mvp.bean.BaseBean;
import com.mvp.project_mvp.network.MySubscriber;
import com.mvp.project_mvp.network.NetWorkRequest;

/**
 * by 12406 on 2016/5/15.
 */
public class NewsListModelImpl implements BaseModel.NewsListModel {


    @Override
    public void netWorkNewList(int id, int page, final BaseDataBridge.NewsListData newsListData) {

        NetWorkRequest.newsList(id, page, new MySubscriber<BaseBean.NewsListBean>() {

            @Override
            public void onError(Throwable e) {
                newsListData.error();
            }

            @SuppressWarnings("unchecked")
            @Override
            public void onNext(BaseBean.NewsListBean newsListBean) {
                newsListData.addData(newsListBean.getInfo());
            }
        });
    }


}
