package com.lambdaschool.webcountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

//READ DATA(GET)

//Controlls rest API calls
@RestController
@RequestMapping("/names")
public class CountryController {

    //endpoints
    //localhost:2019/names/all (Alphabetically)
    @GetMapping(value = "/all",
            produces = {"application/json"})
    public ResponseEntity<?> getAllCountries() {
        WebCountriesApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(WebCountriesApplication.ourCountryList.countryList, HttpStatus.ACCEPTED);
    }

    //localhost:2019/names/start/a (Alphabetically that begin with given letter)
    @GetMapping(value = "/start/{letter}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByLetter(@PathVariable char letter) {
        ArrayList<Country> tempList = new ArrayList<>(WebCountriesApplication.ourCountryList.findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase((letter))));
        tempList.sort((c1, c2) -> c1.getName().compareToIgnoreCase((c2.getName())));
        return new ResponseEntity<>(tempList, HttpStatus.ACCEPTED);
    }

    //localhost:2019/names/size/number
    @GetMapping(value = "/size/{number}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesBySize(@PathVariable int number) {
        ArrayList<Country> tempList = new ArrayList<>(WebCountriesApplication.ourCountryList.findCountries(c -> c.getName().length() >= number));
        tempList.sort((c1, c2) -> c1.getName().compareToIgnoreCase((c2.getName())));
        return new ResponseEntity<>(tempList, HttpStatus.ACCEPTED);
    }
}


