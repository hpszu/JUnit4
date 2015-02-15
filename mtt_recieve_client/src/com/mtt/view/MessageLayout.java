package com.mtt.view;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mtt.entity.MessageInfo;

public class MessageLayout extends RelativeLayout {

	private ImageView expressionImage = null;
	private TextView messageTextView = null;
	private TextView schoolTextView = null;
	private TextView phoneInfoView = null;

	@SuppressWarnings("deprecation")
	public MessageLayout(Context context, MessageInfo msgInfo) {
		super(context);
		// TODO Auto-generated constructor stub
		this.expressionImage = new ImageView(context);
		this.messageTextView = new TextView(context);
		this.schoolTextView = new TextView(context);

		this.setPadding(30, 10, 0, 0);
		expressionImage.setId(12090);
		expressionImage.setImageDrawable(msgInfo.getExpressionImage());
		LayoutParams layoutParameOne = new LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layoutParameOne.addRule(RelativeLayout.ALIGN_TOP, RelativeLayout.TRUE);
		layoutParameOne.addRule(RelativeLayout.ALIGN_LEFT, RelativeLayout.TRUE);
		expressionImage.setLayoutParams(layoutParameOne);
		this.addView(expressionImage);

		schoolTextView = new TextView(context);
		schoolTextView.setId(12091);
		LayoutParams layoutParameTwo = new LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		layoutParameTwo.addRule(RelativeLayout.RIGHT_OF,
				expressionImage.getId());
		layoutParameTwo.leftMargin = 20;
		schoolTextView.setText(msgInfo.getSchool());
		schoolTextView.setTextSize(22);
		schoolTextView.setLayoutParams(layoutParameTwo);
		this.addView(messageTextView);

		LayoutParams layoutParameThree = new LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		layoutParameThree.addRule(RelativeLayout.RIGHT_OF,
				expressionImage.getId());
		layoutParameThree.addRule(RelativeLayout.BELOW, schoolTextView.getId());
		layoutParameThree.leftMargin = 20;
		messageTextView.setText(msgInfo.getMessage());
		messageTextView.setTextSize(30);
		messageTextView.setLayoutParams(layoutParameThree);
		this.addView(messageTextView);
		
		phoneInfoView = new TextView(context);
		LayoutParams layoutParamFour = new LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		layoutParamFour.addRule(RelativeLayout.RIGHT_OF,
				expressionImage.getId());
		layoutParamFour.leftMargin = 20;
		
		this.addView(phoneInfoView);
		
	}

	public void setExpressionImage(ImageView expressionImage) {
		this.expressionImage = expressionImage;
	}

	public void setMessageTextView(TextView messageTextView) {
		this.messageTextView = messageTextView;
	}

	public void setSchoolTextView(TextView schoolTextView) {
		this.schoolTextView = schoolTextView;
	}

}
