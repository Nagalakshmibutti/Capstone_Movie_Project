package com.capso.repository;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capso.domain.*;
import com.capso.dto.MovieDTO;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;
import com.capso.domain.*;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{

	Movie findByTitle(String title);
	
//	@Query(value = "SELECT u FROM Movie u")
//	Iterable<Movie>findAllRecords();
//
//	@Modifying
//	@Query(value = "delete movie b where b.title=?1" , nativeQuery=true)M
//	@Query(value = " DELETE Movie u WHERE u.title = :title")
//	void deleteAllByTitle(@Param ("title") String string);


	@Modifying
	@Query("delete Movie m where m.title=?1")
	Integer deleteByTitle(String title);

	@Query("select m from Movie m where m.title=?1")
	public List<Movie> getMoviesByTitle(String string);
//

//	Optional<Movie> findByTitle(String string);

	@Modifying
	@Query("update Movie m set m.dateRelease =?1 where m.title=?2")
	Integer updateMovieReleaseDateBasedOnTitle(LocalDate of, String string);

	@Query("select m from Movie m where m.title=?1")
	List<Movie> findByTitle1(String string);



	
	
	 
	
	

	
}