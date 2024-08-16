package com.project.chicken_egg.service;

import com.project.chicken_egg.Dto.ChickenRequestDto;
import com.project.chicken_egg.Dto.ChickenResponseDto;
import com.project.chicken_egg.model.Chicken;
import com.project.chicken_egg.repository.ChickenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChickenService {

    @Autowired
    private ChickenRepository repository;

    public ChickenResponseDto addChicken(ChickenRequestDto requestDto) {
        Chicken chicken = new Chicken();
        chicken.setBreed(requestDto.getBreed());
        chicken.setEggsQuantity(requestDto.getEggsQuantity());
        chicken.setPricePerEgg(requestDto.getPricePerEgg());
        chicken.setDate(requestDto.getDate());
        Chicken savedChicken = repository.save(chicken);
        return convertToResponseDto(savedChicken);
    }

    public List<ChickenResponseDto> getAllChickens() {
        return repository.findAll().stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    public ChickenResponseDto getChickenById(Long id) {
        return repository.findById(id)
                .map(this::convertToResponseDto)
                .orElse(null);
    }

    private ChickenResponseDto convertToResponseDto(Chicken chicken) {
        ChickenResponseDto responseDto = new ChickenResponseDto();
        responseDto.setId(chicken.getId());
        responseDto.setBreed(chicken.getBreed());
        responseDto.setEggsQuantity(chicken.getEggsQuantity());
        responseDto.setPricePerEgg(chicken.getPricePerEgg());
        responseDto.setDate(chicken.getDate());
        return responseDto;
    }
}

