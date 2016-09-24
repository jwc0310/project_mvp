package com.mvp.project_mvp.mvp.presenter;

import com.mvp.project_mvp.R;
import com.mvp.project_mvp.mvp.view.BaseView;

/**
 * by 12406 on 2016/5/1.
 */
public class MainViewPresenterImpl extends BasePresenterImpl<BaseView.MainView>
        implements BasePresenter.MainViewPresenter {


    public MainViewPresenterImpl(BaseView.MainView view) {
        super(view);
    }

    @Override
    public void switchId(int id) {
        switch (id) {
            case R.id.navigation_item_news:
                view.switchNews();
                break;
            case R.id.navigation_item_image_classification:
                view.switchImageClassification();
                break;
            case R.id.navigation_item_new_image:
                view.switchNewImage();
                break;
            case R.id.navigation_item_joke:
                view.switchJoke();
                break;
            case R.id.navigation_about:
                view.switchAbout();
                break;
        }
    }
}
