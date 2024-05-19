package com.cydeo.repository;

import com.cydeo.entity.Cinema;
import com.cydeo.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {
    // ------------------- DERIVED QUERIES ------------------- //


    //Write a derived query to get cinema with a specific name

    Optional<Cinema> getByName(String name); //to avoid null pointer exception we would use optional
  //  Cinema getByName(String name);

    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name

    List<Cinema> findTop3BySponsoredNameContainingOrderBySponsoredName(String name);

    //Write a derived query to list all cinemas in a specific country

    List<Cinema> findAllByLocationCountry(String country);


    //Write a derived query to list all cinemas with a specific name or sponsored name

    List<Cinema> findByNameOrSponsoredName(String name,String sponsoredName);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to read the cinema name with a specific id

    @Query("SELECT c.name FROM Cinema c where c.id in ?1" )
    String showWithId(Long id);


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all cinemas by location country

    @Query(value = "SELECT * From  cinema c JOIN location l ON c.location_id = l.id where l.country =?1", nativeQuery = true )
    List<Cinema> fetchAllCinemasByCountry(String locationCountry);

    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern

    @Query(value = "SELECT * from Cinema where name ILIKE concat('%',?1,'%') or sponsoredName ILIKE concat('%',?1,'%')", nativeQuery = true)
    List<Cinema> retriveAllByNameOrSponsoredName(String pattern);


    //Write a native query to sort all cinemas by name

    @Query(value = "SELECT * from Cinema ORDER BY name", nativeQuery = true)
    List<Cinema> sortByName();


    //Write a native query to distinct all cinemas by sponsored name

    @Query(value = "SELECT distinct sponsored_name FROM cinema", nativeQuery = true)
    List<String> sortBySponsorName();



}
