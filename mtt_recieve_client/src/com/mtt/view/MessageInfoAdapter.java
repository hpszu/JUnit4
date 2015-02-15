package com.mtt.view;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mtt.entity.MessageInfo;
import com.mtt.mtt_recieve_client.R;

@SuppressLint("InflateParams")
public class MessageInfoAdapter extends BaseAdapter {
	public Context context;
	List<MessageInfo> messageInfo = new ArrayList<MessageInfo>();
	private LayoutInflater msgInflater;

	public MessageInfoAdapter(Context context) {
		this.context = context;
		this.msgInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public void addMessageItem(MessageInfo message) {
		messageInfo.add(message);
	}

	public void setMssageList(List<MessageInfo> messageLsit) {
		this.messageInfo = messageLsit;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return messageInfo.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return messageInfo.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@SuppressWarnings("deprecation")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			convertView = msgInflater.inflate(R.layout.message_item, null);
		}
		MessageInfo message = messageInfo.get(position);
		ImageView icon = (ImageView) convertView.findViewById(R.id.icon);
		TextView school = (TextView) convertView.findViewById(R.id.school);
		TextView msg = (TextView) convertView
				.findViewById(R.id.blessingMessage);
		TextView phone = (TextView) convertView.findViewById(R.id.phoneInfo);
		TextView sendTime = (TextView) convertView
				.findViewById(R.id.timeTextView);

		icon.setBackgroundDrawable(context.getResources().getDrawable(
				R.drawable.ic_launcher));
		school.setText(message.getSchool());
		msg.setText(message.getMessage());
		phone.setText(message.getPhoneInfo());
		sendTime.setText(message.getSendTime());
		return convertView;
	}

}
