package com.luoha.u3dpic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn1,btn2;
    List<PicBean> list;
    View view;
    private FancyCoverFlow fancyCoverFlow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.view);
        btn1 = (Button) findViewById(R.id.btn1);
         btn2 = (Button) findViewById(R.id.btn2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        list = new ArrayList<PicBean>();

        list.add(new PicBean("http://img3.duitang.com/uploads/item/201606/04/20160604121431_nBeQd.thumb.700_0.jpeg"));
        list.add(new PicBean("http://cdn.duitang.com/uploads/item/201210/26/20121026205914_VQstV.thumb.600_0.jpeg"));
        list.add(new PicBean("http://img1.3lian.com/2015/a2/239/d/289.jpg"));
        list.add(new PicBean("http://imgsrc.baidu.com/forum/pic/item/52b06d380cd79123a1ae34f2ad345982b3b7809e.jpg"));
        list.add(new PicBean("http://www.bz55.com/uploads/allimg/130223/1-130223093156.jpg"));
        list.add(new PicBean("http://img2.3lian.com/2014/f2/159/d/47.jpg"));
        list.add(new PicBean("http://f1.bj.anqu.com/down/NGU0MQ==/allimg/1209/48-120925142458.jpg"));
        list.add(new PicBean("http://image.tianjimedia.com/uploadImages/2013/235/70U4CMK827G1.jpg"));
        list.add(new PicBean("http://www.1tong.com/uploads/wallpaper/illustration/116-1-1920x1200.jpg"));

        list.add(new PicBean("http://www.bz55.com/uploads/allimg/130428/1-13042P92A1.jpg"));
        list.add(new PicBean("http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1302/20/c0/18252070_1361330479133.jpg"));
        list.add(new PicBean("http://imgsrc.baidu.com/forum/pic/item/e824b899a9014c0858f1f52c0a7b02087af4f475.jpg"));
        list.add(new PicBean("http://img1.3lian.com/2015/a1/114/d/58.jpg"));
        list.add(new PicBean("http://imgsrc.baidu.com/forum/pic/item/ee593d12b31bb0516307a3f3367adab44bede0fc.jpg"));
        list.add(new PicBean("http://pic.yesky.com/uploadImages/2014/302/44/H41YM330O781.jpg"));
        list.add(new PicBean("http://img15.3lian.com/2015/f1/83/d/35.jpg"));
        list.add(new PicBean("http://img5.imgtn.bdimg.com/it/u=3997126892,2025162529&fm=21&gp=0.jpg"));


        this.fancyCoverFlow = (FancyCoverFlow) this.findViewById(R.id.fancyCoverFlow);

        this.fancyCoverFlow.setAdapter(new PicAdapter(list));
        this.fancyCoverFlow.setSpacing(PicAdapter.dip2px(this, 5));
        this.fancyCoverFlow.setActionDistance(FancyCoverFlow.ACTION_DISTANCE_AUTO);
        fancyCoverFlow.setSelection(Integer.MAX_VALUE/2);
        fancyCoverFlow.setCallbackDuringFling(false);
        fancyCoverFlow.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

               int p = position%list.size();

                Toast.makeText(MainActivity.this,"选中"+p,0).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        fancyCoverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int p = position%list.size();
                Toast.makeText(MainActivity.this,"点击"+p,0).show();
            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:


            break;
            case R.id.btn2:
            break;
            default:
                break;
        }

    }
}
