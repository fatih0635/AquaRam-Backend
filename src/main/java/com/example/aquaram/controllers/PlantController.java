package com.example.aquaram.controllers;

import com.example.aquaram.model.Plant;
import com.example.aquaram.service.PlantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {

        "https://c13c-31-61-230-184.ngrok-free.app",
        "https://aqua-ram.vercel.app"
}) // React frontend'e CORS izni verir
@RestController
@RequestMapping("/plants")
public class PlantController {

    private final PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping
    public List<Plant> getAllPlants() {
        return plantService.getAllPlants();
    }

    @PostMapping
    public Plant addPlant(@RequestBody Plant plant) {
        return plantService.addPlant(plant);
    }

    @DeleteMapping("/{id}")
    public void deletePlant(@PathVariable Long id) {
        plantService.deletePlant(id);
    }
}
