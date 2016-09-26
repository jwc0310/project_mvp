package com.mvp.project_mvp.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Html;
import android.view.View;

import com.mvp.project_mvp.R;
import com.mvp.project_mvp.adapter.BaseRecyclerViewAdapter;
import com.mvp.project_mvp.adapter.JokeTextAdapter;
import com.mvp.project_mvp.constant.Constant;
import com.mvp.project_mvp.mvp.bean.JokeTextBean;
import com.mvp.project_mvp.mvp.presenter.BasePresenter1;
import com.mvp.project_mvp.mvp.presenter.JokeTextPresenterImpl;
import com.mvp.project_mvp.mvp.view.BaseView;
import com.mvp.project_mvp.utils.ActivityUtils;
import com.mvp.project_mvp.utils.UIUtils;
import com.mvp.project_mvp.widget.MyRecyclerView;

import java.util.LinkedList;
import java.util.List;

/**
 * by y on 2016/5/30.
 */
public class JokeTextFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener,
        MyRecyclerView.LoadingData, BaseView.JokeTextView, BaseRecyclerViewAdapter.OnItemLongClickListener<JokeTextBean.JokeTextInfo> {

    private MyRecyclerView recyclerView;
    private SwipeRefreshLayout srfLayout;

    private boolean isPrepared;
    private boolean isLoad;

    private BasePresenter1.JokeTextPresenter jokePresenter;
    private JokeTextAdapter adapter;


    @Override
    protected View initView() {
        if (view == null) {
            view = View.inflate(UIUtils.getActivity(), R.layout.fragment_joke_text, null);
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

        jokePresenter = new JokeTextPresenterImpl(this);
        List<JokeTextBean.JokeTextInfo> jokeTextInfo = new LinkedList<>();

        srfLayout.setOnRefreshListener(this);

        adapter = new JokeTextAdapter(jokeTextInfo);
        adapter.setOnLongClickListener(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLoadingData(this);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(Constant.RECYCLERVIEW_LINEAR, LinearLayoutManager.VERTICAL));
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
    public void onRefresh() {
        adapter.removeAll();
        page = 1;
        jokePresenter.requestNetWork(page, isNull);
    }

    @Override
    public void onLoadMore() {
        if (!srfLayout.isRefreshing()) {
            ++page;
            jokePresenter.requestNetWork(page, isNull);
        }
    }

    @Override
    public void setData(List<JokeTextBean.JokeTextInfo> datas) {
        if (datas.isEmpty()) {
            isNull = true;
        } else {
            adapter.addAll(datas);
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

    @Override
    public void hideFoot() {
        adapter.isShowFooter(false);
    }

    @Override
    public void onLongClick(View view, int position, JokeTextBean.JokeTextInfo info) {
        ActivityUtils.share(String.valueOf(Html.fromHtml(info.getText())));
    }
}
