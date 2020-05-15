package com.lgr.myepicgamestore.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lgr.myepicgamestore.R;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {
	Button loginBtn;
	EditText userName,password;
	TextView register;
	ImageView larg_bg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//隐藏标题栏
		getSupportActionBar().hide();
		//半透明状态栏
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

		setContentView(R.layout.activity_login);

		loginBtn=findViewById(R.id.login_btn);
		userName=findViewById(R.id.userName);
		password=findViewById(R.id.Password);
		register=findViewById(R.id.register);

		larg_bg=findViewById(R.id.larg_bg);

		Animation animation = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.translate_anim);
		larg_bg.startAnimation(animation);


		register.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getApplicationContext(),RegisterActivity.class);
				startActivity(intent);
			}
		});

		loginBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("uname=="+userName.getText());
				System.out.println("password=="+password.getText());
				Boolean boo=emptyCheck(userName,password);
				if (boo){
					System.out.println("通过审核，进行数据库查询");
				}else {
					System.out.println("未通过审核");
				}
			}

			/**
			 * @description: 进行非空验证
			 * @return: true false
			 */
			private Boolean emptyCheck(TextView username,TextView userPwd){
				int userName;
				int password;
				userName=username.getText().length();
				password=userPwd.getText().length();
				if (userName>0 && password>0){
					if (userName<6){
						Toast temp=Toast.makeText(LoginActivity.this,"用户名长度不够",Toast.LENGTH_SHORT);
						temp.show();
						return false;
					}else
					if (password<6){
						Toast temp=Toast.makeText(LoginActivity.this,"密码长度不够",Toast.LENGTH_SHORT);
						temp.show();
						return false;
					}
					return true;
				}else {
					Toast temp=Toast.makeText(LoginActivity.this,"密码或者用户名为空",Toast.LENGTH_SHORT);
					temp.show();
					return false;
				}
			}
		});

	}
}
