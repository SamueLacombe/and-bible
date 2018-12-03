package net.bible.vgr.view.activity.bibledownloadlist;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.bible.android.activity.R;
import net.bible.vgr.model.BibleDownloadModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BibleDownloadItemAdapter extends RecyclerView.Adapter<BibleDownloadItemHolder> {

    private final List<BibleDownloadModel> bibles;
    private List<BibleDownloadModel> selectedBibles;

    public BibleDownloadItemAdapter(List<BibleDownloadModel> bibles) {
        this.selectedBibles = new ArrayList<>();
        this.bibles = bibles;
    }

    @NonNull
    @Override
    public BibleDownloadItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BibleDownloadItemHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vgr_download_bible_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BibleDownloadItemHolder holder, int position) {
        BibleDownloadModel bible = bibles.get(position);
        holder.title.setText(bible.getTitle());
        holder.downloadSize.setText(bible.getDownloadText());
        holder.capacityRequired.setText(bible.getCapacityText());

        holder.wrapper.setOnClickListener(v -> {
            boolean isSelected = !holder.itemSelectionIndicator.isSelected();
            holder.itemSelectionIndicator.setSelected(isSelected);

            if (isSelected) {
                selectedBibles.add(bible);
            } else {
                selectedBibles.remove(bible);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bibles != null ? bibles.size() : 0;
    }

    public List<BibleDownloadModel> getSelectedBibles() {
        return this.selectedBibles;
    }
}
