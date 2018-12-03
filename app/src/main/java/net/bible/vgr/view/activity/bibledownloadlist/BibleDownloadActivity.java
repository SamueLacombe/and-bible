package net.bible.vgr.view.activity.bibledownloadlist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import net.bible.android.activity.R;
import net.bible.vgr.model.BibleDownloadModel;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BibleDownloadActivity extends Activity {

    private RecyclerView mRecyclerView;
    private View mDownloadBtn;

    private BibleDownloadItemAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vgr_download_view);

        mRecyclerView = this.findViewById(R.id.vgr_download_list_view);
        mDownloadBtn = this.findViewById(R.id.vgr_download_btn);

        setupRecycler();
    }

    private void setupRecycler() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new BibleDownloadItemAdapter(BibleDownloadModel.getBibleList());
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        mDownloadBtn.setOnClickListener(evt -> {
            for (BibleDownloadModel e : mAdapter.getSelectedBibles()) {
                // download these bibles
                System.out.println(e.getDownloadReference());
            }
        });
    }


}
