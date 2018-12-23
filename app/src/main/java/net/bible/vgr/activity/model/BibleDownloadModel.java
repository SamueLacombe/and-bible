package net.bible.vgr.activity.model;

import java.util.ArrayList;
import java.util.List;

public class BibleDownloadModel {

    private String acronym;
    private String language;
    private String downloadReference;
    private Double downloadSize;
    private Double capacityRequired;

    public BibleDownloadModel(String acronym, String language, String downloadReference, Double downloadSize, Double capacityRequired) {
        this.acronym = acronym;
        this.language = language;
        this.downloadReference = downloadReference;
        this.downloadSize = downloadSize;
        this.capacityRequired = capacityRequired;
    }

    public String getTitle() {
        return String.format("%s - %s", acronym, language);
    }

    public String getDownloadText() {
        return formatMeasure(this.downloadSize);
    }

    public String getCapacityText() {
        return formatMeasure(this.capacityRequired);
    }

    private String formatMeasure(Double measure) {
        return String.format("%.2f MB", measure);
    }

    public static List<BibleDownloadModel> getBibleList() {
        List<BibleDownloadModel> books = new ArrayList<>();
        books.add(new BibleDownloadModel("ENG", "English", "linkENGBible", new Double(100.0d), new Double(123.3d)));
        books.add(new BibleDownloadModel("FRN", "Français", "linkFRNBible", new Double(110.0d), new Double(133.3d)));
        books.add(new BibleDownloadModel("POR", "Português", "linkPORBible", new Double(120.0d), new Double(143.3d)));
        return books;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDownloadReference() {
        return downloadReference;
    }

    public void setDownloadReference(String downloadReference) {
        this.downloadReference = downloadReference;
    }

    public Double getDownloadSize() {
        return downloadSize;
    }

    public void setDownloadSize(Double downloadSize) {
        this.downloadSize = downloadSize;
    }

    public Double getCapacityRequired() {
        return capacityRequired;
    }

    public void setCapacityRequired(Double capacityRequired) {
        this.capacityRequired = capacityRequired;
    }
}
