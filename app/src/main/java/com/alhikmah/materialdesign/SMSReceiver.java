package com.alhikmah.materialdesign;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SMSReceiver extends BroadcastReceiver {

    private SharedPreferences preferences;


//    @Override
//    public void onReceive(Context context, Intent intent) {


//        Toast.makeText(context, "Got ,,,,,,",Toast.LENGTH_LONG).show();
//
//        String phoneNumbers = PreferenceManager.getDefaultSharedPreferences(
//                context).getString("phone_entries", "");
//        StringTokenizer tokenizer = new StringTokenizer(phoneNumbers, ",");
//        Set<String> phoneEnrties = new HashSet<String>();
//        while (tokenizer.hasMoreTokens()) {
//            phoneEnrties.add(tokenizer.nextToken().trim());
//        }
//        Bundle bundle = intent.getExtras();
//        Object[] pdus = (Object[]) bundle.get("pdus");
//        SmsMessage[] messages = new SmsMessage[pdus.length];
//        for (int i = 0; i < messages.length; i++) {
//            messages[i]= SmsMessage.createFromPdu((byte[]) pdus[i]);
//            String address = messages[i].getOriginatingAddress();
//            if (phoneEnrties.contains(address)) {
//
//                Intent newintent = new Intent(context,HomeActivity .class);
//                newintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                newintent.putExtra("address", address);
//                newintent.putExtra("message",
//                        messages[i].getDisplayMessageBody());
//                context.startActivity(newintent);
//
//            }
//        }
//    }
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Telephony.Sms.Intents.SMS_RECEIVED_ACTION.equals(intent.getAction())) {
            for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                String messageBody = smsMessage.getMessageBody();


                Toast.makeText(context, messageBody, Toast.LENGTH_LONG).show();
            }
        }
    }




}
