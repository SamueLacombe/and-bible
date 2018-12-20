package net.bible.vgr.view;

import android.content.Intent;
import android.os.Bundle;

import net.bible.android.activity.R;

import androidx.appcompat.app.AppCompatActivity;

public class StartupActivity extends AppCompatActivity {

    private boolean hasAnyBibleDownloaded;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vgr_manage_bibles_view);

        // TODO: must check whether there is any bible downloaded
        if (!hasAnyBibleDownloaded) {
            Intent intent = new Intent(this, ManageBiblesView.class);
            startActivity(intent);
        }
    }

}
