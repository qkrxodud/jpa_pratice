package jpawebpratice.jpapratice.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class RestaurantAmenityItem {

    @Id @GeneratedValue
    @Column(name = "restaurant_amenity_item_id")
    private Long id;
    private String item;

    @ManyToOne
    @JoinColumn(name = "restaurant_amenity_id")
    RestaurantAmenity restaurantAmenity;

}
