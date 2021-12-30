package com.kerwinkeep.kknews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    private List<News> mNewsData;
    private Context mContext;
    private int resourceId;

    public NewsAdapter(@NonNull Context context, int resource, @NonNull List<News> data) {
        super(context, resource, data);
        this.mContext = context;
        this.mNewsData = data;
        this.resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        News news = getItem(position);
        View view;
        ViewHolder viewHolder = new ViewHolder();
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder.img = view.findViewById(R.id.news_image);
            viewHolder.tvTitle = view.findViewById(R.id.title_tv);
            viewHolder.tvAuthor = view.findViewById(R.id.author_tv);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder)convertView.getTag();
        }
//        viewHolder.img.setImageResource();
//        viewHolder.tvTitle.setText(news.getmTitle());
//        viewHolder.tvAuthor.setText(news.getmAuthor());
        return view;
    }

    public class ViewHolder {
        // imgResource  title    author
        ImageView img;
        TextView tvTitle;
        TextView tvAuthor;
    }
}
