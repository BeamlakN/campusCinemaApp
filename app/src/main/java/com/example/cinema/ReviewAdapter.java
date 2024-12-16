package com.example.cinema;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ReviewAdapter extends BaseAdapter {

    private Context context;
    private List<Review> reviews;

    public ReviewAdapter(Context context, List<Review> reviews) {
        this.context = context;
        this.reviews = reviews;
    }

    @Override
    public int getCount() {
        return reviews.size();
    }

    @Override
    public Object getItem(int position) {
        return reviews.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.review_item, parent, false);
            holder = new ViewHolder();
            holder.txtReviewerName = convertView.findViewById(R.id.txt_reviewer_name);
            holder.txtReviewText = convertView.findViewById(R.id.txt_review_text);
            holder.txtReviewDate = convertView.findViewById(R.id.txt_review_date);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Review review = reviews.get(position);

        holder.txtReviewerName.setText(review.getReviewerName());
        holder.txtReviewText.setText(review.getReviewText());
        holder.txtReviewDate.setText(review.getReviewDate());

        return convertView;
    }

    static class ViewHolder {
        TextView txtReviewerName;
        TextView txtReviewText;
        TextView txtReviewDate;
    }
}
