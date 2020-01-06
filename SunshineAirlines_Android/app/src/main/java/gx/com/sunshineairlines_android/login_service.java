package gx.com.sunshineairlines_android;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * 引导页
 */
public class login_service extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_service);

        ViewPager viewById = (ViewPager) findViewById(R.id.vp);
        final ArrayList<View> list=new ArrayList<View>();
        LayoutInflater lif = getLayoutInflater();
        list.add(lif.inflate(R.layout.logo01, null)) ;
        list.add(lif.inflate(R.layout.logo02, null)) ;
        list.add(lif.inflate(R.layout.logo03, null)) ;
        viewById.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(View container, int position) {
                ((ViewPager) container).addView(list.get(position));
                return list.get(position);
            }

            @Override
            public void destroyItem(View container, int position, Object object) {
                ((ViewPager) container).removeView(list.get(position));
            }
        });
    }

    public void lSkips(View v) {
//        startActivity(new Intent(login_service.this, LoginActivity.class));
        startActivity(new Intent(login_service.this, MainScreen.class));
        finish();
    }
}
