package com.example.demo.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Photo;

public interface PhotoService {
	public Photo saveImage(MultipartFile file) throws IOException ;

}
