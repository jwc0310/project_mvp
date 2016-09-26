package com.mvp.project_mvp.mvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.mvp.project_mvp.R;
import com.mvp.project_mvp.mvp.bean.WeatherBean;
import com.mvp.project_mvp.mvp.presenter.WeatherPresenter;
import com.mvp.project_mvp.mvp.presenter.WeatherPresenterImpl;
import com.mvp.project_mvp.utils.LoadingUIHelper;
import com.mvp.project_mvp.utils.WeatherIDUtils;

import butterknife.Bind;

/**
 *
 * Created by Administrator on 2016/9/26.
 */
public class WeatherActivity extends AppCompatActivity implements WeatherView {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.textView1)
    TextView textView1;
    @Bind(R.id.textView2)
    TextView textView2;
    @Bind(R.id.textView3)
    TextView textView3;
    @Bind(R.id.textView4)
    TextView textView4;
    @Bind(R.id.textView5)
    TextView textView5;
    @Bind(R.id.textView6)
    TextView textView6;
    @Bind(R.id.textView7)
    TextView textView7;
    @Bind(R.id.textView8)
    TextView textView8;
    @Bind(R.id.textView9)
    TextView textView9;

    private WeatherPresenter weatherPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        toolbar = (Toolbar)findViewById(R.id.toolBar);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);
        textView7 = (TextView) findViewById(R.id.textView7);
        textView8 = (TextView) findViewById(R.id.textView8);
        textView9 = (TextView) findViewById(R.id.textView9);
        setSupportActionBar(toolbar);
        weatherPresenter = new WeatherPresenterImpl(this);
        weatherPresenter.getWeahterData("2", "苏州");

    }


    @Override
    public void showProgress() {
        LoadingUIHelper.showDialogForLoading(this,"获取数据",false);
    }

    @Override
    public void hideProgress() {
        LoadingUIHelper.hideDialogForLoading();
        Toast.makeText(this,"服务器异常", Toast.LENGTH_SHORT).show();
        weatherPresenter.onUnsubscribe();
    }

    @Override
    public void loadWeather(WeatherBean weatherBean) {
        Log.d("weatherBean", "weatherBean==" + weatherBean.toString());
        textView1.setText("城市："+weatherBean.getResult().getToday().getCity());
        textView2.setText("日期："+weatherBean.getResult().getToday().getWeek());
        textView3.setText("今日温度："+weatherBean.getResult().getToday().getTemperature());
        textView4.setText("天气标识：" + WeatherIDUtils.transfer(weatherBean.getResult().getToday().getWeather_id().getFa()));
        textView5.setText("穿衣指数：" + weatherBean.getResult().getToday().getDressing_advice());
        textView6.setText("干燥指数："+weatherBean.getResult().getToday().getDressing_index());
        textView7.setText("紫外线强度："+weatherBean.getResult().getToday().getUv_index());
        textView8.setText("穿衣建议："+weatherBean.getResult().getToday().getDressing_advice());
        textView9.setText("旅游指数："+weatherBean.getResult().getToday().getTravel_index());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消注册
        weatherPresenter.onUnsubscribe();
    }
}
