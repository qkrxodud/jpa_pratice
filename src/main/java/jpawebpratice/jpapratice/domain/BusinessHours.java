package jpawebpratice.jpapratice.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class BusinessHours {

    @Id @GeneratedValue
    @Column(name = "BusinessHours")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Enumerated(EnumType.STRING)
    private BusinessDtype businessDtype;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

}
