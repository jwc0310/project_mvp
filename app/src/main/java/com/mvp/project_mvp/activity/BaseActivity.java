package com.mvp.project_mvp.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.mvp.project_mvp.utils.ActivityCollector;
import com.mvp.project_mvp.utils.LogUtils;
import com.mvp.project_mvp.utils.RxUtils;

import butterknife.ButterKnife;

/**
 * by y on 2016/4/28.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private static Context context;
    private static Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        activity = this;
        setContentView(getLayoutId());
        LogUtils.i("BaseActivity", getClass().getSimpleName());
        ButterKnife.bind(this);
        ActivityCollector.addActivity(this);
    }

    void Toast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_LONG).show();
    }

    public static Context getContext() {
        return context;
    }

    public static Activity getActivity() {
        return activity;
    }

    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxUtils.unsubscribe();
    }
}
