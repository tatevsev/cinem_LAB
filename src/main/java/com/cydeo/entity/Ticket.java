package com.cydeo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Ticket extends BaseEntity{
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime date_time;
    private Integer seatNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    private MovieCinema movieCinema;
    @ManyToOne(fetch = FetchType.LAZY)
    private User userAccount;


}
