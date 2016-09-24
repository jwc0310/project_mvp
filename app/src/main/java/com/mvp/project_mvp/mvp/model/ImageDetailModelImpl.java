package com.mvp.project_mvp.mvp.model;

import com.mvp.project_mvp.mvp.bean.BaseBean;
import com.mvp.project_mvp.network.MySubscriber;
import com.mvp.project_mvp.network.NetWorkRequest;

/**
 * by y on 2016/4/29.
 */
public class ImageDetailModelImpl implements BaseModel.ImageDetailModel {


    @Override
    public void netWorkDetail(int id, final BaseDataBridge.ImageDetailData imageDetailData) {

        NetWorkRequest.imageDetail(id, new MySubscriber<BaseBean.ImageDetailBean>() {

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                imageDetailData.error();
            }

            @SuppressWarnings("unchecked")
            @Override
            public void onNext(BaseBean.ImageDetailBean imageDetailBean) {
                super.onNext(imageDetailBean);
                imageDetailData.addData(imageDetailBean.getList());
            }
        });
    }


}
