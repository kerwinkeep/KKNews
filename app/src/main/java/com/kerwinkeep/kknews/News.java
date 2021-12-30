package com.kerwinkeep.kknews;

import com.google.gson.annotations.SerializedName;

public class News {

    private String mId;

    private String mTime;

    @SerializedName("title")
    private String mTitle;
    private String mDescription;
    private String mSource;
    private String mPicUri;
    private String mUri;

    public News(String mId, String mTime, String mTitle, String mDescription, String mSource, String mPicUri, String mUri) {
        this.mId = mId;
        this.mTime = mTime;
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mSource = mSource;
        this.mPicUri = mPicUri;
        this.mUri = mUri;
    }

    public News() {
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmSource() {
        return mSource;
    }

    public void setmSource(String mSource) {
        this.mSource = mSource;
    }

    public String getmPicUri() {
        return mPicUri;
    }

    public void setmPicUri(String mPicUri) {
        this.mPicUri = mPicUri;
    }

    public String getmUri() {
        return mUri;
    }

    public void setmUri(String mUri) {
        this.mUri = mUri;
    }
}
