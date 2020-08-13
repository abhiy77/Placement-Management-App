package com.hiring.placementmanagement.com.hiring.placementmanagement.model;

import android.media.Image;
import android.widget.ImageView;

import org.json.JSONException;
import org.json.JSONObject;

public class News
{
    // private int userid; //fields needs to be changed
    private String id;
    private String type;
    private String url;
    private String created_at;
    private String company;
    private String company_url;
    private String location;
    private String title;
    private String description;
    private String how_to_apply;
    //private Image company_logo;
    public News(String id, String type, String url,String created_at,String company,String company_url,String location,String title,String description,
                String how_to_apply) {
        //this.userid = userid;
        this.id = id;
        this.type = type;
        this.url = url;
        this.created_at = created_at;
        this.company = company;
        this.company_url = company_url;
        this.location = location;
        this.title = title;
        this.description = description;
        this.how_to_apply = how_to_apply;
        //this.company_logo = company_logo;
    }

    public News(JSONObject object) {
        try {
            //this.userid= object.getInt("userId");
            this.id = object.getString("id");
            this.type=object.getString("type");
            this.url=object.getString("url");
            this.created_at = object.getString("created_at");
            this.company = object.getString("company");
            this.company_url = object.getString("company_url");
            this.location = object.getString("location");
            this.title = object.getString("title");
            this.description = object.getString("description");
            this.how_to_apply = object.getString("how_to_apply");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany_url() {
        return company_url;
    }

    public void setCompany_url(String company_url) {
        this.company_url = company_url;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHow_to_apply() {
        return how_to_apply;
    }

    public void setHow_to_apply(String how_to_apply) {
        this.how_to_apply = how_to_apply;
    }

    @Override
    public String toString() {
        return "News{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", created_at='" + created_at + '\'' +
                ", company='" + company + '\'' +
                ", company_url='" + company_url + '\'' +
                ", location='" + location + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", how_to_apply='" + how_to_apply + '\'' +
                '}';
    }
}