package net.bible.vgr.view.activity.bibledownloadlist;

import android.view.View;
import android.widget.TextView;

import net.bible.android.activity.R;

import androidx.recyclerview.widget.RecyclerView;

public class BibleDownloadItemHolder extends RecyclerView.ViewHolder {

    final TextView title;
    final TextView downloadSize;
    final TextView capacityRequired;
    final View itemSelectionIndicator;
    public View wrapper;

    public BibleDownloadItemHolder(View itemView) {
        super(itemView);
        wrapper = itemView;
        title = itemView.findViewById(R.id.bible_title);
        downloadSize = itemView.findViewById(R.id.bible_download_size);
        capacityRequired = itemView.findViewById(R.id.bible_capacity_required);
        itemSelectionIndicator = itemView.findViewById(R.id.selection_indicator);
    }

}
