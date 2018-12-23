package net.bible.vgr.activity;

import android.content.Intent;
import android.os.Bundle;

import net.bible.android.activity.R;
import net.bible.vgr.activity.service.Languages;
import net.bible.vgr.view.ManageBiblesView;
import net.bible.vgr.activity.database.ParametersDBHandler;

import androidx.appcompat.app.AppCompatActivity;

public class StartupActivity extends AppCompatActivity {

    private boolean hasAnyBibleDownloaded;
    ParametersDBHandler dbParameterHandler;
    Languages languages;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //parameters are already define in the class, so passing dummy parameters
        dbParameterHandler = new ParametersDBHandler(this, null, null, 0);

        //If first time initiate Parameters Database and defaults parameters
        if(!dbParameterHandler.isParameterPresent("MenuLanguage")) {
            dbParameterHandler.addParameter("MenuLanguage",languages.getBestDefaultLanguageCode());
            dbParameterHandler.addParameter("MenuRedLetterDay","1");
        }


        setContentView(R.layout.vgr_manage_bibles_view);

        // TODO: must check whether there is any bible downloaded
        if (!hasAnyBibleDownloaded) {
            Intent intent = new Intent(this, ManageBiblesView.class);
            startActivity(intent);
        }
    }

}
