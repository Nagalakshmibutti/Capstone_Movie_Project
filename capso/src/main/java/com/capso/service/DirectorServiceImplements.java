package com.capso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capso.domain.Director;
import com.capso.domain.Movie;
import com.capso.dto.DirectorDTO;
import com.capso.repository.DirectorRepository;


@Service("directorService")
@Transactional
public class DirectorServiceImplements  implements DirectorService{
	
	@Autowired
	DirectorRepository directorRepository;
	
	
	@Override
	public void insertDirector(DirectorDTO director) {
		directorRepository.saveAndFlush(DirectorDTO.prepareDirectorEntity(director));
		System.out.println("Record added successfully");
		
	}

	@Override
	public void findAllRecordsOfDirectors() {
		List<Director> directorList = directorRepository.findAll();
		directorList.stream().forEach(System.out::println);
		
		
	}

	@Override
	public void updateDirectorDetailsBasedOnFirstAndLastName(String string, long l, String string2, String string3) {
		// TODO Auto-generated method stub
		
		
		try {
			
			Optional<Director> checkFirstAndLastName = directorRepository.findByFirstNameAndLastName(string2, string3);
			if(checkFirstAndLastName.isEmpty()) {
				throw new Exception("InValid Director User FirstName or LastName"); 
			}else {
				
				directorRepository.updateDirectorDetailsBasedOnFirstAndLastName(string, l, string2, string3);
				
				System.out.println("********************* update ******************");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}	
		
	}

	@Override
	public void getDirectorMovies(String string, String string2) {
//		Director dir = directorRepository.findByFirstNameAndLastName1(string, string2);
//		System.out.println(dir.getMovies());
		
	}


}
