package net.bible.vgr.view.managebibles;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import net.bible.android.activity.R;
import net.bible.vgr.model.BibleDownloadModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BibleListItemAdatper extends RecyclerView.Adapter<BibleListItemHolder> {

    private final List<BibleDownloadModel> bibles;
    private List<BibleDownloadModel> selectedBibles;

    public BibleListItemAdatper(List<BibleDownloadModel> bibles) {
        this.selectedBibles = new ArrayList<>();
        this.bibles = bibles;
    }

    @NonNull
    @Override
    public BibleListItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BibleListItemHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vgr_bible_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BibleListItemHolder holder, int position) {
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
