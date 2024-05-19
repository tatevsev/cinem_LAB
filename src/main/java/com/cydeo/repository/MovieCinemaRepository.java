package com.cydeo.repository;

import com.cydeo.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id

    Optional <MovieCinema> findById(Long id);//use Optional to avoid potential null pointer exception

    //Write a derived query to count all movie cinemas with a specific cinema id

    Integer countAllByCinemaId(Long cinemaId);


    //Write a derived query to count all movie cinemas with a specific movie id

     Integer countAllByMovieId(Long movieId);

    //Write a derived query to list all movie cinemas with higher than a specific date

    List<MovieCinema> findByDateTimeAfter(LocalDateTime dateTime);

    //Write a derived query to find the top 3 expensive movies

    List <MovieCinema> findFirst3ByOrderByMoviePriceDesc();

    //Write a derived query to list all movie cinemas that contain a specific movie name

    List<MovieCinema> findAllByMovie_NameContaining(String movieName);

    //Write a derived query to list all movie cinemas in a specific location name

   List<MovieCinema> findAllByCinema_Location_Name(String name);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date

    @Query("SELECT mc FROM MovieCinema mc where mc.dateTime > ?1")
    List<MovieCinema> retrieveMoviesWithHigherDate(LocalDateTime dateTime);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id

    @Query(value = "SELECT COUNT(*) FROM movie_cinema where cinema_id = ?1",nativeQuery = true)
    Integer sumOfMoviesByCinemaId(Long cinemaId);



    //Write a native query that returns all movie cinemas by location name

    @Query(value = "SELECT mc * FROM movie_cinema mc JOIN cinema c ON mc.cinema_id = c.id JOIN location l ON c.location=l.id WHERE l.name=?1",nativeQuery = true)

    List<MovieCinema> retrievByLocationName(String name);





}