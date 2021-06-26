package com.task.Rudolf.task.service;

import com.task.Rudolf.task.entities.Restaurant;
import com.task.Rudolf.task.web.data.RestaurantDto;

import java.io.IOException;
import java.util.List;

public interface RestaurantService {
    void add(final RestaurantDto restaurantdto) throws IOException;
    List<Restaurant> listAllRestaurants();
}
