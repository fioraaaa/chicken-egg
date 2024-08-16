package com.project.chicken_egg.controller;

import com.project.chicken_egg.Dto.ChickenRequestDto;
import com.project.chicken_egg.Dto.ChickenResponseDto;
import com.project.chicken_egg.service.ChickenRevenueService;
import com.project.chicken_egg.service.ChickenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/chickens")
public class ChickenController {

    @Autowired
    private ChickenService chickenService;

    @Autowired
    private ChickenRevenueService revenueService;

    @PostMapping
    public ResponseEntity<ChickenResponseDto> addChicken(@RequestBody ChickenRequestDto requestDto) {
        ChickenResponseDto savedChicken = chickenService.addChicken(requestDto);
        return new ResponseEntity<>(savedChicken, HttpStatus.CREATED);
    }

    @GetMapping
    public List<ChickenResponseDto> getAllChickens() {
        return chickenService.getAllChickens();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChickenResponseDto> getChickenById(@PathVariable Long id) {
        ChickenResponseDto chicken = chickenService.getChickenById(id);
        if (chicken != null) {
            return new ResponseEntity<>(chicken, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/revenue")
    public ResponseEntity<Double> getTotalRevenue(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        double revenue = revenueService.getTotalRevenue(startDate, endDate);
        return new ResponseEntity<>(revenue, HttpStatus.OK);
    }
}
