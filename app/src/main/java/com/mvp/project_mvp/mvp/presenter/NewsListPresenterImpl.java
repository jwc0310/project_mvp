package com.mvp.project_mvp.mvp.presenter;

import com.mvp.project_mvp.activity.NewsDetailActivity;
import com.mvp.project_mvp.mvp.bean.NewsListInfo;
import com.mvp.project_mvp.mvp.model.BaseDataBridge;
import com.mvp.project_mvp.mvp.model.BaseModel;
import com.mvp.project_mvp.mvp.model.NewsListModelImpl;
import com.mvp.project_mvp.mvp.view.BaseView;

import java.util.List;

/**
 * by 12406 on 2016/5/15.
 */
public class NewsListPresenterImpl extends BasePresenterImpl<BaseView.NewsListView>
        implements BasePresenter1.NewsListPresenter, BaseDataBridge.NewsListData {

    private final BaseModel.NewsListModel newsListModel;

    public NewsListPresenterImpl(BaseView.NewsListView view) {
        super(view);
        this.newsListModel = new NewsListModelImpl();
    }


    @Override
    public void requestNetWork(int id, int page, boolean isNull) {
        if (page == 1) {
            view.showProgress();
        } else {
            if (!isNull) {
                view.showFoot();
            }
        }
        newsListModel.netWorkNewList(id, page, this);
    }

    @Override
    public void onClick(NewsListInfo info) {
        NewsDetailActivity.startIntent(info.getId());
    }


    @Override
    public void addData(List<NewsListInfo> tngou) {
        view.setData(tngou);
        view.hideFoot();
        view.hideProgress();
    }

    @Override
    public void error() {
        view.hideFoot();
        view.hideProgress();
        view.netWorkError();
    }
}
