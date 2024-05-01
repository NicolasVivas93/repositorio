package com.trivaking.hotelsservice.service;

import java.util.List;

import com.trivaking.hotelsservice.model.Hotel;

public interface IHotelService {

    public List<Hotel> getHotelsByCityId (Long idCity);
}
