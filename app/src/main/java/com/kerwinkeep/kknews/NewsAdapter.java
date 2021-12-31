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

import com.bumptech.glide.Glide;

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
            viewHolder.tvSource = view.findViewById(R.id.source_tv);
            viewHolder.tvTime = view.findViewById(R.id.time_tv);
            viewHolder.ivDelete = view.findViewById(R.id.delete_news_item);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder)convertView.getTag();
        }
        Glide.with(mContext).load(news.getmPicUri()).into(viewHolder.img);
        viewHolder.tvTitle.setText(news.getmTitle());
        viewHolder.tvSource.setText(news.getmSource());
        viewHolder.tvTime.setText(news.getmTime());
        viewHolder.ivDelete.setTag(position);
        return view;
    }

    public class ViewHolder {

        ImageView img;
        TextView tvTitle;
        TextView tvSource;
        TextView tvTime;
        ImageView ivDelete;
    }
}
