package com.mtt.mtt_recieve_client;

import java.util.Calendar;
import java.util.List;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mtt.entity.MessageInfo;
import com.mtt.util.FileService;

public class MainActivity extends ActionBarActivity {
	private Button pickButton;
	private Button sendButton;
	// public DBHelper helper;
	private EditText schoolEditTextView;
	private EditText msgEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_send);
		final Calendar birthday = Calendar.getInstance();
		birthday.set(2014, 11, 14, 21, 34);
		// helper=new DBHelper(this);
		schoolEditTextView = (EditText) findViewById(R.id.school);
		msgEditText = (EditText) findViewById(R.id.msg);
		schoolEditTextView.setText("school");
		sendButton = (Button) findViewById(R.id.send);
		pickButton = (Button) findViewById(R.id.pick);
		pickButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new GetMessagesAsyncTask(MainActivity.this).execute("msg.xml");
			}
		});

		sendButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new Thread(new GetMessageThread(MainActivity.this,
						"http://10.0.2.2:8090/mttserver/servlet/MessageAction",
						"msg.xml")).start();

				// if (System.currentTimeMillis() >=birthday.getTimeInMillis())
				// {
				// Intent intent = new Intent(MainActivity.this,
				// RecieveActivity.class);
				// startActivity(intent);
				// }else{
				// Toast.makeText(MainActivity.this, "not time", 1).show();
				// }
			}
		});
	}

	class GetMessagesAsyncTask extends
			AsyncTask<String, Void, List<MessageInfo>> {
		private Context context;

		public GetMessagesAsyncTask(Context context) {
			this.context = context;
		}

		@Override
		protected List<MessageInfo> doInBackground(String... params) {
			// TODO Auto-generated method stub

			return FileService.readXml(context, params[0]);
		}

		@Override
		protected void onPostExecute(List<MessageInfo> result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			schoolEditTextView.setText(result.get(0).getSchool());
			msgEditText.setText(result.get(0).getMessage());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
