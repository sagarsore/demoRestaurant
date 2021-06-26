package com.task.Rudolf.task.service.Impl;

import com.task.Rudolf.task.entities.Address;
import com.task.Rudolf.task.entities.Media;
import com.task.Rudolf.task.entities.Plant;
import com.task.Rudolf.task.repository.PlantRepo;
import com.task.Rudolf.task.service.PlantService;
import com.task.Rudolf.task.web.data.PlantDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlantServiceImpl implements PlantService {

    @Autowired
    PlantRepo plantRepo;
    @Value("${file.upload-dir}")
    private String uploadPath;
    @Override
    @Transactional
    public void addPlant(PlantDto plantdto) throws IOException {
        Plant plant = new Plant();
        Address address  = new Address();
        address.setCity(plantdto.getCity());
        address.setStreet(plantdto.getStreet());
        address.setState(plantdto.getState());
        address.setPincode(plantdto.getPincode());
        plant.setAddress(address);
        plant.setDescription(plantdto.getDescription());
        plant.setName(plantdto.getName());

        List<Media> mediaList = new ArrayList();
        for(MultipartFile file:plantdto.getFiles()) {
            Files.copy(file.getInputStream(), Paths.get(uploadPath+file.getOriginalFilename()));
            Media media = new Media();
            media.setPhoto(Paths.get(uploadPath+file.getOriginalFilename()).toString());
            mediaList.add(media);
        }
        plant.setMedia(mediaList);
        plantRepo.save(plant);
    }

    @Override
    public Plant getPlantById(long id) {
      return  plantRepo.getById(id);
    }
}
