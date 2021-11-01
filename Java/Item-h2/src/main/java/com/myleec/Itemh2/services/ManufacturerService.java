package com.myleec.Itemh2.services;

import com.myleec.Itemh2.models.Manufacturer;
import com.myleec.Itemh2.repositories.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public List<Manufacturer> getAllManufacturers() {
        return manufacturerRepository.findAll();
    }

    public Manufacturer addManufacturer(Manufacturer manufacturer) {
        return manufacturerRepository.saveAndFlush(manufacturer);
    }

    public void deleteManufacturer(Long id) {
        manufacturerRepository.deleteById(id);
    }


}
