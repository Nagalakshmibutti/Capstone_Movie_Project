package com.capso.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capso.domain.Director;
import com.capso.domain.Movie;

@Repository
public interface DirectorRepository extends JpaRepository <Director, Integer>{

//	Director findByFirstNameAndLastName1(String string, String string2);
	
	@Query("select d from Director d where d.firstName=?1")
	Optional<Director> findByFirstName(String string2);

	@Query("select d from Director d where d.lastName=?1")
	Optional<Director> findByLastName(String string3);

	@Modifying
	@Query("update Director d set d.address =?1, d.contactNumber=?2 where d.firstName=?3 and d.lastName=?4")
	Integer updateDirectorDetailsBasedOnFirstAndLastName(String string, long l, String string1, String string2);

	@Query("select d from Director d where d.firstName=?1 and d.lastName=?2 ")
	Optional<Director> findByFirstNameAndLastName(String string2, String string3);

	


//	@Modifying
//	@Query("update Director d set d.address=?1, d.contactNumber=?2 where d.firstName=?3")
//	void updateDirectorDetails(String string, long l, String string2);

	
//	Optional<Movie> findByMovieTitle(String title);

}
