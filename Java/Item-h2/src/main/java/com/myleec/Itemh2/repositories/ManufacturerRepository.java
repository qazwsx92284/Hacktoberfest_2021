package com.myleec.Itemh2.repositories;

import com.myleec.Itemh2.models.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository <Manufacturer, Long> {
}
