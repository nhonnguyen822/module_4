package com.example.setting.service;

import com.example.setting.entity.SettingForm;

public interface ISettingService {
    void save(SettingForm settingForm);

    SettingForm getSetting();
}
