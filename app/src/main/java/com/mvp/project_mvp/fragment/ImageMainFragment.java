package com.mvp.project_mvp.fragment;


import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.mvp.project_mvp.R;
import com.mvp.project_mvp.adapter.BaseRecyclerViewAdapter;
import com.mvp.project_mvp.adapter.ImageListAdapter;
import com.mvp.project_mvp.constant.Constant;
import com.mvp.project_mvp.mvp.bean.ImageListInfo;
import com.mvp.project_mvp.mvp.presenter.BasePresenter;
import com.mvp.project_mvp.mvp.presenter.ImageListPresenterImpl;
import com.mvp.project_mvp.mvp.view.BaseView;
import com.mvp.project_mvp.utils.UIUtils;
import com.mvp.project_mvp.widget.MyRecyclerView;

import java.util.LinkedList;
import java.util.List;

/**
 * by y on 2016/4/28.
 */
public class ImageMainFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener,
        MyRecyclerView.LoadingData, BaseRecyclerViewAdapter.OnItemClickListener<ImageListInfo>, BaseView.ImageListView {

    private MyRecyclerView recyclerView;
    private SwipeRefreshLayout srfLayout;

    private boolean isPrepared;
    private boolean isLoad;
    private ImageListAdapter adapter;
    private BasePresenter.ImageListPresenter imageListPresenter;

    public static ImageMainFragment newInstance(int index) {
        Bundle bundle = new Bundle();
        ImageMainFragment fragment = new ImageMainFragment();
        bundle.putInt(FRAGMENT_INDEX, index);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    protected View initView() {
        if (view == null) {
            view = View.inflate(UIUtils.getActivity(), R.layout.fragment_main, null);
            recyclerView = (MyRecyclerView) view.findViewById(R.id.recyclerView);
            srfLayout = (SwipeRefreshLayout) view.findViewById(R.id.srf_layout);
            isPrepared = true;
        }
        return view;
    }

    @Override
    protected void initData() {

        if (!isPrepared || !isVisible || isLoad) {
            return;
        }

        imageListPresenter = new ImageListPresenterImpl(this);

        LinkedList<ImageListInfo> list = new LinkedList<>();

        srfLayout.setOnRefreshListener(this);

        adapter = new ImageListAdapter(list);
        adapter.setOnItemClickListener(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLoadingData(this);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(Constant.RECYCLERVIEW_GRIDVIEW, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);

        srfLayout.post(new Runnable() {
            @Override
            public void run() {
                onRefresh();
            }
        });
        isLoad = true;
    }


    @Override
    public void setData(List<ImageListInfo> t) {
        if (t.isEmpty()) {
            isNull = true;
        } else {
            adapter.addAll(t);
        }
    }


    @Override
    public void onRefresh() {
        page = 1;
        adapter.removeAll();
        imageListPresenter.requestNetWork(index + 1, page, isNull);
    }

    @Override
    public void onLoadMore() {
        if (!srfLayout.isRefreshing()) {
            ++page;
            imageListPresenter.requestNetWork(index + 1, page, isNull);
        }
    }


    @Override
    public void netWorkError() {
        Toast(UIUtils.getString(R.string.network_error));
    }

    @Override
    public void showProgress() {
        if (!srfLayout.isRefreshing()) {
            srfLayout.setRefreshing(true);
        }
    }

    @Override
    public void hideProgress() {
        if (srfLayout.isRefreshing()) {
            srfLayout.setRefreshing(false);
        }
    }

    @Override
    public void showFoot() {
        adapter.isShowFooter(true);
    }

    public void hideFoot() {
        adapter.isShowFooter(false);
    }

    @Override
    public void onItemClick(View view, int position, ImageListInfo info) {
        imageListPresenter.onClick(info);
    }

}
