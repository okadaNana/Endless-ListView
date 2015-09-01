package com.owen.endlesslistview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.owen.endlesslistview.adapter.MyAdapter;
import com.owen.endlesslistview.utils.EndlessScrollListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private MyAdapter mAdapter;
    private List<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        mListView = (ListView) findViewById(R.id.activity_main_endless_listview);
        mAdapter = new MyAdapter(this, mData);
        mListView.setAdapter(mAdapter);

        mListView.setOnScrollListener(new EndlessScrollListener(2) {

            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                List<String> nextPageData = new ArrayList<>();
                String newData = "page=[" + page + "]," + new Date().toString();
                nextPageData.add(newData);

                Message msg = mHandler.obtainMessage(123, nextPageData);
                mHandler.sendMessageDelayed(msg, 2000);
            }
        });
    }

    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == 123) {
                mAdapter.setData((List<String>) msg.obj);
            }
            return false;
        }
    });

    private void initData() {
        mData = new ArrayList<>();

        mData.add("alpha");
        mData.add("bravo");
        mData.add("charlie");
        mData.add("delta");
        mData.add("echo");
        mData.add("fox-trot");
        mData.add("golf");
        mData.add("hotel");
        mData.add("india");
        mData.add("juliette");
        mData.add("kilo");
        mData.add("lima");
        mData.add("mike");
        mData.add("november");
        mData.add("oscar");
        mData.add("papa");
        mData.add("quebec");
        mData.add("roméo");
        mData.add("sierra");
        mData.add("tango");
        mData.add("uniforme");
        mData.add("victor");
        mData.add("whiskey");
        mData.add("X-ray");
        mData.add("yankee");
        mData.add("zoulou");
    }

}
