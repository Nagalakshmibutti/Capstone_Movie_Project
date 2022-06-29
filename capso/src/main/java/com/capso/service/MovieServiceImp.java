package com.capso.service;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capso.domain.Director;
import com.capso.domain.Movie;
import com.capso.dto.DirectorDTO;
import com.capso.dto.MovieDTO;
import com.capso.repository.DirectorRepository;
import com.capso.repository.MovieRepository;



@Service("movieService")
@Transactional
public class MovieServiceImp  implements MovieService{

	
	
	private static final String LocalDate = null;
	@Autowired
	private MovieRepository repository;
	
	
	
	
	@Override
	public void insertMovie(MovieDTO movie) {
		repository.saveAndFlush(MovieDTO.prepareMovieEntity(movie));
		System.out.println("Record added successfully");
		
	}


//        ************************* Find all records *******************************

	public Iterable<Movie> findAllRecords() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	

//	******************** Listing all movies based on Title *******************	

	public void getMoviesByTitle(String string) {
		
		try {
			List<Movie> movieList = repository.getMoviesByTitle(string);
			if(movieList.isEmpty()) {
				throw new Exception("InValid Movie Title");
			}else {
				movieList.stream().forEach(System.out::println);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void UpDateReleaseDateBasedOnTitle(LocalDate of, String string) {
		

//		try {
//			Optional<Movie> isTitlePresent= repository.findByTitle(string);
//			if(isTitlePresent.isEmpty()) {
//				
//			}else {
//				Integer n = repository.updateMovieReleaseDateBasedOnTitle(of, string);
//				System.out.println("No. of rows affected " + n);
//			}
//		}catch(Exception e){
//			System.out.println(e.getMessage());
//		}
		
	}

	@Override
	public void deleteByTitle(String string) {
		
		try {
			if(repository.findByTitle(string)!=null) {
				repository.deleteByTitle(string);
				
			}else {
				throw new Exception("Movie with the given title is not present ");
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}


	@Override
	public void getDirectorListFromTitle(String string) {

		if(repository.findByTitle(string)!=null) {
			Movie mv = repository.findByTitle(string);
			System.out.println(mv.getDirectors());
		}else {
			System.out.println("Invalid Movie Title");
		}
		
	}


	@Override
	public void getMovieListFromDirectorName(String string) {
		// TODO Auto-generated method stub
		
	}


	



	
	




}
