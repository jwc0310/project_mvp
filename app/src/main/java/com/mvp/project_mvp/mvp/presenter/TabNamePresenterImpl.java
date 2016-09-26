package com.mvp.project_mvp.mvp.presenter;

import com.mvp.project_mvp.mvp.bean.TabNameInfo;
import com.mvp.project_mvp.mvp.model.BaseDataBridge;
import com.mvp.project_mvp.mvp.model.BaseModel;
import com.mvp.project_mvp.mvp.model.TabNameModelImpl;
import com.mvp.project_mvp.mvp.view.BaseView;

import java.util.List;

/**
 * by y on 2016/4/29.
 */
public class TabNamePresenterImpl extends BasePresenterImpl<BaseView.TabNameView>
        implements BasePresenter1.TabNamePresenter, BaseDataBridge.TabNameData {

    private final BaseModel.TabNameModel tabNameModel;

    public TabNamePresenterImpl(BaseView.TabNameView view) {
        super(view);
        this.tabNameModel = new TabNameModelImpl();
    }


    @Override
    public void requestNetWork() {
        tabNameModel.netWork(this);
    }

    @Override
    public void addData(List<TabNameInfo> tabNameInfo) {
        view.setData(tabNameInfo);
    }

    @Override
    public void error() {
        view.netWorkError();
    }
}
