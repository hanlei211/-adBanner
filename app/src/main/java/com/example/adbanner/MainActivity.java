package com.example.adbanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.adbanner.bean.DataBean;
import com.hl.banner.indicator.CircleIndicator;
import com.hl.banner.indicator.RectangleIndicator;
import com.hl.banner.indicator.RoundLinesIndicator;
import com.hl.banner.listener.OnPageChangeListener;
import com.hl.banner.util.BannerUtils;
import com.hl.banner.view.Banner;

public class MainActivity extends AppCompatActivity implements OnPageChangeListener {
    Banner banner;
    RoundLinesIndicator indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         banner = findViewById(R.id.banner) ;
        indicator = findViewById(R.id.indicator);
        ImageAdapter adapter = new ImageAdapter(DataBean.getTestData());
        banner.setAdapter(adapter);
        //设置指示器
        banner.setIndicator(new RectangleIndicator(this));

        //添加切换监听
        banner.addOnPageChangeListener(this);
        //圆角
        banner.setBannerRound(BannerUtils.dp2px(5));
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.e("MAINACTIVITY", "onPageSelected:" + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        banner.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        banner.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        banner.destroy();
    }
}
