package com.lambdaschool.webcountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class CountryPopulationController {

    //localhost:2019/names/population/size/people
    // return the countries that have a population equal to or greater than the given population
    @GetMapping(value = "/population/size/{people}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByPop(@PathVariable long people) {
        ArrayList<Country> tempList = new ArrayList<>(WebCountriesApplication.ourCountryList.findCountries(c -> c.getPopulation() >= people));
        tempList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(tempList, HttpStatus.ACCEPTED);
    }

    //localhost:2019/names/population/min
    // return the country with the smallest population
    @GetMapping(value = "/min", produces = {"application/json"})
    public ResponseEntity<?> getSmallestPop() {
        long counter = Long.MAX_VALUE;
        Country smallest = null;
        for (Country c : WebCountriesApplication.ourCountryList.countryList) {
            if(c.getPopulation() < counter) {
                counter = (long) c.getPopulation();
                smallest = c;
            }
        }
        return new ResponseEntity<>(smallest, HttpStatus.OK);
    }


    //localhost:2019/names/population/max




}



