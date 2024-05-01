package com.trivaking.citiesservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class HotelDTO {

    private Long id;
    private String name;
    private int stars;
    private Long idCity;
}
