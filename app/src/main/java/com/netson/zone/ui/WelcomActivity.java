package com.netson.zone.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.netson.commonmodule.bean.User;
import com.netson.commonmodule.utils.PreferensesUtils;
import com.netson.zone.R;

public class WelcomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                User user = PreferensesUtils.getUser();
                if (user != null) {
                    startActivity(new Intent(WelcomActivity.this, MainActivity.class));
                } else {
                    startActivity(new Intent(WelcomActivity.this, LoginActivity.class));
                }
                finish();
            }
        }, 2000);
    }
}
