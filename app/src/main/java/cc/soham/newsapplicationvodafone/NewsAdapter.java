package cc.soham.newsapplicationvodafone;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cc.soham.newsapplicationvodafone.objects.NewsObjects;

/**
 * Created by sohammondal on 04/08/16.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    List<NewsObjects> newsObjectsList;

    public NewsAdapter(List<NewsObjects> newsObjectsList) {
        this.newsObjectsList = newsObjectsList;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        if (newsObjectsList == null)
            return;
        NewsObjects currentNewsObjects = newsObjectsList.get(position);
        holder.title.setText(currentNewsObjects.getTitle());
        holder.date.setText(currentNewsObjects.getDate());
        holder.description.setText(currentNewsObjects.getDescription());
        Glide.with(holder.newsImage.getContext()).load(currentNewsObjects.getImageUrl()).into(holder.newsImage);
    }

    @Override
    public int getItemCount() {
        if (newsObjectsList == null)
            return 0;
        return newsObjectsList.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        public ImageView newsImage;
        public TextView title;
        public TextView date;
        public TextView description;

        public NewsViewHolder(View itemView) {
            super(itemView);
            newsImage = (ImageView) itemView.findViewById(R.id.item_name_image);
            title = (TextView) itemView.findViewById(R.id.item_name_title);
            date = (TextView) itemView.findViewById(R.id.item_name_date);
            description = (TextView) itemView.findViewById(R.id.item_name_description);
        }
    }
}