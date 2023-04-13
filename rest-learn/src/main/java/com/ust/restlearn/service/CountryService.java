package com.ust.restlearn.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ust.restlearn.model.Country;
import com.ust.restlearn.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	
	@Transactional
	public List<Country> GetAllCountries() { 
		
		return countryRepository.findAll(); 

     }
	
	 @Transactional 
	 public Country findCountryByCode(String countryCode) 
	 {
	
	  Optional<Country> result = countryRepository.findById(countryCode);  
	  Country country = result.get();
	  return country;
	 }
	 
	 @Transactional 
	 public void addCountry(Country country) 
	 {
		 //System.out.println(country);
	     countryRepository.save(country) ;
	 
	 }
	 
	 @Transactional
	 public void updateCountry(String code,String name)
	 {
		 Country result = countryRepository.findById(code).orElseThrow(null); 
		 result.setName(name);
		 countryRepository.save(result) ;
	 }	 
	 @Transactional
	 public String deleteCountry(String code) 
	 {
	      countryRepository.deleteById(code);
	      return "Deleted";
	  }
	
}
