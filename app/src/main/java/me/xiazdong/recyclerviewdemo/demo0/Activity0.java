package me.xiazdong.recyclerviewdemo.demo0;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import me.xiazdong.recyclerviewdemo.R;

/**
 * Created by luo on 2019/8/19.
 */

public class Activity0 extends AppCompatActivity {

    private RecyclerView rv;
    private  List mList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_0);
         rv = (RecyclerView) findViewById(R.id.rv);
         mList = new ArrayList<String>();

         for (int i=0;i<50;i++){
             mList.add("Item=========="+i);
         }

         initView();
    }

    private void initView() {
        //设置多列
        GridLayoutManager layoutManage = new GridLayoutManager(this, 3);
        rv.setLayoutManager(layoutManage);

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,  mList);
        rv.setAdapter(simpleAdapter);


        /**
         * 接口回调
         */
        simpleAdapter.setOnItemListener(new SimpleAdapter.OnItemListener() {
            @Override
            public void onItemClick(int points) {
                Toast.makeText(Activity0.this,"点击的条目=="+points,Toast.LENGTH_SHORT).show();
            }
        });
    }



}
