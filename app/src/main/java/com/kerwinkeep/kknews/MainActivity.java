package com.kerwinkeep.kknews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {

//    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String TAG = "MainActivity";
    private ListView lvNewsList;
    private NewsAdapter adapter;
    private int page = 1;
//    private int mCurrentColIndex = 0;
//    private final int[] mCols = new int[]{
//            Constants.NEWS_COL5,
//            Constants.NEWS_COL7,
//            Constants.NEWS_COL8,
//            Constants.NEWS_COL10,
//            Constants.NEWS_COL11
//    };

    private okhttp3.Callback callback = new okhttp3.Callback() {
        @Override
        public void onFailure(@NonNull okhttp3.Call call, @NonNull IOException e) {
            Log.d(TAG, "Failed to connect server.");
            e.printStackTrace();
        }

        @Override
        public void onResponse(@NonNull okhttp3.Call call, @NonNull Response response) throws IOException {
            if (response.isSuccessful()) {
                ResponseBody responseBody = response.body();
                final String body;
                if (responseBody != null) {
                    body = responseBody.string();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Gson gson = new Gson();
                            final Type jsonType = new TypeToken<BaseResponse<List<News>>>() {
                            }.getType();
                            BaseResponse<List<News>> newsListResponse = gson.fromJson(body, jsonType);
                            for (News news : newsListResponse.getData()) {
                                adapter.add(news);
                            }
                            adapter.notifyDataSetChanged();
                        }
                    });
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        lvNewsList = findViewById(R.id.newsList);
        lvNewsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "item clicked");
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                News news = adapter.getItem(position);
                intent.putExtra(Constants.NEWS_DETAIL_URL_KEY, news.getmUri());
                startActivity(intent);
            }
        });
    }

    private void initData() {
        List<News> newsList = new ArrayList<>();
        adapter = new NewsAdapter(MainActivity.this, R.layout.news_item, newsList);
        lvNewsList.setAdapter(adapter);
        refreshData(1);
    }

    private void refreshData(final int page) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                NewsRequest requestObj = new NewsRequest();
//                requestObj.setCol(mCols[mCurrentColIndex]);
                requestObj.setNum(Constants.NEWS_NUM);
                requestObj.setPage(page);
                String urlParams = requestObj.toString() + "&rand=5";

                Request request = new Request.Builder()
                        .url(Constants.GENERAL_NEWS_URL + urlParams).get().build();
                try {
                    OkHttpClient client = new OkHttpClient();
                    client.newCall(request).enqueue(callback);
                } catch (NetworkOnMainThreadException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }
}