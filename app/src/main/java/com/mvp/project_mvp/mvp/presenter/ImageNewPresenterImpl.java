package com.mvp.project_mvp.mvp.presenter;

import android.widget.Toast;

import com.mvp.project_mvp.R;
import com.mvp.project_mvp.activity.ImageDetailActivity;
import com.mvp.project_mvp.mvp.bean.ImageNewInfo;
import com.mvp.project_mvp.mvp.model.BaseDataBridge;
import com.mvp.project_mvp.mvp.model.BaseModel;
import com.mvp.project_mvp.mvp.model.ImageNewModelImpl;
import com.mvp.project_mvp.mvp.view.BaseView;
import com.mvp.project_mvp.utils.ActivityUtils;
import com.mvp.project_mvp.utils.UIUtils;

import java.util.List;

/**
 * by y on 2016/4/29.
 */
public class ImageNewPresenterImpl extends BasePresenterImpl<BaseView.ImageNewView>
        implements BasePresenter1.ImageNewPresenter, BaseDataBridge.ImageNewData {

    private final BaseModel.ImageNewModel imageNewModel;


    public ImageNewPresenterImpl(BaseView.ImageNewView view) {
        super(view);
        this.imageNewModel = new ImageNewModelImpl();
    }


    @Override
    public void requestNetWork(String id, String rows) {

        if (id.isEmpty()) {
            view.hideProgress();
            Toast.makeText(UIUtils.getContext(), UIUtils.getString(R.string.image_new_id), Toast.LENGTH_LONG).show();
        } else {
            if (rows.isEmpty()) {
                rows = "20";
            }
            if (ActivityUtils.syskeyBroadStatus()) {
                ActivityUtils.closeSyskeyBroad();
            }
            view.showProgress();
            imageNewModel.netWorkNew(Integer.valueOf(id), Integer.valueOf(rows), this);
        }
    }

    @Override
    public void onClick(ImageNewInfo info) {
        ImageDetailActivity.startIntent(info.getId(), info.getTitle());
    }

    @Override
    public void addData(List<ImageNewInfo> imageNewInfo) {
        view.setData(imageNewInfo);
        view.hideProgress();
    }

    @Override
    public void error() {
        view.hideProgress();
        view.netWorkError();
    }
}
