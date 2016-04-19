package com.alhikmah.materialdesign;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by ASUS on 4/11/2016.
 */

public class HomeActivity extends AppCompatActivity {


    Sample[] samples = {

            new Sample("RecyclerViewActivity", RecyclerViewActivity.class),
            new Sample("SnackBarActivity", SnackBarActivity.class),
            new Sample("FadingActivityAndNavigationDrawer", FadingActivityAndNavigationDrawer.class),


    };
    Activity activity = this;

    private static class Sample {
        private String mTitle;
        private Class<? extends Activity> mActivityClass;

        private Sample(String title, Class<? extends Activity> activityClass) {
            mTitle = title;
            mActivityClass = activityClass;
        }

        @Override
        public String toString() {
            return mTitle;
        }

        public Class<? extends Activity> getActivityClass() {
            return mActivityClass;
        }
    }

    ListView listView_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Resources res = getResources();

        listView_activity = (ListView) findViewById(R.id.listView_activity);
        listView_activity.setAdapter(new ArrayAdapter<Sample>(this,
                android.R.layout.simple_list_item_1, samples));


        listView_activity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Sample sample = (Sample) listView_activity.getItemAtPosition(position);
                Intent intent = new Intent(activity,
                        sample.getActivityClass());
                startActivity(intent);
            }
        });
    }


}
