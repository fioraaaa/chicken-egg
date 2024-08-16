package com.project.chicken_egg.Dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ChickenRequestDto {

    private String breed;
    private int eggsQuantity;
    private double pricePerEgg;
    private LocalDate date;
}
