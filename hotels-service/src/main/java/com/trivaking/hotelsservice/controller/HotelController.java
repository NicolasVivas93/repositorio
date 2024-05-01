package com.trivaking.hotelsservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trivaking.hotelsservice.model.Hotel;
import com.trivaking.hotelsservice.service.IHotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private IHotelService hotelServ;

    @GetMapping("/{idCity}")
    public List<Hotel> getHotelsByCityId (@PathVariable Long idCity) {
        return hotelServ.getHotelsByCityId(idCity);

    }
}
