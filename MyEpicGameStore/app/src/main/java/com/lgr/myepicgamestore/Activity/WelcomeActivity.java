package com.lgr.myepicgamestore.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.lgr.myepicgamestore.R;

public class WelcomeActivity extends AppCompatActivity {

	TextView textView;
	ImageView larg_bg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//设置隐藏状态栏
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
//隐藏标题栏
		getSupportActionBar().hide();
//		注意getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
//		getSupportActionBar().hide();
//		需要在
//		setContentView(R.layout.activity_splash);之前执行
		setContentView(R.layout.activity_welcome);

		textView=findViewById(R.id.version);
		textView.setText("v0.0.1");

		larg_bg=findViewById(R.id.larg_bg);

		Animation animation = AnimationUtils.loadAnimation(WelcomeActivity.this, R.anim.translate_anim);
		larg_bg.startAnimation(animation);

		//		创建一个子线程
		Thread welcomeThread=new Thread(){
			@Override
			public void run() {
				try {
					sleep(3000);
					Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
					startActivity(intent);
					finish();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		welcomeThread.start();
	}
}