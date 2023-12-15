package com.example.demo.entities;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fileName;

    @Lob
    @Column(length = 1048576) // Adjust the length based on your needs
    private byte[] imageData;

	public Photo(String fileName, byte[] imageData) {
		super();
		this.fileName = fileName;
		this.imageData = imageData;
	}

	public Photo() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	@Override
	public String toString() {
		return "Photo [id=" + id + ", fileName=" + fileName + ", imageData=" + Arrays.toString(imageData) + "]";
	}

	
}
