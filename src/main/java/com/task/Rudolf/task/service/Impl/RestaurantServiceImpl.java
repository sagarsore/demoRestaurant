package com.task.Rudolf.task.service.Impl;

import com.task.Rudolf.task.entities.*;
import com.task.Rudolf.task.repository.OpeningDayRepo;
import com.task.Rudolf.task.repository.RestaurantRepo;
import com.task.Rudolf.task.service.PlantService;
import com.task.Rudolf.task.service.RestaurantService;
import com.task.Rudolf.task.web.data.RestaurantDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantRepo restaurantRepo;
    @Autowired
    OpeningDayRepo openingDayRepo;
    @Autowired
    PlantService plantService;
    @Value("${file.upload-dir}")
    private String uploadPath;
    @Override
    public void add(RestaurantDto restaurantdto) throws IOException {
        Restaurant restaurant = new Restaurant();
        Address address  = new Address();
        address.setCity(restaurantdto.getCity());
        address.setStreet(restaurantdto.getStreet());
        address.setState(restaurantdto.getState());
        address.setPincode(restaurantdto.getPincode());
        restaurant.setAddress(address);
        restaurant.setServesGuest(restaurantdto.isServesGuest());
        restaurant.setName(restaurantdto.getName());
        restaurant.setDescription(restaurantdto.getDescription());
        restaurant.setPlant(plantService.getPlantById(restaurantdto.getPlant()));
        restaurant.setServesGuest(restaurantdto.isServesGuest());
        OpeningSchedule openingSchedule = new OpeningSchedule();
        List<OpeningDay> openingDayList = new ArrayList();
        for(int openingDayId:restaurantdto.getOpeningDays())
        {
            OpeningDay openingDay = openingDayRepo.getById((long)openingDayId);
            openingDayList.add(openingDay);
        }
        openingSchedule.setOpeningDayS(openingDayList);
        restaurant.setOpeningSchedule(openingSchedule);
        List<Media> mediaList = new ArrayList();
        for(MultipartFile file:restaurantdto.getFiles()) {
            Files.copy(file.getInputStream(), Paths.get(uploadPath+file.getOriginalFilename()));
            Media media = new Media();
            media.setPhoto(Paths.get(uploadPath+file.getOriginalFilename()).toString());
            mediaList.add(media);
        }
        restaurant.setMedia(mediaList);
        restaurantRepo.save(restaurant);
    }

    @Override
    public List<Restaurant> listAllRestaurants() {
        return restaurantRepo.findAll();
    }


}
