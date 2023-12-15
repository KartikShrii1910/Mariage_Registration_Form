package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Photo;
import com.example.demo.servicesImp.PhotoServiceImp;

@Controller
public class PhotoController {

	@Autowired
	private PhotoServiceImp photoService;

	@PostMapping("/upload")
	public String image(@RequestParam("image") MultipartFile file) throws IOException, InterruptedException {

		@SuppressWarnings("unused")
		Photo saved = photoService.saveImage(file/* ,image */);
		return "redirect:/home";

	}
}