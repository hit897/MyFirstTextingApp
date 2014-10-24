package ctec.myfirsttextingapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.telephony.SmsManager;
import android.widget.*;

public class SendTextActivity extends Activity
{
	private EditText smsMessageField;
	private EditText smsNumberField;
	private Button sendSMSButton;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_send_text);

		smsMessageField = (EditText) findViewById(R.id.smsContentEditText);
		smsMessageField = (EditText) findViewById(R.id.smsNumberEditText);
		sendSMSButton = (Button) findViewById(R.id.sendSMSButton);

		setupListeners();

	}

	private void setupListeners()
	{
		sendSMSButton.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View currentView)
			{
				try
				{
					String contact = smsNumberField.getText().toString();
					String message = smsMessageField.getText().toString();
					sendSMS(contact, message);

					Toast.makeText(currentView.getContext(), "Message was sent!", Toast.LENGTH_SHORT).show();
				}
				catch (Exception currentException)
				{
					Toast.makeText(currentView.getContext(), "Message Was Not Sent", Toast.LENGTH_LONG).show();
					Toast.makeText(currentView.getContext(), currentException.getMessage(), Toast.LENGTH_LONG).show();
				}

			}
		});
	}

	private void sendSMS(String messageAddress, String messageContent)
	{
		SmsManager mySMSManager = SmsManager.getDefault();
		mySMSManager.sendTextMessage(messageAddress, null, messageContent, null, null);
	}
}