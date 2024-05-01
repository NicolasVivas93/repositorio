package com.trivaking.citiesservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class City {

    private Long idCity;
    private String name;
    private String continent;
    private String country;
    private String state;
}
