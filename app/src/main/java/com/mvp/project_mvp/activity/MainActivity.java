package com.mvp.project_mvp.activity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.mvp.project_mvp.R;
import com.mvp.project_mvp.constant.Constant;
import com.mvp.project_mvp.fragment.AboutFragment;
import com.mvp.project_mvp.fragment.ImageNewFragment;
import com.mvp.project_mvp.fragment.ImageViewPagerFragment;
import com.mvp.project_mvp.fragment.JokeMainPagerFragment;
import com.mvp.project_mvp.fragment.NewsViewPagerFragment;
import com.mvp.project_mvp.mvp.presenter.BasePresenter1;
import com.mvp.project_mvp.mvp.presenter.MainViewPresenterImpl;
import com.mvp.project_mvp.mvp.view.BaseView;
import com.mvp.project_mvp.mvp.view.WeatherActivity;
import com.mvp.project_mvp.utils.ActivityCollector;
import com.mvp.project_mvp.utils.UIUtils;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements BaseView.MainView {

    @SuppressWarnings("unused")
    @Bind(R.id.toolBar)
    Toolbar toolBar;
    @SuppressWarnings("unused")
    @Bind(R.id.navigation_view)
    NavigationView navigationView;
    @SuppressWarnings("unused")
    @Bind(R.id.dl_layout)
    DrawerLayout drawerLayout;

    @Bind(R.id.jump)
    Button button;
    private BasePresenter1.MainViewPresenter mainViewPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }


    private void init() {
        toolBar.setTitle(UIUtils.getString(R.string.navigation_news));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WeatherActivity.class));
            }
        });
        setSupportActionBar(toolBar);
        setupDrawerContent(navigationView);
        mainViewPresenter = new MainViewPresenterImpl(this);
        switchNews();
    }


    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        toolBar.setTitle(menuItem.getTitle());
                        mainViewPresenter.switchId(menuItem.getItemId());
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            if (Constant.BACK_EXIT) {
                super.onBackPressed();
                ActivityCollector.removeAllActivity();
                return;
            }
            Constant.BACK_EXIT = true;
            Toast(UIUtils.getString(R.string.exit_app));
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Constant.BACK_EXIT = false;
                }
            }, 2000);
        }
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void switchNews() {
        replaceFragment(new NewsViewPagerFragment());
    }

    @Override
    public void switchImageClassification() {
        replaceFragment(new ImageViewPagerFragment());
    }

    @Override
    public void switchNewImage() {
        replaceFragment(new ImageNewFragment());
    }

    @Override
    public void switchJoke() {
        replaceFragment(new JokeMainPagerFragment());
    }

    @Override
    public void switchAbout() {
        replaceFragment(new AboutFragment());
    }

    void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).commit();
    }

}
