package com.alhikmah.materialdesign;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/*
    SnackBar Only
*/
public class SendSmsActivity extends AppCompatActivity {

    EditText txtphoneNo;
    EditText editText_roll;
    Spinner spinner;

    int SMS_NUMBER = 16222;
    String make_string = "";
    String EXAM_TYPE = "SSC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);

        //txtphoneNo = (EditText) findViewById(R.id.editText_phone_num);
        editText_roll = (EditText) findViewById(R.id.editText_roll);

        spinner = (Spinner) findViewById(R.id.spinner_division);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle("SendSmsActivity");
//        setSupportActionBar(toolbar);

        Button button = (Button) findViewById(R.id.btnSendSMS);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendSMSMessage();

            }
        });

    }

    protected void sendSMS() {
        Log.i("Send SMS", "");
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);

        smsIntent.setData(Uri.parse("smsto:"));
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address", new String("01234"));
        smsIntent.putExtra("sms_body", "Test ");

        try {
            startActivity(smsIntent);
            finish();
            Log.i("Finished sending SMS...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(SendSmsActivity.this,
                    "SMS faild, please try again later.", Toast.LENGTH_SHORT).show();
        }
    }

    protected void sendSMSMessage() {
        Log.i("Send SMS", "");
        //String phoneNo = txtphoneNo.getText().toString();
        String roll = editText_roll.getText().toString();

        make_string += EXAM_TYPE;

        String division = spinner.getSelectedItem().toString();

        // String upToNCharacters = StringUtils.left(s, n);
        String upToNCharacters = division.substring(0, Math.min(division.length(), 3));

        make_string += " " + upToNCharacters + " " + roll;


        Log.e("upToNCharacters", "" + upToNCharacters);


        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage("" + SMS_NUMBER, null, roll, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS faild, please try again.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }


}
