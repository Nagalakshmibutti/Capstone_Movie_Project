package com.capso.service;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import com.capso.domain.Movie;
import com.capso.dto.DirectorDTO;
import com.capso.dto.MovieDTO;
import com.capso.repository.*;


public interface MovieService {

	void insertMovie(MovieDTO movie);

	Iterable<Movie> findAllRecords();

	void getMoviesByTitle(String string);

	void UpDateReleaseDateBasedOnTitle(LocalDate of, String string);

	void deleteByTitle(String string);

	void getDirectorListFromTitle(String string);

	void getMovieListFromDirectorName(String string);

	


}
