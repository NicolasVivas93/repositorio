package com.trivaking.hotelsservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.trivaking.hotelsservice.model.Hotel;

@Service
public class HotelService implements IHotelService {


    List<Hotel> hotelsList = new ArrayList<>();

    @Override
    public List<Hotel> getHotelsByCityId(Long idCity) {
        
        List<Hotel> hotelsByCity = new ArrayList<>();

        this.loadHotels();

        for (Hotel hotel : hotelsList) {
            if (hotel.getIdCity() == idCity) {
                hotelsByCity.add(hotel);
            }
        }

        return hotelsByCity;
    }

    public void loadHotels() {

        hotelsList.add(new Hotel(1L,"Paradise", 5, 1L));
        hotelsList.add(new Hotel(2L, "Sunset View", 4, 2L));
        hotelsList.add(new Hotel(3L, "Ocean Breeze", 3, 3L));
        hotelsList.add(new Hotel(4L, "Mountain Retreat", 4, 1L));
        hotelsList.add(new Hotel(5L, "City Lights Inn", 3, 2L));
        hotelsList.add(new Hotel(6L, "Riverside Lodge", 4, 3L));
        hotelsList.add(new Hotel(7L, "Cozy Cabin Resort", 2, 1L));
        hotelsList.add(new Hotel(8L, "Luxury Haven", 5, 2L));
        hotelsList.add(new Hotel(9L, "Historic Grand Hotel", 4, 3L));
        hotelsList.add(new Hotel(10L, "Tranquil Gardens", 3, 1L));

    }

}
