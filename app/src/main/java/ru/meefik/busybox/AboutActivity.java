package ru.meefik.busybox;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

/**
 * Created by anton on 19.09.15.
 */
public class AboutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PrefStore.setLocale(this);
        super.onCreate(savedInstanceState);
        getActionBar().setTitle(getString(R.string.title_activity_about));
        setContentView(R.layout.activity_about);

        TextView versionView = (TextView) findViewById(R.id.versionView);
        versionView.setText(getString(R.string.app_version,
                PrefStore.getVersion(getApplicationContext())));

        // enable context clickable
        TextView aboutView = (TextView) findViewById(R.id.aboutTextView);
        aboutView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public void setTheme(int resid) {
        super.setTheme(PrefStore.getTheme(this));
    }

}
