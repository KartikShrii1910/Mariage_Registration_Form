package com.example.demo.servicesImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.PersonDetails;
import com.example.demo.repositories.PersonDetailsRepository;
import com.example.demo.services.PersonDetailsService;

@Service
public class PersonDetailsServiceImp implements PersonDetailsService {

	@Autowired
	private PersonDetailsRepository personDetailsRepository;

	@Override
	public PersonDetails savePersonDetail(PersonDetails personDetails) {

		return personDetailsRepository.save(personDetails);
	}

}

//==========================================================================================

//public List<PersonDetails> getAllPersonDetail() {
//	
//	return personDetailsRepository.findAll();
//	
//}
//
//@Override
//public PersonDetails getPersonDetailById(int id) {
//
//	return personDetailsRepository.findById(id).get();
//}
//
//
//@Override
//public PersonDetails updatePersonDetail(PersonDetails personDetails) {
//	
//	return personDetailsRepository.save(personDetails);
//}