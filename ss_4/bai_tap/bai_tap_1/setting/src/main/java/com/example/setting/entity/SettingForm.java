package com.example.setting.entity;

public class SettingForm {
    private String language;
    private int size;
    private boolean spamsFilter;
    private String signNature;

    public SettingForm() {
    }

    public SettingForm(String language, int size, boolean spamsFilter, String signNature) {
        this.language = language;
        this.size = size;
        this.spamsFilter = spamsFilter;
        this.signNature = signNature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isSpamsFilter() {
        return spamsFilter;
    }

    public void setSpamsFilter(boolean spamsFilter) {
        this.spamsFilter = spamsFilter;
    }

    public String getSignNature() {
        return signNature;
    }

    public void setSignNature(String signNature) {
        this.signNature = signNature;
    }
}
