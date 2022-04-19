package jpawebpratice.jpapratice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Industry {

    @Id @GeneratedValue
    @Column(name = "industry_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "industry")
    List<IndustryItem> industryItems = new ArrayList<>();
}
