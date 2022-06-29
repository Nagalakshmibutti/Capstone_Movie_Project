package com.capso.dto;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;


import org.springframework.data.jpa.repository.Temporal;

import com.capso.domain.*;




public class MovieDTO {
	
	
	private int movieId;
	private String title;
	
	
	private LocalDate dateRelease;

	private LocalTime movieRunningTime;

	private List<Director> directors = new ArrayList<>();
	

	public MovieDTO(int movieId, String title, LocalDate dateRelease, LocalTime movieRunningTime) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.dateRelease = dateRelease;
		this.movieRunningTime = movieRunningTime;
	}


	public List<Director> getDirectors() {
		return directors;
	}

	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}
	
	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDateRelease() {
		return dateRelease;
	}

	public void setDateRelease(LocalDate dateRelease) {
		this.dateRelease = dateRelease;
	}

	public LocalTime getMovieRunningTime() {
		return movieRunningTime;
	}

	public void setMovieRunningTime(LocalTime movieRunningTime) {
		this.movieRunningTime = movieRunningTime;
	}

	@Override
	public String toString() {
		return "MovieDTO [movieId=" + movieId + ", title=" + title + ", dateRelease=" + dateRelease
				+ ", movieRunningTime=" + movieRunningTime + "]";
	}




	
	public static Movie prepareMovieEntity(MovieDTO movie) {
		// TODO Auto-generated method stub
		Movie mvDTO = new Movie();
		mvDTO.setMovieId(movie.getMovieId());
		mvDTO.setTitle(movie.getTitle());
		mvDTO.setDateRelease(movie.getDateRelease());
		mvDTO.setMovieRunningTime(movie.getMovieRunningTime());
		return mvDTO;
	}
	
	
}
