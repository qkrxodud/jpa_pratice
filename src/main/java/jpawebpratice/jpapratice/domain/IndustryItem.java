package jpawebpratice.jpapratice.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class IndustryItem {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;
    private String item;

    @ManyToOne
    @JoinColumn(name = "industry_id")
    private Industry industry;

}
