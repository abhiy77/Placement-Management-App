package com.hiring.placementmanagement;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.hiring.placementmanagement.com.hiring.placementmanagement.model.News;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter<News> {
    public NewsAdapter(Context context, ArrayList<News> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        News newsUser = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        Log.d("News",newsUser+"");
        if (convertView == null) {
            convertView=LayoutInflater.from(getContext()).inflate(R.layout.news_view,parent,false);
        }

      //  TextView id=convertView.findViewById(R.id.id);
        TextView type = convertView.findViewById(R.id.type);
        TextView url = convertView.findViewById(R.id.url);
        TextView created_at = convertView.findViewById(R.id.created_at);
        TextView company = convertView.findViewById(R.id.company);
        TextView company_url = convertView.findViewById(R.id.company_url);
        TextView location = convertView.findViewById(R.id.location);
        TextView title = convertView.findViewById(R.id.title);
       // TextView description = convertView.findViewById(R.id.description);
        TextView how_to_apply = convertView.findViewById(R.id.how_to_apply);
        // ImageView company_logo = convertView.findViewById(R.id.company_logo);

    //    id.setText(newsUser.getId());
        type.setText(newsUser.getType());
        url.setText(newsUser.getUrl());
        created_at.setText(newsUser.getCreated_at());
        company.setText(newsUser.getCompany());
        company_url.setText(newsUser.getCompany_url());
        location.setText(newsUser.getLocation());
        title.setText(newsUser.getTitle());


//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            description.setText(Html.fromHtml( newsUser.getDescription(), Html.FROM_HTML_MODE_COMPACT));
//        } else {
//            description.setText(Html.fromHtml(newsUser.getDescription()));
//        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            how_to_apply.setText(Html.fromHtml( newsUser.getHow_to_apply(), Html.FROM_HTML_MODE_COMPACT));
        } else {
            how_to_apply.setText(Html.fromHtml(newsUser.getHow_to_apply()));
        }

        // company_logo.setImageIcon(newsUser.);


        return convertView;
    }
}