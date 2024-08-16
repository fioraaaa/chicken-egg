package com.project.chicken_egg.Dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ChickenResponseDto {

    private Long id;
    private String breed;
    private int eggsQuantity;
    private double pricePerEgg;
    private LocalDate date;
}

