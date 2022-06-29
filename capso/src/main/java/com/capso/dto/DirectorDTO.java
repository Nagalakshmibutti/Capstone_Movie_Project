package com.capso.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;

import com.capso.domain.Director;
import com.capso.domain.Movie;

public class DirectorDTO {
	
	
	private Integer directorId;
	
	private  String firstName;
	
	private String lastName;

	private String address;
	
	private Long contactNumber;
	
	private String email;

	private List<Movie> movies = new ArrayList<>();
	
	public List<Movie> getMovies() {
		return movies;
	}


	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}


	

	public DirectorDTO(Integer directorId, String firstName, String lastName, String address, Long contactNumber,
			String email) {
		super();
		this.directorId = directorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.contactNumber = contactNumber;
		this.email = email;
	}
	

	public Integer getDirectorId() {
		return directorId;
	}

	public void setDirectorId(Integer directorId) {
		this.directorId = directorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "DirectorDTO [directorId=" + directorId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", contactNumber=" + contactNumber + ", email=" + email + "]";
	}
	

	public static Director prepareDirectorEntity(DirectorDTO DirectorDTO)
	{
		Director DirectorEntity = new Director();
		DirectorEntity.setDirectorId(DirectorDTO.getDirectorId());
		DirectorEntity.setFirstName(DirectorDTO.getFirstName());
		DirectorEntity.setLastName(DirectorDTO.getLastName());
		DirectorEntity.setAddress(DirectorDTO.getAddress());
		DirectorEntity.setContactNumber(DirectorDTO.getContactNumber());
		DirectorEntity.setEmail(DirectorDTO.getEmail());
		return DirectorEntity;
		
	}
	
	
}
