package com.mtt.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;

import android.content.Context;
import android.util.Log;
import android.util.Xml;

import com.mtt.entity.MessageInfo;

public class FileService {
	public static void saveXml(Context context, String fileName, byte[] data) {
		FileOutputStream outputStream = null;
		try {
			outputStream = context.openFileOutput(fileName, 0);
			outputStream.write(data, 0, data.length);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static List<MessageInfo> readXml(Context context, String fileName) {
		FileInputStream inputStream = null;
		List<MessageInfo> messageInfos = null;
		try {
			inputStream = context.openFileInput(fileName);
			XmlPullParser pullParser = Xml.newPullParser();
			pullParser.setInput(inputStream, "UTF-8");
			messageInfos = parseXml(pullParser);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return messageInfos;
	}

	public static List<MessageInfo> parseXml(XmlPullParser pullParser) {
		List<MessageInfo> messages = null;
		MessageInfo message = null;
		try {
			int eventType = pullParser.getEventType();
			while (eventType != XmlPullParser.END_DOCUMENT) {
				switch (eventType) {
				case XmlPullParser.START_DOCUMENT:
					messages = new ArrayList<MessageInfo>();
					break;

				case XmlPullParser.START_TAG:
					String tagName = pullParser.getName();
					if ("message".equals(tagName)) {
						message = new MessageInfo();
						message.setExpressionImage(null);
					} else if ("school".equals(tagName) && message != null) {
						message.setSchool(pullParser.nextText());
					} else if ("msg".equals(tagName) && message != null) {
						message.setMessage(pullParser.nextText());
					} else if ("manufacturer".equals(tagName)
							&& message != null) {
						message.setPhoneInfo(pullParser.nextText());
					} else if ("time".equals(tagName) && message != null) {
						message.setSendTime(pullParser.nextText());
					}
					if ("message".equals(pullParser.getName())) {
						messages.add(message);
					}
					break;
				case XmlPullParser.END_DOCUMENT:
					break;
				}
				eventType = pullParser.next();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return messages;
	}
}
