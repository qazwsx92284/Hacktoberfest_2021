package com.myleec.Itemh2.controllers;

import com.myleec.Itemh2.models.Manufacturer;
import com.myleec.Itemh2.services.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manufacturer")
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping("/")
    public List<Manufacturer> getAllManufacturer() {
        return manufacturerService.getAllManufacturers();
    }


    @PostMapping("/")
    public Manufacturer addItem(@RequestBody Manufacturer manufacturer) {
        return manufacturerService.addManufacturer(manufacturer);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        manufacturerService.deleteManufacturer(id);
    }
}
