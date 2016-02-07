package com.flink.flink_app.flink_app.model;

public class ApiModel {
	
	private long mId;
	private String mImageURL;
	private String mText;




	private float progress;

	public ApiModel() {
	}

	public ApiModel(long id, String imageURL, String text, float mprogress) {
		mId = id;
		mImageURL = imageURL;
		mText = text;
	    progress=mprogress;
	}


	public float getProgress() {return progress;}

	public void setProgress(float progress) { this.progress = progress;}
	public long getId() {
		return mId;
	}

	public void setId(long id) {
		mId = id;
	}

	public String getImageURL() {
		return mImageURL;
	}

	public void setImageURL(String imageURL) {
		mImageURL = imageURL;
	}

	public String getText() {
		return mText;
	}

	public void setText(String text) {
		mText = text;
	}

	//public int getIconRes() { 		return mIconRes; 	}

	//public void setIconRes(int iconRes) {		mIconRes = iconRes; 	}

	@Override
	public String toString() {
		return mText;
	}
}
