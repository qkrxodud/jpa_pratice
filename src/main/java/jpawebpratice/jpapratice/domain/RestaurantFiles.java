package jpawebpratice.jpapratice.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class RestaurantFiles {

    @Id
    @GeneratedValue
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
