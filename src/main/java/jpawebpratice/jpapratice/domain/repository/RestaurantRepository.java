package jpawebpratice.jpapratice.domain.repository;

import jpawebpratice.jpapratice.domain.Address;
import jpawebpratice.jpapratice.domain.Comment;
import jpawebpratice.jpapratice.domain.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RestaurantRepository {
    private final EntityManager em;

    // 레스토랑 저장
    public void save(Restaurant restaurant){
        em.persist(restaurant);
    }

    // 음식점 조회
    public Restaurant findRestaurant(Restaurant restaurant) {
        return em.find(Restaurant.class, restaurant);
    }

    // 음식점 이름으로 조회
    public List<Restaurant> findByName(String name) {
        return em.createQuery("Select R from Restaurant r where r.name = :name")
                .setParameter("name", name)
                .getResultList();
    }

    // 음식점들 지역으로 조회
    public List<Restaurant> findByAddress(Address address) {
        return em.createQuery("Select R from Restaurant r where " +
                        " r.address.city = :city " +
                        " and r.address.street = :street " +
                        " and r.address.zipcode = :zipcode")
                .setParameter("city", address.getCity())
                .setParameter("street", address.getStreet())
                .setParameter("zipcode", address.getZipcode())
                .getResultList();
    }

    // 음식점 댓글 조회
    public List<Comment> commentFindByRestaurant(Restaurant restaurant) {
        return em.createQuery("select c from Comment c where c.restaurant.id = : restaurantId")
                .setParameter("restaurantId", restaurant.getId())
                .getResultList();
    }

    // TODO 좋아요 순으로 조회

    // TODO 조회수 순으로 조회

    // TODO 태그로 + 조회수 순으로 조회

    //
}
