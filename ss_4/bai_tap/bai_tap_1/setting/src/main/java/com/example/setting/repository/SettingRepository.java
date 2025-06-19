package com.example.setting.repository;

import com.example.setting.entity.SettingForm;
import org.springframework.stereotype.Repository;

@Repository
public class SettingRepository implements ISettingRepository {
    private static SettingForm settingForm;

    static {
        settingForm = new SettingForm();
        settingForm.setLanguage("vi");
        settingForm.setSize(25);
        settingForm.setSpamsFilter(false);
        settingForm.setSignNature("Thor\nKing, Asgard");
    }

    @Override
    public void save(SettingForm from) {
        settingForm = from;
    }

    @Override
    public SettingForm getSetting() {
        return settingForm;
    }
}
