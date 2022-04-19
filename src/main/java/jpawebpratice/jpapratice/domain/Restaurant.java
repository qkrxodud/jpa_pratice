package jpawebpratice.jpapratice.domain;

import jpawebpratice.jpapratice.domain.Exception.NotEnoughStockException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.List;
import static jpawebpratice.jpapratice.domain.comm.commFunction.isStringEmpty;

@Entity
@Setter @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Restaurant {

    @Id @GeneratedValue
    @Column(name = "restaurant_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Embedded
    private Address address;

    private String name;

    private String selfInfo;
    private String phoneNumber;
    private String wayCome;

    @OneToMany(mappedBy = "restaurant")
    private List<RestaurantAmenity> amenityList = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant")
    private List<MemberRestaurantStatus> memberRestaurantStatuses = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant")
    private List<Industry> industries = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant")
    private List<RestaurantFile> restaurantFiles = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant")
    private List<Menu> menus = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant")
    private List<BusinessHours> businessHours = new ArrayList<>();

    public Restaurant(Member member, Address address, String name, String selfInfo, String phoneNumber, String wayCome,  List<RestaurantAmenity> amenityList, List<MemberRestaurantStatus> memberRestaurantStatuses, List<Industry> industries, List<RestaurantFile> restaurantFiles, List<Menu> menus, List<BusinessHours> businessHours) {
        this.member = member;
        this.address = address;
        this.name = name;
        this.selfInfo = selfInfo;
        this.phoneNumber = phoneNumber;
        this.wayCome = wayCome;
        this.amenityList = amenityList;
        this.memberRestaurantStatuses = memberRestaurantStatuses;
        this.industries = industries;
        this.restaurantFiles = restaurantFiles;
        this.menus = menus;
        this.businessHours = businessHours;
    }

    //==음식점 생성==//
    public static Restaurant createRestaurant(Member member, Address address
                     , String name, String selfInfo, String phoneNumber
                     , String wayCome, List<RestaurantAmenity> amenityList
                     , List<MemberRestaurantStatus> memberRestaurantStatuses, List<Industry> industries
                     , List<RestaurantFile> restaurantFiles, List<Menu> menus, List<BusinessHours> businessHours) {

        if (isStringEmpty(name) || isStringEmpty(phoneNumber)) {
            throw new NotEnoughStockException("상호명 또는 핸드폰 번호가 비어있습니다.");
        }

        if (amenityList.size() < 0 || industries.size() < 0 || menus.size() < 0 || businessHours.size()<0 ) {
            throw new NotEnoughStockException("편의시설,산업군, 매뉴, 영업시간이 비어있습니다.");
        }

        return new Restaurant(member, address, name,  selfInfo, phoneNumber, wayCome, amenityList, memberRestaurantStatuses, industries, restaurantFiles, menus, businessHours);
    }


}
