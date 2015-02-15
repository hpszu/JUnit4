package com.mtt.mtt_recieve_client;

import android.content.Context;

import com.mtt.util.FileService;
import com.mtt.util.HttpUtils;

public class GetMessageThread implements Runnable {
	private String fileURL;
	private Context context;
	private String fileName;

	public GetMessageThread(Context context, String url, String fileName) {
		// TODO Auto-generated constructor stub
		this.fileURL = url;
		this.context = context;
		this.fileName = fileName;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String xmlString = HttpUtils.getMessageByUrl(fileURL);
		FileService.saveXml(context, fileName, xmlString.getBytes());
	}

}
