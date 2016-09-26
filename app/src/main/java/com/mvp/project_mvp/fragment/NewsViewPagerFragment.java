package com.mvp.project_mvp.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.mvp.project_mvp.R;
import com.mvp.project_mvp.adapter.TabNewsAdapter;
import com.mvp.project_mvp.mvp.bean.TabNewsInfo;
import com.mvp.project_mvp.mvp.presenter.BasePresenter1;
import com.mvp.project_mvp.mvp.presenter.TabNewsPresenterImpl;
import com.mvp.project_mvp.mvp.view.BaseView;
import com.mvp.project_mvp.utils.UIUtils;

import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;

/**
 * by 12406 on 2016/5/14.
 */
public class NewsViewPagerFragment extends BaseFragment implements BaseView.TabNewsView {

    @SuppressWarnings("unused")
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @SuppressWarnings("unused")
    @Bind(R.id.viewPager)
    ViewPager viewPager;

    private List<TabNewsInfo> data;
    private TabNewsAdapter tabNewsAdapter;

    @Override
    protected View initView() {
        return View.inflate(UIUtils.getActivity(), R.layout.fragment_viewpager, null);
    }

    @Override
    protected void initData() {

        BasePresenter1.TabNewsPresenter tabNewsPresenter = new TabNewsPresenterImpl(this);
        tabNewsPresenter.requestNetWork();

        data = new LinkedList<>();
        tabNewsAdapter = new TabNewsAdapter(getChildFragmentManager(), data);
    }

    @Override
    public void setData(List<TabNewsInfo> datas) {
        if (!datas.isEmpty()) {
            data.addAll(datas);
            viewPager.setAdapter(tabNewsAdapter);
            tabLayout.setupWithViewPager(viewPager);
        }
    }

    @Override
    public void netWorkError() {
        Toast(UIUtils.getContext().getResources().getString(R.string.network_error));
    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void showFoot() {

    }

    @Override
    public void hideFoot() {

    }
}
