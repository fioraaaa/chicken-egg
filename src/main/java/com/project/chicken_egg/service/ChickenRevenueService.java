package com.project.chicken_egg.service;

import com.project.chicken_egg.model.Chicken;
import com.project.chicken_egg.repository.ChickenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ChickenRevenueService {

    @Autowired
    private ChickenRepository repository;

    public double getTotalRevenue(LocalDate startDate, LocalDate endDate) {
        List<Chicken> chickens = repository.findAll();
        return chickens.stream()
                .filter(chicken -> !chicken.getDate().isBefore(startDate) && !chicken.getDate().isAfter(endDate))
                .mapToDouble(chicken -> chicken.getEggsQuantity() * chicken.getPricePerEgg())
                .sum();
    }
}

