package com.mvp.project_mvp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.mvp.project_mvp.fragment.BaseFragment;
import com.mvp.project_mvp.fragment.JokePicFragment;
import com.mvp.project_mvp.fragment.JokeTextFragment;

import java.util.LinkedList;
import java.util.List;

/**
 * by y on 2016/5/30.
 */
public class TabJokeAdapter extends BaseFragmentPagerAdapter<String> {

    private final List<BaseFragment> fragments;

    public TabJokeAdapter(FragmentManager fm, List<String> mDatas) {
        super(fm, mDatas);
        fragments = new LinkedList<>();
        fragments.add(new JokeTextFragment());
        fragments.add(new JokePicFragment());
    }

    @Override
    protected Fragment getFragmentItem(int position) {
        return fragments.get(position);
    }

    @Override
    protected CharSequence getTitle(String data) {
        return data;
    }

}

