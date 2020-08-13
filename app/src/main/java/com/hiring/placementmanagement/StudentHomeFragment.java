package com.hiring.placementmanagement;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.hiring.placementmanagement.com.hiring.placementmanagement.model.News;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;


public class StudentHomeFragment extends Fragment {

    CarouselView carouselView;
    int[] sampleImages = {R.drawable.carousel_tcs, R.drawable.carousel_google, R.drawable.carousel_infy,R.drawable.carousel_code,R.drawable.carousel_virtusa};
    ListView newsListView;
    NewsAdapter newsAdapter;
    ArrayList<News> users=new ArrayList<>();

    public static final int REQUIRED_POSTS = 5;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
    }


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        RequestQueue rq = Volley.newRequestQueue(getContext());
        JsonArrayRequest jsonarray = new JsonArrayRequest(Request.Method.GET,
                "https://jobs.github.com/positions.json/", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        users = new ArrayList<>(fromJson(response));
                        newsAdapter = new NewsAdapter(getActivity().getApplicationContext(),users);
                        newsListView.setAdapter(newsAdapter);
                        Log.i("NEWS USER",users.get(0).toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("MyApp",error.toString());
            }
        });
        rq.add(jsonarray);


    }

    @Override
    public void onViewCreated(View view ,Bundle savedInstanceState) {

//        Toolbar toolbar = getView().findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        carouselView = getView().findViewById(R.id.carouselView);
        carouselView.setImageListener(imageListener);
        carouselView.setPageCount(sampleImages.length);

        newsListView = getView().findViewById(R.id.listview);


    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

    public static ArrayList<News> fromJson(JSONArray jsonObjects) {
        ArrayList<News> tempUsers = new ArrayList<>();
        for (int i = 0; i < REQUIRED_POSTS; i++) {
            try {
                tempUsers.add(new News(jsonObjects.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return tempUsers;
    }

}
