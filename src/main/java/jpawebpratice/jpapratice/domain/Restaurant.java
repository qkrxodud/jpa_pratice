package jpawebpratice.jpapratice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter @Getter
public class Restaurant {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Embedded
    private Address address;

    private String industry;
    private String selfInfo;
    private int phoneNumber;
    private String wayCome;
    private String ime;

    @OneToMany(mappedBy = "restaurant")
    private List<RestaurantAmenity> amenityList = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant")
    private List<Industry> industries = new ArrayList<>();


    // TODO 이미지를 추가해주자.
    // private List<String> views = new ArrayList<>();




}
