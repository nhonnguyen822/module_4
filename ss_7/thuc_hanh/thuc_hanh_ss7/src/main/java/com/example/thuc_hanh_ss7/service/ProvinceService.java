package com.example.thuc_hanh_ss7.service;

import com.example.thuc_hanh_ss7.entity.Province;
import com.example.thuc_hanh_ss7.repository.IProvinceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProvinceService implements IProvinceService {
    private final IProvinceRepository provinceRepository;

    public ProvinceService(IProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public Optional<Province> findById(Long id) {
        return provinceRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        provinceRepository.deleteById(id);
    }
}
