package com.capso.service;

import com.capso.dto.DirectorDTO;

public interface DirectorService{

	void insertDirector(DirectorDTO director);

	void findAllRecordsOfDirectors();

	void updateDirectorDetailsBasedOnFirstAndLastName(String string, long l, String string2, String string3);

	void getDirectorMovies(String string, String string2);

}
