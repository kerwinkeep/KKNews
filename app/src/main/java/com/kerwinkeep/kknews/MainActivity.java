package com.kerwinkeep.kknews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<News> newsList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        NewsAdapter adapter = new NewsAdapter(MainActivity.this, R.layout.news_item, newsList);
        ListView lvNewList = findViewById(R.id.newsList);
        lvNewList.setAdapter(adapter);

    }

    private void initData() {
//        int length;
//        String[] titles = getResources().getStringArray(R.array.title);
//        String[] authors = getResources().getStringArray(R.array.authors);
//        TypedArray images = getResources().obtainTypedArray(R.array.images);
//        length = Math.min(titles.length, authors.length);
//        for (int i = 0; i < length; i++) {
//            News news = new News();
//            news.setmImageId(images.getResourceId(i, 0));
//            news.setmTitle(titles[i]);
//            news.setmAuthor(authors[i]);
//            newsList.add(news);
//        }
    }
}