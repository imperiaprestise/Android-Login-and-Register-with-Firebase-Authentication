package ac.id.unri.appchat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenn extends AppCompatActivity {

    private int time_loading=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screenn);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent login = new Intent(SplashScreenn.this, LoginScreen.class);
                startActivity(login);
                finish();
            }
        }, time_loading);
    }
}