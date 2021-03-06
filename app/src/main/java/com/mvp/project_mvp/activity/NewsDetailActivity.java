package com.mvp.project_mvp.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mvp.project_mvp.R;
import com.mvp.project_mvp.mvp.bean.NewsDetailInfo;
import com.mvp.project_mvp.mvp.presenter.BasePresenter1;
import com.mvp.project_mvp.mvp.presenter.NewsDetailPresenterImpl;
import com.mvp.project_mvp.mvp.presenter.ToolBarItemPresenterImpl;
import com.mvp.project_mvp.mvp.view.BaseView;
import com.mvp.project_mvp.network.Api;
import com.mvp.project_mvp.utils.ActivityUtils;
import com.mvp.project_mvp.utils.ImageLoaderUtils;
import com.mvp.project_mvp.utils.UIUtils;

import butterknife.Bind;

/**
 * by 12406 on 2016/5/30.
 */
public class NewsDetailActivity extends BaseActivity
        implements BaseView.NewsDetailView, BaseView.ToolBarItemView {

    @SuppressWarnings("unused")
    @Bind(R.id.image)
    ImageView image;
    @SuppressWarnings("unused")
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @SuppressWarnings("unused")
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @SuppressWarnings("unused")
    @Bind(R.id.content)
    TextView content;
    @SuppressWarnings("unused")
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private int id;
    private String message;
    private BasePresenter1.ToolBarItemPresenter toolBarItemPresenter;


    public static void startIntent(int id) {
        Bundle bundle = new Bundle();
        bundle.putInt("id", id);
        ActivityUtils.startActivity(NewsDetailActivity.class, bundle);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        getBundle();
        init();
    }

    private void init() {
        BasePresenter1.NewsDetailPresenter newsDetailPresenter = new NewsDetailPresenterImpl(this);
        toolBarItemPresenter = new ToolBarItemPresenterImpl(this);
        newsDetailPresenter.requestNetWork(id);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                toolBarItemPresenter.switchId(item.getItemId());
                return true;
            }
        });

    }

    private void getBundle() {
        Bundle bundle = getIntent().getExtras();
        if (!bundle.isEmpty()) {
            id = bundle.getInt("id");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }


    @Override
    public void setData(NewsDetailInfo datas) {
        ImageLoaderUtils.display(getApplicationContext(), image, Api.IMAGER_URL + datas.getImg());
        content.setText(Html.fromHtml(datas.getMessage()));
        collapsingToolbar.setTitle(datas.getTitle());
        message = String.valueOf(Html.fromHtml(datas.getMessage()));
    }

    @Override
    public void switchShare() {
        ActivityUtils.share(message);
    }

    @Override
    public void netWorkError() {
        Toast(UIUtils.getString(R.string.network_error));
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_news_detail;
    }
}
