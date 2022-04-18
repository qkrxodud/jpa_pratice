package jpawebpratice.jpapratice.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class IndustryItem {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;
    private String item;

}
