package jpawebpratice.jpapratice.domain.service;

import jpawebpratice.jpapratice.domain.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Transactional
    public void saveRestaurant() {
//        Restaurant restaurant = createRestaurant('');
//        restaurantRepository.save(restaurant);
    }
}
