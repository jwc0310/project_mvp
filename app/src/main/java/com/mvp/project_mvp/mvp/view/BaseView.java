package com.mvp.project_mvp.mvp.view;

import com.mvp.project_mvp.mvp.bean.ImageDetailInfo;
import com.mvp.project_mvp.mvp.bean.ImageListInfo;
import com.mvp.project_mvp.mvp.bean.ImageNewInfo;
import com.mvp.project_mvp.mvp.bean.JokePicBean;
import com.mvp.project_mvp.mvp.bean.JokeTextBean;
import com.mvp.project_mvp.mvp.bean.NewsDetailInfo;
import com.mvp.project_mvp.mvp.bean.NewsListInfo;
import com.mvp.project_mvp.mvp.bean.TabNameInfo;
import com.mvp.project_mvp.mvp.bean.TabNewsInfo;

import java.util.List;

/**
 * by y on 2016/5/27.
 */
public interface BaseView<T> {


    void setData(List<T> datas);

    void netWorkError();

    void hideProgress();

    void showProgress();

    void showFoot();

    void hideFoot();

    interface JokePicView extends BaseView<JokePicBean.JokePicInfo> {
    }

    interface JokeTextView extends BaseView<JokeTextBean.JokeTextInfo> {
    }

    interface ImageDetailView extends BaseView<ImageDetailInfo> {
    }

    interface ImageListView extends BaseView<ImageListInfo> {
    }

    interface ImageNewView extends BaseView<ImageNewInfo> {
    }

    interface NewsListView extends BaseView<NewsListInfo> {
    }

    interface NewsDetailView {
        void setData(NewsDetailInfo datas);

        void netWorkError();

        void hideProgress();

        void showProgress();
    }

    interface TabNameView extends BaseView<TabNameInfo> {
    }

    interface TabNewsView extends BaseView<TabNewsInfo> {
    }

    interface MainView {


        void switchNews();

        void switchImageClassification();

        void switchNewImage();

        void switchJoke();

        void switchAbout();

    }

    interface ToolBarItemView {

        void switchShare();
    }
}
