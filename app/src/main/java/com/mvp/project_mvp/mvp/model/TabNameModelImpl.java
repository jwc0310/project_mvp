package com.mvp.project_mvp.mvp.model;

import com.mvp.project_mvp.mvp.bean.BaseBean;
import com.mvp.project_mvp.network.MySubscriber;
import com.mvp.project_mvp.network.NetWorkRequest;

/**
 * by y on 2016/4/28.
 */
public class TabNameModelImpl implements BaseModel.TabNameModel {


    @Override
    public void netWork(final BaseDataBridge.TabNameData tabNameData) {
        NetWorkRequest.tabName(new MySubscriber<BaseBean.TabNameBean>() {
            @Override
            public void onError(Throwable e) {
                tabNameData.error();
            }

            @SuppressWarnings("unchecked")
            @Override
            public void onNext(BaseBean.TabNameBean tabNameBean) {
                tabNameData.addData(tabNameBean.getInfo());
            }
        });
    }


}
