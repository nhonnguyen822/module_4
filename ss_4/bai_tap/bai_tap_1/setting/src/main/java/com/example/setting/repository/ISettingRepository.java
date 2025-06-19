package com.example.setting.repository;

import com.example.setting.entity.SettingForm;

public interface ISettingRepository {
    void save(SettingForm settingForm);

    SettingForm getSetting();
}
