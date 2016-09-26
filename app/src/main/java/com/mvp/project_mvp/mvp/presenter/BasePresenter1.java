package com.mvp.project_mvp.mvp.presenter;

import com.mvp.project_mvp.mvp.bean.ImageListInfo;
import com.mvp.project_mvp.mvp.bean.ImageNewInfo;
import com.mvp.project_mvp.mvp.bean.NewsListInfo;

/**
 * by y on 2016/5/27.
 */
@SuppressWarnings("ALL")
public interface BasePresenter1 {


    interface ImageDetailPresenter {
        void requestNetWork(int id);

        void competence(int requestCode, int[] grantResults);
    }

    interface ImageListPresenter {
        void requestNetWork(int id, int page, boolean isNull);

        void onClick(ImageListInfo info);
    }

    interface ImageNewPresenter {
        void requestNetWork(String id, String rows);

        void onClick(ImageNewInfo info);
    }

    interface MainViewPresenter {
        void switchId(int id);
    }

    interface ToolBarItemPresenter {
        void switchId(int id);
    }


    interface NewsListPresenter {
        void requestNetWork(int id, int page, boolean isNull);

        void onClick(NewsListInfo info);
    }

    interface NewsDetailPresenter {
        void requestNetWork(int id);
    }

    interface TabNamePresenter {
        void requestNetWork();
    }

    interface TabNewsPresenter {
        void requestNetWork();
    }

    interface JokeTextPresenter {
        void requestNetWork(int page, boolean isNull);
    }

    interface JokePicPresenter {
        void requestNetWork(int page, boolean isNull);
    }


}
