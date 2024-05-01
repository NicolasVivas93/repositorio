package com.trivaking.citiesservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trivaking.citiesservice.dto.CityDTO;
import com.trivaking.citiesservice.model.City;
import com.trivaking.citiesservice.repository.IHotelAPI;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class CityService implements ICityService {

    @Autowired
    private  IHotelAPI hotelApi;

    // Al no usar BD simulamos con una List que contendrá ciudades
    List<City> cities = new ArrayList<>();


    public void loadCities() {
        cities.add(new City(1L, "Buenos Aires", "South America", "Argentina", "Buenos Aires"));
        cities.add(new City(2L, "Oberá", "South America", "Argentina", "Misiones"));
        cities.add(new City(3L, "Mexico City", "North America", "Mexico", "Mexico City"));
        cities.add(new City(4L, "Guadalajara", "North America", "Mexico", "Jalisco"));
        cities.add(new City(5L, "Bogotá", "South America", "Colombia", "Cundinamarca"));
        cities.add(new City(6L, "Medellín", "South America", "Colombia", "Antioquia"));
        cities.add(new City(7L, "Santiago", "South America", "Chile", "Santiago Metropolitan"));
        cities.add(new City(8L, "Valparaíso", "South America", "Chile", "Valparaíso"));
        cities.add(new City(9L, "Asunción", "South America", "Paraguay", "Asunción"));
        cities.add(new City(10L, "Montevideo", "South America", "Uruguay", "Montevideo"));
        cities.add(new City(11L, "Madrid", "Europe", "Spain", "Community of Madrid"));
        cities.add(new City(12L, "Barcelona", "Europe", "Spain", "Catalonia"));
        cities.add(new City(13L, "Seville", "Europe", "Spain", "Andalucia"));
        cities.add(new City(14L, "Monterrey", "North America", "Mexico", "Nuevo León"));
        cities.add(new City(15L, "Valencia", "Europe", "Spain", "Valencian Community"));
    }

    public City findCity(String name, String country) {
        this.loadCities();
        for (City city : cities) {
            if (city.getName().equals(name) && city.getCountry().equals(country)) {
                    return city;
                }            
        }
        return null;
    }

    // name: mismo nombre del servicio
    // fallbackMethod: es el método al que envío en caso que algo no funcione
    @CircuitBreaker(name = "hotels-service", fallbackMethod = "fallbackgetCitiesHotels")
    // Para que reintente
    @Retry(name = "hotels-service")
    @Override
    public CityDTO getCitiesHotels(String name, String country) {
        
        // Buscamos ciudad original
        City city = this.findCity(name, country);

        // Creamos CityDTO
        CityDTO cityDTO = new CityDTO();

        cityDTO.setIdCity(city.getIdCity());
        cityDTO.setName(city.getName());
        cityDTO.setCountry(city.getCountry());
        cityDTO.setContinent(city.getContinent());
        cityDTO.setState(city.getState());

        cityDTO.setHotelList(hotelApi.getHotelsByCity(city.getIdCity()));
        
        //acá llamo a la creación de excepción a ver que pasa
        // Comentar para que el circuito se abra y salga todo OK
        // Descomentar para que el circuito se cierre y mande la exception
        //createException();

        return cityDTO;

    }

    // Método que va a esquivar todo
    // Esto lo podemos manipular como queramos
    public CityDTO fallbackgetCitiesHotels(Throwable throwable) {
        return new CityDTO(9999999L, "Fallido", "Fallido", "Fallido", "Fallido", null);
    }

    //Método para provocar una excepción a ver qué pasa.
    // Comentar para que el circuito se abra y salga todo OK
    // Descomentar para que el circuito se cierre y mande al fallbackMethod
    public void createException () {

        throw new IllegalArgumentException("Prueba Resilience y Circuit Breaker");

    }

}
