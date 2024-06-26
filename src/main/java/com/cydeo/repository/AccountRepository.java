package com.cydeo.repository;

import com.cydeo.entity.Account;
import com.cydeo.entity.User;
import com.cydeo.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface AccountRepository extends JpaRepository<Account, Long> {



    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state

    List<Account> findByCountryOrState(String country, String state);

    //Write a derived query to list all accounts with age lower than or equal to a specific value

    List<Account> findByAgeLessThanEqual(Integer age);

    //Write a derived query to list all accounts with a specific role

    List<Account> findByRole(UserRole role);

    //Write a derived query to list all accounts between a range of ages

    List<Account> findByAgeBetween(Integer age1, Integer age2);

    //Write a derived query to list all accounts where the beginning of the address contains the keyword

    List<Account> findByAddressStartingWith(String address);

    //Write a derived query to sort the list of accounts with age

    List<Account> findByOrderByAge();

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts
    @Query( "SELECT a FROM Account a")
    List<Account> showAllAccounts();



    //Write a JPQL query to list all admin accounts

    @Query("SELECT a FROM Account a WHERE a.role= 'admin'")
    List<Account> fetchAdminAccounts();

    //Write a JPQL query to sort all accounts with age

    @Query("SELECT a FROM  Account a ORDER BY a.age")
    List<Account> fetchAll();


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value

    @Query(value = "SELECT * FROM account_details where age <?1", nativeQuery = true)
    List<Account> readByAge(Integer age);



    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city
    @Query(value = "SELECT * FROM account_details where name ILIKE concat('%',?1,'%') or address ILIKE concat('%',?1,'%') or country ILIKE concat('%',?1,'%') or  city ILIKE concat('%',?1,'%')", nativeQuery = true)
    List<Account> retrieveBySearchCriteria(String pattern);

    //ILIKE makes ir case insensitive

    //Write a native query to read all accounts with an age higher than a specific value

    @Query(value = "SELECT * from account_details where age > ?1", nativeQuery = true)
    List<Account> retrieveAccountsWithAgeHigherThan(Integer age);

    @Query(value = "SELECT * from account_details where age > :age", nativeQuery = true)
    List<Account> retrieveAccountsWithAgeHigherThan2(@Param(("age")) Integer age);






}
