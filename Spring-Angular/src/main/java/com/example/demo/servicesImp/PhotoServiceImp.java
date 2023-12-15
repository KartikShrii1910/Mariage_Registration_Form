package com.example.demo.servicesImp;
// PhotoService.java

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Photo;
import com.example.demo.repositories.PhotoRepository;
import com.example.demo.services.PhotoService;


@Service
public class PhotoServiceImp implements PhotoService{

	@Autowired
	private PhotoRepository photoRepository; // Assume you have a repository for handling photos
	
	public Photo saveImage(MultipartFile file) throws IOException {
		Photo image = new Photo();
        image.setFileName(file.getOriginalFilename());
        image.setImageData(file.getBytes());
		
      return  photoRepository.save(image);
    }

}


//=================================================================================================================





//public void savePhoto(MultipartFile file) throws IOException {
//	byte[] imageData = file.getBytes();
//	String fileName = file.getOriginalFilename(); // Get the original file name
//
//	Photo photo = new Photo();
//	photo.setImageData(imageData);
//	photo.setFileName(fileName);
//
//	photoRepository.save(photo);
//}