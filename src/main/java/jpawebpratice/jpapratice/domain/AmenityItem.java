package jpawebpratice.jpapratice.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class AmenityItem {

    @Id @GeneratedValue
    private Long id;
    private String item;

}
