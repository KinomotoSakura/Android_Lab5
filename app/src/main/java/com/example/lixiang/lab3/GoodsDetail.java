package com.example.lixiang.lab3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import java.util.ArrayList;

import org.greenrobot.eventbus.EventBus;

public class GoodsDetail extends AppCompatActivity {
    private String ShowName;
    private String Price;
    private String info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);

        final Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null) {
            ShowName = intent.getStringExtra("Name");
            Price = intent.getStringExtra("Price");
            info = intent.getStringExtra("Info");
        }

        final String[] s = new String[]{"一键下单","分享商品","不感兴趣","查看更多促销信息"};
        ArrayList ss = new ArrayList<String>();
        for(int i = 0; i < s.length; i++) ss.add(s[i]);
        ListView llv = (ListView)findViewById(R.id.function);
        MoreInfAdapter fun = new MoreInfAdapter(GoodsDetail.this, ss);
        llv.setAdapter(fun);

        final Bundle mBundle = new Bundle();
        ImageView img = (ImageView)findViewById(R.id.pic);
        switch (ShowName){
            case "Enchated Forest":
                img.setImageResource(R.mipmap.enchatedforest);
                mBundle.putInt("Image",R.mipmap.enchatedforest);
                break;
            case "Arla Milk":
                img.setImageResource(R.mipmap.arla);
                mBundle.putInt("Image",R.mipmap.arla);
                break;
            case "Devondale Milk":
                img.setImageResource(R.mipmap.devondale);
                mBundle.putInt("Image",R.mipmap.devondale);
                break;
            case "Kindle Oasis":
                img.setImageResource(R.mipmap.kindle);
                mBundle.putInt("Image",R.mipmap.kindle);
                break;
            case "waitrose 早餐麦片":
                img.setImageResource(R.mipmap.waitrose);
                mBundle.putInt("Image",R.mipmap.waitrose);
                break;
            case "Mcvitie's 饼干":
                img.setImageResource(R.mipmap.mcvitie);
                mBundle.putInt("Image",R.mipmap.mcvitie);
                break;
            case "Ferrero Rocher":
                img.setImageResource(R.mipmap.ferrero);
                mBundle.putInt("Image",R.mipmap.ferrero);
                break;
            case "Maltesers":
                img.setImageResource(R.mipmap.maltesers);
                mBundle.putInt("Image",R.mipmap.maltesers);
                break;
            case "Lindt":
                img.setImageResource(R.mipmap.lindt);
                mBundle.putInt("Image",R.mipmap.lindt);
                break;
            case "Borggreve":
                img.setImageResource(R.mipmap.borggreve);
                mBundle.putInt("Image",R.mipmap.borggreve);
                break;
        }
        mBundle.putString("Name",ShowName);
        mBundle.putString("Price",Price);
        mBundle.putString("Info",info);

        ImageButton bb = (ImageButton) findViewById(R.id.back);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView na = (TextView) findViewById(R.id.nam);
        na.setText(ShowName);
        TextView pr = (TextView) findViewById(R.id.price);
        pr.setText(Price);
        TextView inf = (TextView) findViewById(R.id.cate);
        inf.setText(info);

        final ImageButton Star = (ImageButton) findViewById(R.id.star);
        Star.setTag("0");
        Star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Star.getTag() == "0") {
                    Star.setBackgroundResource(R.mipmap.full_star);
                    Star.setTag("1");
                } else {
                    Star.setBackgroundResource(R.mipmap.empty_star);
                    Star.setTag("0");
                }
            }
        });

        final GoodsInfo shoppingItem = new GoodsInfo(ShowName, info, Price);

        final ImageButton shopcart = (ImageButton) findViewById(R.id.addshopcar);
        shopcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent("dynamic");
                intent1.putExtras(mBundle);
                Toast.makeText(GoodsDetail.this,"商品已添加到购物车",Toast.LENGTH_SHORT).show();
                sendBroadcast(intent1);
                EventBus.getDefault().post(new MessageEvent(shoppingItem));
            }
        });
    }
    protected void onNewIntent(Intent intent){
        super.onNewIntent(intent);
        Bundle extras = intent.getExtras();
        if(extras != null) {
            ShowName = intent.getStringExtra("Name");
            Price = intent.getStringExtra("Price");
            info = intent.getStringExtra("Info");
        }

        final String[] s = new String[]{"一键下单","分享商品","不感兴趣","查看更多促销信息"};
        ArrayList ss = new ArrayList<String>();
        for(int i = 0; i < s.length; i++) ss.add(s[i]);
        ListView llv = (ListView)findViewById(R.id.function);
        MoreInfAdapter fun = new MoreInfAdapter(GoodsDetail.this, ss);
        llv.setAdapter(fun);

        final Bundle mBundle = new Bundle();
        ImageView img = (ImageView)findViewById(R.id.pic);
        switch (ShowName){
            case "Enchated Forest":
                img.setImageResource(R.mipmap.enchatedforest);
                mBundle.putInt("Image",R.mipmap.enchatedforest);
                break;
            case "Arla Milk":
                img.setImageResource(R.mipmap.arla);
                mBundle.putInt("Image",R.mipmap.arla);
                break;
            case "Devondale Milk":
                img.setImageResource(R.mipmap.devondale);
                mBundle.putInt("Image",R.mipmap.devondale);
                break;
            case "Kindle Oasis":
                img.setImageResource(R.mipmap.kindle);
                mBundle.putInt("Image",R.mipmap.kindle);
                break;
            case "waitrose 早餐麦片":
                img.setImageResource(R.mipmap.waitrose);
                mBundle.putInt("Image",R.mipmap.waitrose);
                break;
            case "Mcvitie's 饼干":
                img.setImageResource(R.mipmap.mcvitie);
                mBundle.putInt("Image",R.mipmap.mcvitie);
                break;
            case "Ferrero Rocher":
                img.setImageResource(R.mipmap.ferrero);
                mBundle.putInt("Image",R.mipmap.ferrero);
                break;
            case "Maltesers":
                img.setImageResource(R.mipmap.maltesers);
                mBundle.putInt("Image",R.mipmap.maltesers);
                break;
            case "Lindt":
                img.setImageResource(R.mipmap.lindt);
                mBundle.putInt("Image",R.mipmap.lindt);
                break;
            case "Borggreve":
                img.setImageResource(R.mipmap.borggreve);
                mBundle.putInt("Image",R.mipmap.borggreve);
                break;
        }
        mBundle.putString("Name",ShowName);
        mBundle.putString("Price",Price);
        mBundle.putString("Info",info);

        ImageButton bb = (ImageButton) findViewById(R.id.back);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView na = (TextView) findViewById(R.id.nam);
        na.setText(ShowName);
        TextView pr = (TextView) findViewById(R.id.price);
        pr.setText(Price);
        TextView inf = (TextView) findViewById(R.id.cate);
        inf.setText(info);

        final ImageButton Star = (ImageButton) findViewById(R.id.star);
        Star.setTag("0");
        Star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Star.getTag() == "0") {
                    Star.setBackgroundResource(R.mipmap.full_star);
                    Star.setTag("1");
                } else {
                    Star.setBackgroundResource(R.mipmap.empty_star);
                    Star.setTag("0");
                }
            }
        });

        final GoodsInfo shoppingItem = new GoodsInfo(ShowName, info, Price);

        final ImageButton shopcart = (ImageButton) findViewById(R.id.addshopcar);
        shopcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent("dynamic");
                intent1.putExtras(mBundle);
                Toast.makeText(GoodsDetail.this,"商品已添加到购物车",Toast.LENGTH_SHORT).show();
                sendBroadcast(intent1);
                EventBus.getDefault().post(new MessageEvent(shoppingItem));
            }
        });
    }
}
