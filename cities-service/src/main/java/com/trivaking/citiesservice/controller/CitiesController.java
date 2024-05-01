package com.trivaking.citiesservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trivaking.citiesservice.dto.CityDTO;
import com.trivaking.citiesservice.service.ICityService;

@RestController
@RequestMapping("/cities")
public class CitiesController {

    @Autowired
    private ICityService cityServ;

    @GetMapping("/hotels")
    public CityDTO getCityAndHotels(@RequestParam String name, @RequestParam String country) {

        return cityServ.getCitiesHotels(name, country);

    }
} 
