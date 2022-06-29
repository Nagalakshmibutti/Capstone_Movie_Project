package com.capso.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.capso.domain.*;
import com.capso.dto.DirectorDTO;



@Entity
public class Director {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="director_Id")
	private Integer directorId;
	
	@Column(name= "first_Name", length=100)
	private  String firstName;
	
	@Column(name= "last_Name", length=50)
	private String lastName;
	
	@Column(length = 150)
	private String address;
	
	@Column(name= "contact_Number")
	private Long contactNumber;
	
	@Column(length = 100)
	private String email;


	@ManyToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL,mappedBy="directors")
	private List<Movie> movies = new ArrayList<>();
		
	
	public List<Movie> getMovies() {
		return movies;
	}


	public void setMovies(List<Movie> movies) {
		this.movies = movies;
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
		return "Director [directorId=" + directorId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", contactNumber=" + contactNumber + ", email=" + email + "]";
	}

	public static Director prepareDirectorEntity(Director  DirectorDTO)
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


	public Director(Integer directorId, String firstName, String lastName, String address, Long contactNumber,
			String email) {
		super();
		this.directorId = directorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.contactNumber = contactNumber;
		this.email = email;
	}


	public Director() {
		// TODO Auto-generated constructor stub
	}
}



