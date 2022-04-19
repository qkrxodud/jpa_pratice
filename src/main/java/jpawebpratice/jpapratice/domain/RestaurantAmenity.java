package jpawebpratice.jpapratice.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class RestaurantAmenity {

    @Id @GeneratedValue
    @Column(name = "restaurant_amenity_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "restaurantAmenity")
    List<RestaurantAmenityItem> restaurantAmenities = new ArrayList<>();

}
