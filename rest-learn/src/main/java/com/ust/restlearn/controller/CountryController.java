package com.ust.restlearn.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.ust.restlearn.model.Country;
import com.ust.restlearn.service.CountryService;


@RestController
public class CountryController {

	@Autowired
	CountryService countryService;		
	
	@GetMapping("/countries/{code}") 
	public Country getCountry(@PathVariable String code) {
		
		Country country= countryService.findCountryByCode(code);	
				
		return country;
	}
	
	@GetMapping("/countries") 
	public List<Country> getAllCountries() {
		
	List<Country> countries= countryService.GetAllCountries();
	//System.out.println("Retrieved All");
		return countries;		
		
	}
	
	@PostMapping("/countries")
	public Country createCountry(@RequestBody Country country) {
		
		countryService.addCountry(country);
				
		return country;		
		
	}
	
	@DeleteMapping("/countries/{code}")
	public String deleteCountry(@PathVariable String code) {
		
		countryService.deleteCountry(code);
		return "Deleted";
			
	}
	
	
	@PutMapping("/countries/{code}") 
	public Country updateCountry(@PathVariable String code,@RequestBody Country country ) {
		
		countryService.updateCountry(code,country.getName()) ;
				
		return country;
	}
}