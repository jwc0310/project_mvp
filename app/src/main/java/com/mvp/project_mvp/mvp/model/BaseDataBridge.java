package com.mvp.project_mvp.mvp.model;

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
public interface BaseDataBridge<T> {

    void addData(List<T> datas);

    void error();


    interface ImageDetailData extends BaseDataBridge<ImageDetailInfo> {
    }

    interface ImageListData extends BaseDataBridge<ImageListInfo> {
    }

    interface ImageNewData extends BaseDataBridge<ImageNewInfo> {
    }

    interface NewsListData extends BaseDataBridge<NewsListInfo> {
    }

    interface NewsDetailData {
        void addData(NewsDetailInfo datas);
        void error();
    }

    interface TabNewsData extends BaseDataBridge<TabNewsInfo> {
    }

    interface TabNameData extends BaseDataBridge<TabNameInfo> {
    }

    interface JokeTextList extends BaseDataBridge<JokeTextBean.JokeTextInfo> {
    }

    interface JokePicList extends BaseDataBridge<JokePicBean.JokePicInfo> {
    }
}
