package ac.id.unri.appchat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        setTabLayout();


    }

    public void setTabLayout(){
        final ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        new Handler().post(new Runnable() {
            @Override
            public void run() {

        viewPagerAdapter.addFragment(ChatFragment.getInstance(), "Chat");
        viewPagerAdapter.addFragment(CameraFragment.getInstance(), "Camera");
        viewPagerAdapter.addFragment(StoryFragment.getInstance(), "Story");

        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_chat_24);
                tabLayout.getTabAt(1).setIcon(R.drawable.ic_baseline_camera_alt_24);
                tabLayout.getTabAt(2).setIcon(R.drawable.ic_baseline_history_toggle_off_24);
            }
        });
    }



}