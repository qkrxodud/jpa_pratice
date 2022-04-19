package jpawebpratice.jpapratice.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class RestaurantFile {

    @Id
    @GeneratedValue
    @Column(name = "restaurantFile_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    private String filePath;
    private String fileName;

    @Enumerated(EnumType.STRING)
    private FileType fileType;

    private int fileSize;
}
