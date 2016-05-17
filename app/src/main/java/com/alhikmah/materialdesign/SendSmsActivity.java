package com.alhikmah.materialdesign;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

/*
    SnackBar Only
*/
public class SendSmsActivity extends AppCompatActivity {

    EditText txtphoneNo;
    EditText editText_roll;
    Spinner spinner;
    TextView textView_result;
    private ListView mListView;
    int SMS_NUMBER = 16222;
    String make_string = "";
    String EXAM_TYPE = "SSC";
    private ChatMessageAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);

        //txtphoneNo = (EditText) findViewById(R.id.editText_phone_num);
        editText_roll = (EditText) findViewById(R.id.editText_roll);
        //textView_result = (TextView) findViewById(R.id.textView_result);

        spinner = (Spinner) findViewById(R.id.spinner_division);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle("SendSmsActivity");
//        setSupportActionBar(toolbar);

        mListView = (ListView) findViewById(R.id.listView);
        mAdapter = new ChatMessageAdapter(this, new ArrayList<ChatMessage>());
        mListView.setAdapter(mAdapter);

        Button button = (Button) findViewById(R.id.btnSendSMS);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendSMSMessage();

            }
        });

        getInboxSMSForIndividual();
        getSentSMSForIndividual();
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

    // get all SMS
    private void getSMSDetails() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("*********SMS History*************** :");
        Uri uri = Uri.parse("content://sms");
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);

        if (cursor.moveToFirst()) {
            for (int i = 0; i < cursor.getCount(); i++) {
                String body = cursor.getString(cursor.getColumnIndexOrThrow("body"))
                        .toString();
                String number = cursor.getString(cursor.getColumnIndexOrThrow("address"))
                        .toString();
                String date = cursor.getString(cursor.getColumnIndexOrThrow("date"))
                        .toString();
                Date smsDayTime = new Date(Long.valueOf(date));
                String type = cursor.getString(cursor.getColumnIndexOrThrow("type"))
                        .toString();
                String typeOfSMS = null;
                switch (Integer.parseInt(type)) {
                    case 1:
                        typeOfSMS = "INBOX";
                        break;

                    case 2:
                        typeOfSMS = "SENT";
                        break;

                    case 3:
                        typeOfSMS = "DRAFT";
                        break;
                }

                stringBuffer.append("\nPhone Number:--- " + number + " \nMessage Type:--- "
                        + typeOfSMS + " \nMessage Date:--- " + smsDayTime
                        + " \nMessage Body:--- " + body);
                stringBuffer.append("\n----------------------------------");
                cursor.moveToNext();
            }
            // just off
           // textView_result.setText(stringBuffer);
        }
        cursor.close();
    }

    private void sendMessage(String message) {
        ChatMessage chatMessage = new ChatMessage(message, true, false);
        mAdapter.add(chatMessage);

        // this is for other person message
        //mimicOtherMessage(message);
    }

    private void mimicOtherMessage(String message) {
        ChatMessage chatMessage = new ChatMessage(message, false, false);
        mAdapter.add(chatMessage);
    }

    private void sendMessage() {
        ChatMessage chatMessage = new ChatMessage(null, true, true);
        mAdapter.add(chatMessage);

        mimicOtherMessage();
    }

    private void mimicOtherMessage() {
        ChatMessage chatMessage = new ChatMessage(null, false, true);
        mAdapter.add(chatMessage);
    }

    private void getInboxSMSForIndividual() {
    //20141
        StringBuilder smsBuilder = new StringBuilder();
        final String SMS_URI_INBOX = "content://sms/inbox";
        final String SMS_URI_ALL = "content://sms/";
        try {
            Uri uri = Uri.parse(SMS_URI_INBOX);
            String[] projection = new String[]{"_id", "address", "person", "body", "date", "type"};
            Cursor cur = getContentResolver().query(uri, projection, "address='+8801723623393'", null, "date desc");
            if (cur.moveToFirst()) {
                int index_Address = cur.getColumnIndex("address");
                int index_Person = cur.getColumnIndex("person");
                int index_Body = cur.getColumnIndex("body");
                int index_Date = cur.getColumnIndex("date");
                int index_Type = cur.getColumnIndex("type");
                do {
                    String strAddress = cur.getString(index_Address);
                    int intPerson = cur.getInt(index_Person);
                    String strbody = cur.getString(index_Body);
                    long longDate = cur.getLong(index_Date);
                    int int_Type = cur.getInt(index_Type);

                   // smsBuilder.append("[ ");
                   // smsBuilder.append(strAddress + ", ");
                   // smsBuilder.append(intPerson + ", ");
                    smsBuilder.append(strbody + ", ");
                    //smsBuilder.append(longDate + ", ");
                    //smsBuilder.append(int_Type);
                   // smsBuilder.append(" ]\n\n");

                    // shihab code
                    mimicOtherMessage(""+smsBuilder);
                    smsBuilder.setLength(0);

                } while (cur.moveToNext());

                if (!cur.isClosed()) {
                    cur.close();
                    cur = null;
                }
            } else {
                smsBuilder.append("no result!");
            } // end if

            //textView_result.setText(smsBuilder);

        } catch (SQLiteException ex) {
            Log.d("SQLiteException", ex.getMessage());
        }

    }

    private void getSentSMSForIndividual() {

        StringBuilder smsBuilder = new StringBuilder();
       // final String SMS_URI_INBOX = "content://sms/";
        final String SMS_URI_ALL = "content://sms/sent";
        try {
            Uri uri = Uri.parse(SMS_URI_ALL);
            String[] projection = new String[]{"_id", "address", "person", "body", "date", "type"};
            Cursor cur = getContentResolver().query(uri, projection, "address='+8801723623393'", null, "date desc");
            if (cur.moveToFirst()) {
                int index_Address = cur.getColumnIndex("address");
                int index_Person = cur.getColumnIndex("person");
                int index_Body = cur.getColumnIndex("body");
                int index_Date = cur.getColumnIndex("date");
                int index_Type = cur.getColumnIndex("type");
                do {
                    String strAddress = cur.getString(index_Address);
                    int intPerson = cur.getInt(index_Person);
                    String strbody = cur.getString(index_Body);
                    long longDate = cur.getLong(index_Date);
                    int int_Type = cur.getInt(index_Type);

                    // smsBuilder.append("[ ");
                    // smsBuilder.append(strAddress + ", ");
                    // smsBuilder.append(intPerson + ", ");
                    smsBuilder.append(strbody + ", ");
                    //smsBuilder.append(longDate + ", ");
                    //smsBuilder.append(int_Type);
                    // smsBuilder.append(" ]\n\n");

                    // shihab code
                    sendMessage(""+smsBuilder);
                    smsBuilder.setLength(0);

                } while (cur.moveToNext());

                if (!cur.isClosed()) {
                    cur.close();
                    cur = null;
                }
            } else {
                smsBuilder.append("no result!");
            } // end if

            //textView_result.setText(smsBuilder);

        } catch (SQLiteException ex) {
            Log.d("SQLiteException", ex.getMessage());
        }

    }


}
