package com.marcos.pruebaandroidvectoritc.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by markc on 22/01/2018.
 */

public class User {
    @SerializedName("login")
    String name;
    @SerializedName("html_url")
    String url;
    @SerializedName("avatar_url")
    String gravatarUrl;
    String company;
    String location;
    String email;
    String blog;
    String type;
    int followers;
    int following;
    int publicRepos;
    int publicGists;
    @SerializedName("created_at")
    String registrationDate;
    @SerializedName("updated_at")
    String updateDate;
    boolean hireable;
    String bio;


    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getGravatarUrl() {
        return gravatarUrl;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public String getBlog() {
        return blog;
    }

    public String getType() {
        return type;
    }

    public int getFollowers() {
        return followers;
    }

    public int getFollowing() {
        return following;
    }

    public int getPublicRepos() {
        return publicRepos;
    }

    public int getPublicGists() {
        return publicGists;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public boolean isHireable() {
        return hireable;
    }

    public String getBio() {
        return bio;
    }
}
