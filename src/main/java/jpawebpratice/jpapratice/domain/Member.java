package jpawebpratice.jpapratice.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @OneToMany(mappedBy = "member")
    private List<Restaurant> restaurantList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberRestaurantStatus> memberRestaurantStatuses = new ArrayList<>();

    private String nickName;
    private String selfInfo;
    private Long password;
    private int phoneNumber;
    private String referralCode;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String img;

    protected Member(String nickName, String selfInfo, Long password, int phoneNumber, Gender gender, String img, String referralCode) {
        this.nickName = nickName;
        this.selfInfo = selfInfo;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.img = img;
        this.referralCode = referralCode;
    }

    //==멤버 생성==//
    public static Member createMember(String nickName, String selfInfo, Long password, int phoneNumber, Gender gender, String img) {

        // 레퍼럴 코드 생성해서 넣어주자.
        String referralCode = createReferralCode();
        return new Member(nickName, selfInfo, password, phoneNumber, gender, img, referralCode);
    }

    //레퍼럴 코드 생성
    protected static String createReferralCode() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
        StringBuffer sb = new StringBuffer();
        Random random = new SecureRandom();
        for (int i = 0; i < 9; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

}
