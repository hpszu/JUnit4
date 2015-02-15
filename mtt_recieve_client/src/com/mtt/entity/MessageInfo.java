package com.mtt.entity;

import android.graphics.drawable.Drawable;

public class MessageInfo {

	private String message = "";
	private String school = "";
	private Drawable expressionImage;
	private String phoneInfo;
	private String sendTime;

	public MessageInfo() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public Drawable getExpressionImage() {
		return expressionImage;
	}

	public void setExpressionImage(Drawable expressionImage) {
		this.expressionImage = expressionImage;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getPhoneInfo() {
		return this.phoneInfo;
	}

	public void setPhoneInfo(String phoneInfo) {
		this.phoneInfo = phoneInfo;
	}

}
