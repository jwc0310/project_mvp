package com.mvp.project_mvp.mvp.presenter;

import com.mvp.project_mvp.R;
import com.mvp.project_mvp.mvp.view.BaseView;

/**
 * by y on 2016/6/12.
 */
public class ToolBarItemPresenterImpl extends BasePresenterImpl<BaseView.ToolBarItemView>
        implements BasePresenter.ToolBarItemPresenter {

    public ToolBarItemPresenterImpl(BaseView.ToolBarItemView view) {
        super(view);
    }


    @Override
    public void switchId(int id) {
        switch (id) {
            case R.id.toolbar_item_share:
                view.switchShare();
                break;
        }
    }
}
