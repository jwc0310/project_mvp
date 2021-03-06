package com.mvp.project_mvp.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.mvp.project_mvp.R;
import com.mvp.project_mvp.adapter.TabJokeAdapter;
import com.mvp.project_mvp.utils.UIUtils;

import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;

/**
 * by y on 2016/5/30.
 */
public class JokeMainPagerFragment extends BaseFragment {

    @SuppressWarnings("unused")
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @SuppressWarnings("unused")
    @Bind(R.id.viewPager)
    ViewPager viewPager;

    @Override
    protected View initView() {
        return View.inflate(UIUtils.getActivity(), R.layout.fragment_joke_viewpager, null);
    }

    @Override
    protected void initData() {

        List<String> data = new LinkedList<>();
        data.add(UIUtils.getString(R.string.joke_text));
        data.add(UIUtils.getString(R.string.joke_pic));


        TabJokeAdapter adapter = new TabJokeAdapter(getChildFragmentManager(), data);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
