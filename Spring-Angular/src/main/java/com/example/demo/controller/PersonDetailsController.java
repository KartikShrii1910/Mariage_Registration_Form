package com.example.demo.controller;


import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entities.PersonDetails;
import com.example.demo.response.Response;
import com.example.demo.services.PersonDetailsService;

@Controller
public class PersonDetailsController {
	
	@Autowired
	private PersonDetailsService personDetailsService;
	
	@GetMapping("/home")
	public String index() {
		return "home";
	}

	@PostMapping("/persondetails/new")
	public ResponseEntity<Response> savePersonDetail(@RequestBody PersonDetails personDetails) throws IOException {
		Response response = new Response();
		
		response.setCode("200");
		response.setMessage("OK");
		response.setObject(personDetails);
		
		personDetailsService.savePersonDetail(personDetails);

		return ResponseEntity.ok().body(response);
	}
	
	
}

//==================================================================================================================




//	@GetMapping("/persondetails")
//	public String listPersonDetail() {
//		List<PersonDetails> personDetails = personDetailsService.getAllPersonDetail();
//		return "persondetails";
//	}
	
//	@GetMapping("/persondetails")
//	public ResponseEntity<List<PersonDetails>> listPersonDetail() {
//		List<PersonDetails> personDetails = personDetailsService.getAllPersonDetail();
//		return ResponseEntity.ok().body(personDetails);
//	}
	
//	    public ResponseEntity<String> saveImage(@RequestParam("file") MultipartFile file) {
//	        try {
//	            imageService.saveImage(file);
//	            return ResponseEntity.ok("Image uploaded successfully!");
//	        } catch (IOException e) {
//	            return ResponseEntity.badRequest().body("Failed to upload image");
//	        }
//	    }

//	@GetMapping("/persondetails/getinfo/{id}")
//	public ResponseEntity<?> getPersonDetailForm(@PathVariable int id) {
//		PersonDetails personDetails = personDetailsService.getPersonDetailById(id);
//
//		if (personDetails != null) {
//			return ResponseEntity.ok().body(personDetails);
//		} else {
//			return ResponseEntity.ok().body("Bank detail not found for ID: " + id);
//		}
//	}

//	@PutMapping("/bankdetails/edit/{id}")
//	public ResponseEntity<Response> updateBankDetail(@PathVariable int id,
//			@RequestBody PersonDetails updatedPersonDetail) {
//		Response response = new Response();
//
//		if (updatedPersonDetail != null && updatedPersonDetail.getId() != id) {
//			// Account number is already associated with another record
//			response.setCode("409"); // Conflict status code
//			response.setMessage("Account number is already associated with another bank detail");
//			response.setObject(null);
//		} else {
//			// Account number is unique or belongs to the current record being updated
//			response.setCode("200");
//			response.setMessage("OK");
//
//			// Get the existing bank detail by ID
//			PersonDetails existingBankDetail = personDetailsService.getPersonDetailById(id);
//
//			// Update the fields with new values
//			existingBankDetail.setName(updatedPersonDetail.getName());
//			existingBankDetail.setAge(updatedPersonDetail.getAge());
//			existingBankDetail.setEmail(updatedPersonDetail.getEmail());
//			existingBankDetail.setMaritalStatus(updatedPersonDetail.getMaritalStatus());
//			existingBankDetail.setArea(updatedPersonDetail.getArea());
//			existingBankDetail.setDistrict(updatedPersonDetail.getDistrict());
//			existingBankDetail.setCity(updatedPersonDetail.getCity());
//			existingBankDetail.setBlock(updatedPersonDetail.getBlock());
//			existingBankDetail.setGram(updatedPersonDetail.getGram());
//			existingBankDetail.setMobileNumber(updatedPersonDetail.getMobileNumber());
//
//			// Save the updated bank detail
//			personDetailsService.updatePersonDetail(existingBankDetail);
//
//			// Set the updated bank detail in the response
//			response.setObject(existingBankDetail);
//		}
//
//		return ResponseEntity.ok().body(response);
//	}


//	@PostMapping("/persondetails/new")
//	public ResponseEntity<Response> savePersonDetail(
//	        @RequestParam("file") MultipartFile file,
//	        @RequestParam("personDetails") String personDetailsJson) {
//	    try {
//	        ObjectMapper objectMapper = new ObjectMapper();
//	        PersonDetails personDetails = objectMapper.readValue(personDetailsJson, PersonDetails.class);
//
//	        // Now you have both the PersonDetails object and the MultipartFile
//
//	        // Save the image
//	        imageService.saveImage(file);
//
//	        // Save the PersonDetails
//	        personDetailsService.savePersonDetail(personDetails);
//
//	        Response response = new Response();
//	        response.setCode("200");
//	        response.setMessage("OK");
//	        response.setObject(personDetails);
//
//	        return ResponseEntity.ok().body(response);
//	    } catch (IOException e) {
//	        return null;
//	    }
//	}

	
