package com.trivaking.citiesservice.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.trivaking.citiesservice.dto.HotelDTO;

@FeignClient(name = "hotels-service")
public interface IHotelAPI {

    @GetMapping("/hotels/{idCity}")
    public List<HotelDTO> getHotelsByCity(@PathVariable Long idCity);
}
