package com.trivaking.citiesservice.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO {

    private Long idCity;
    private String name;
    private String continent;
    private String country;
    private String state;
    private List<HotelDTO> hotelList;
}
