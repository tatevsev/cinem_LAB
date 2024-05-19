package com.cydeo;

import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoQuery implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final CinemaRepository cinemaRepository;
    private final GenreRepository genreRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;
    private final MovieCinemaRepository movieCinemaRepository;


    public DemoQuery(AccountRepository accountRepository, CinemaRepository cinemaRepository, GenreRepository genreRepository, MovieRepository movieRepository, UserRepository userRepository, TicketRepository ticketRepository, MovieCinemaRepository movieCinemaRepository) {
        this.accountRepository = accountRepository;
        this.cinemaRepository = cinemaRepository;
        this.genreRepository = genreRepository;
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
        this.movieCinemaRepository = movieCinemaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        System.out.println("----------------ACCOUNT-----------------------------------");
//    System.out.println("findByCountyOrState :" + accountRepository.findByCountryOrState("United States","FL"));
//    System.out.println(accountRepository.findByAgeLessThanEqual(50));
////        System.out.println(cinemaRepository.getByName("Hall 1 - EMPIRE"));
////        System.out.println(genreRepository.retrieveAllGenres());
////
////        System.out.println("---------------GENRES--------------------------");
////        System.out.println(genreRepository.retrieveAllGenres());
////
////        System.out.println("retriveByNamme" + genreRepository.retrieveByName("dra"));
////
//        System.out.println("-------------MOVIE CINEMA-----------------------");
//      //  System.out.println(movieCinemaRepository.sumOfMoviesByCinemaId(1L));
//
//       // System.out.println(movieCinemaRepository.retrieveByLocationName("AMC Empire 25"));
//
//       //System.out.println(ticketRepository.countByUserAccount("josieStory"));
//        System.out.println(ticketRepository.findByUserAccountEmail("bernard@email.com"));
    }
}
