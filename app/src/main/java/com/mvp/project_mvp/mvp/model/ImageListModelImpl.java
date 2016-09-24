package com.mvp.project_mvp.mvp.model;

import com.mvp.project_mvp.mvp.bean.BaseBean;
import com.mvp.project_mvp.network.MySubscriber;
import com.mvp.project_mvp.network.NetWorkRequest;

/**
 * by y on 2016/4/28.
 */
public class ImageListModelImpl implements BaseModel.ImageListModel {

    @Override
    public void netWorkList(int id, final int page, final BaseDataBridge.ImageListData imageListData) {

        NetWorkRequest.imageList(id, page, new MySubscriber<BaseBean.ImageListBean>() {
            @Override
            public void onError(Throwable e) {
                imageListData.error();
            }

            @SuppressWarnings("unchecked")
            @Override
            public void onNext(BaseBean.ImageListBean imageListBean) {
                imageListData.addData(imageListBean.getInfo());
            }
        });
    }


}
