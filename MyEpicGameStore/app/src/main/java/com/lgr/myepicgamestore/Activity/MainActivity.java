package com.lgr.myepicgamestore.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.lgr.myepicgamestore.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	ImageView imageView;
	ListView listView;
	@SuppressLint("WrongViewCast")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//隐藏标题栏
		getSupportActionBar().hide();
		//半透明状态栏
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

		setContentView(R.layout.activity_main);

		listView=findViewById(R.id.userStatusList);
		List<String> list = new ArrayList<String>();
		list.add("西安市未央区");
		list.add("西安市未央区");
		list.add("西安市未央区");
		list.add("西安市未央区");
		list.add("西安市未央区");
		list.add("西安市未央区");
		list.add("西安市未央区");
		list.add("西安市未央区");
		list.add("西安市未央区");
		list.add("西安市未央区");
		list.add("西安市未央区");
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
		listView.setAdapter(adapter);


	}
}
