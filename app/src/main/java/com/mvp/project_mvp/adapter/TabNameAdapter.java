package com.mvp.project_mvp.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.mvp.project_mvp.fragment.ImageMainFragment;
import com.mvp.project_mvp.mvp.bean.TabNameInfo;

import java.util.List;

/**
 * by y on 2016/4/28.
 */
public class TabNameAdapter extends BaseFragmentPagerAdapter<TabNameInfo> {


    public TabNameAdapter(FragmentManager fm, List<TabNameInfo> mDatas) {
        super(fm, mDatas);
    }

    @Override
    protected Fragment getFragmentItem(int position) {
        return ImageMainFragment.newInstance(position);
    }

    @Override
    protected CharSequence getTitle(TabNameInfo data) {
        return data.getName();
    }

}
