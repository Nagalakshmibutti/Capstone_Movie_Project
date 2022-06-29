package com.capso;


import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;
import java.util.Scanner;
import java.util.List;

import org.apache.logging.log4j.core.Logger;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.capso.domain.Movie;
import com.capso.dto.DirectorDTO;
import com.capso.dto.MovieDTO;
import com.capso.service.DirectorService;
import com.capso.service.MovieService;



@SpringBootApplication
public class Client implements CommandLineRunner {

//	static Logger logger = Logger.getLogBuilder(Client.class);
	private static final org.jboss.logging.Logger logger = LoggerFactory.logger(Client.class);

	@Autowired
	ApplicationContext context;
	
	@Autowired
	DirectorService directorservice;
	@Autowired
	MovieService service;
	
	private java.time.LocalTime LocalTime;
	private LocalDate LocalDate;

	public static void main(String[] args) {
		SpringApplication.run(Client.class, args);
	}

	public void run(String... args) throws Exception {
		
		
		
		MovieDTO movie1= new MovieDTO(1, "ABC", java.time.LocalDate.of(2022, 01, 01),java.time.LocalTime.of(2, 29, 23) );
		MovieDTO movie2= new MovieDTO(2, "XYZ", java.time.LocalDate.of(2022, 02, 02),LocalTime.of(02, 29, 00));
		MovieDTO movie3= new MovieDTO(3, "PQR", java.time.LocalDate.of(2022, 03, 03),java.time.LocalTime.of(2, 30, 00) );
		MovieDTO movie4= new MovieDTO(4, "MNO", java.time.LocalDate.of(2022, 04, 04),LocalTime.of(02, 31, 00));
		
//		1. invoke service layer method to insert Customer
		service.insertMovie(movie1);
		service.insertMovie(movie2);
		service.insertMovie(movie3);
		service.insertMovie(movie4);

	

		
//    	2. Retrieving all Movie records from Database 
		
		Iterable<Movie> alldata = service.findAllRecords();
		
		System.out.println("Movies List is");
		for (Movie alist : alldata) {
		System.out.println( alist);
		}
		logger.info("ALL RECORDS FETCHED");
		
		
			
//		********* Director Data Base Operations ***********************

		
		
		DirectorDTO director1 = new DirectorDTO(1,"ABC", "XYZ", "abcd", 123456789L, "ABC@gmail.com");
		DirectorDTO director2 = new DirectorDTO(2,"John", "Rebka", "London", 234567891L, "John@gmail.com");
		DirectorDTO director3 = new DirectorDTO(3,"janu", "Ram", "vizag", 345678912L, "janju@gmail.com");
	
//		3. Inserting Records into Director Data Base 
		directorservice.insertDirector(director1);
		directorservice.insertDirector(director2);
		directorservice.insertDirector(director3);
		
		
	
		
		movie1.getDirectors().add(DirectorDTO.prepareDirectorEntity(director1));
		movie2.getDirectors().add(DirectorDTO.prepareDirectorEntity(director2));

		director1.getMovies().add(MovieDTO.prepareMovieEntity(movie1));
		director2.getMovies().add(MovieDTO.prepareMovieEntity(movie2));
		
		
		
//	    4. List movies based on the movie title based on user Input
		
			System.out.println("Enter a title for list out all movies based on title");
			Scanner sc = new Scanner(System.in);
			String movieTitle = sc.nextLine();
			logger.info("Fetching all records of Movie");
			service.getMoviesByTitle(movieTitle);
			

//		 5. Update new release date based on the movie title 
			
			System.out.print("Enter MovieTitle to update release date of movie");
			movieTitle = sc.nextLine();
			service.UpDateReleaseDateBasedOnTitle(java.time.LocalDate.of(2022, 12, 12), movieTitle);
			logger.info("Updating movie relase data based on MovieTitle");

//		6 . Deleting records from Database Based on Title 
				
			System.out.print("Enter MovieTitle to delete a movie");
			movieTitle = sc.nextLine();
			service.deleteByTitle(movieTitle);
			logger.info("Deleting Movie record based on Title");
		
//	    7.  Retrieving all Director records from Database *****************

		directorservice.findAllRecordsOfDirectors();
		
		logger.info("Fetching ALL records of Directors");
			
//      8. Update director details (adress,contact) based on director first and last name 
		
		directorservice.updateDirectorDetailsBasedOnFirstAndLastName("chilakaluripwt", 9999999L , "ABC", "XYZ");
		
		
		logger.info("Updation on Director data on 2 condition is done");
	  
 //		9. Get all Directors from Movie Title
                 
		service.getDirectorListFromTitle("ABC");
		
		logger.info("Fetched all Director names based on Movie Title");
		
     

//		10 . List movies based on director name
//		Display movie based on the director's first and last name, if the director's name is not present, then display exception with the message "Invalid Director name".
		directorservice.getDirectorMovies("janu", "Ram");
	}

}
