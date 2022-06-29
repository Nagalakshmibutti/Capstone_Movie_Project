package com.capso.domain;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
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

import com.capso.dto.MovieDTO;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "movie_Id")
	private Integer movieId;
	
	
	private String title;
	
	@Column(name = "date_Release", columnDefinition = "DATE")
	private LocalDate dateRelease;

	@Column(name = "movie_Running_Time")
	private LocalTime movieRunningTime;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinTable(name="movie_directors",
	joinColumns = {@JoinColumn(name="movie_id")},
	inverseJoinColumns = {@JoinColumn(name="director_id")})
	private List<Director> directors = new ArrayList<>();
	

	public List<Director> getDirectors() {
		return directors;
	}

	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
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

	public void setMovieRunningTime(LocalTime localTime) {
		this.movieRunningTime = localTime;
	}

	
	@Override
	public String toString() {
		return "Movie [MovieId =" + movieId + ", tile =" + title +  ",DateRelease =" + dateRelease+ ", movieRunningTime =" + movieRunningTime + "]";
	}



	public Movie(Integer movieId, String title, LocalDate dateRelease, LocalTime movieRunningTime) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.dateRelease = dateRelease;
		this.movieRunningTime = movieRunningTime;
	}


	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public static Movie prepareMovieEntity(Movie MovieDTO)
	{
		Movie MovieEntity = new Movie();
		MovieEntity.setMovieId(MovieDTO.getMovieId());
		MovieEntity.setTitle(MovieDTO.getTitle());
		MovieEntity.setDateRelease(MovieDTO.getDateRelease());
		MovieEntity.setMovieRunningTime(MovieDTO.getMovieRunningTime());
		return MovieEntity;
		
	}
	


}
