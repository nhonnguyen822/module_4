package com.example.setting.controller;

import com.example.setting.entity.SettingForm;
import com.example.setting.service.ISettingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SettingFormController {
    private final ISettingService settingService;

    public SettingFormController(ISettingService settingService) {
        this.settingService = settingService;
    }

    @ModelAttribute("pageSizes")
    public List<Integer> listPageSize() {
        return Arrays.asList(5, 10, 15, 25, 50, 100);
    }

    @ModelAttribute("languages")
    public Map<String, String> getLanguages() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("vn", "Vietnamese");
        map.put("jv", "Japanese");
        map.put("chi", "Chinese");
        map.put("en", "English");
        return map;
    }

    @GetMapping("home")
    public String showHome() {
        return "home";
    }

    @GetMapping("setting")
    public String showSettingFrom(Model model) {
        SettingForm settingForm = settingService.getSetting();
        model.addAttribute("settingForm", settingForm);
        return "setting";
    }

    @PostMapping("setting")
    public String SettingFrom(@ModelAttribute SettingForm settingForm) {
        settingService.save(settingForm);
        return "redirect:home";
    }
}
