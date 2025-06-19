package com.example.setting.service;

import com.example.setting.entity.SettingForm;
import com.example.setting.repository.ISettingRepository;
import org.springframework.stereotype.Service;

@Service
public class SettingService implements ISettingService {
    private final ISettingRepository settingRepository;

    public SettingService(ISettingRepository settingRepository) {
        this.settingRepository = settingRepository;
    }

    @Override
    public void save(SettingForm settingForm) {
        settingRepository.save(settingForm);
    }

    @Override
    public SettingForm getSetting() {
        return settingRepository.getSetting();
    }
}
