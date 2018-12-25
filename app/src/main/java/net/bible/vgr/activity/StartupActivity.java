package net.bible.vgr.activity;

import android.content.Intent;
import android.os.Bundle;

import net.bible.android.activity.R;
import net.bible.vgr.activity.service.Parameters;
import net.bible.vgr.view.ManageBiblesView;

import androidx.appcompat.app.AppCompatActivity;

public class StartupActivity extends AppCompatActivity {

    private boolean hasAnyBibleDownloaded;
    Parameters parameters;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Initialised default Parameters
        parameters.initialiseParameters(this);

        setContentView(R.layout.vgr_manage_bibles_view);

        // TODO: must check whether there is any bible downloaded
        if (!hasAnyBibleDownloaded) {
            Intent intent = new Intent(this, ManageBiblesView.class);
            startActivity(intent);
        }
    }

}
