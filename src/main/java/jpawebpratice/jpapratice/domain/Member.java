package jpawebpratice.jpapratice.domain;

import lombok.Getter;
import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "member")
    private List<Restaurant> restaurantList = new ArrayList<>();

    private String nickName;
    private String self_info;
    private Long password;
    private int phoneNumber;
    private int referralCode;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String img;

}
