package jpawebpratice.jpapratice.domain.repository;

import jpawebpratice.jpapratice.domain.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class IndustryRepository {
    private final EntityManager em;

    // 산업직군으로 음식점 조회
    public List<Restaurant> findByRestaurantList(String name) {
        return em.createQuery("Select r from Restaurant r  " +
                                             " inner join Industry i on r.id = i.restaurant.id " +
                                             " where i.restaurant.industry = :industyName")
                .setParameter("industyName", name)
                .getResultList();
    }
}
