package com.example.thuc_hanh_ss7.formatter;

import com.example.thuc_hanh_ss7.entity.Province;
import com.example.thuc_hanh_ss7.service.IProvinceService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class ProvinceFormatter implements Formatter<Province> {
    private IProvinceService provinceService;

    public ProvinceFormatter(IProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @Override
    public Province parse(String text, Locale locale) throws ParseException {
        Optional<Province> provinceOptional = provinceService.findById(Long.parseLong(text));
        return provinceOptional.orElse(null);
    }

    @Override
    public String print(Province object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
