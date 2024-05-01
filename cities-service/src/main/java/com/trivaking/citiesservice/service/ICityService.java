package com.trivaking.citiesservice.service;

import com.trivaking.citiesservice.dto.CityDTO;

public interface ICityService {
    public CityDTO getCitiesHotels(String name, String country);
}
