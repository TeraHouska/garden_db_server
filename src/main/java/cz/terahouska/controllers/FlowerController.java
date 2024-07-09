package cz.terahouska.controllers;

import cz.terahouska.dto.FlowerDTO;
import cz.terahouska.services.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flower")
public class FlowerController {
    @Autowired
    FlowerService flowerService;

    @GetMapping("/all")
    public List<FlowerDTO> getAllFlowers() {
        return flowerService.getAllFlowers();
    }

    @PostMapping("/add")
    public FlowerDTO addFlower(@RequestBody FlowerDTO sourceDTO) {
        return flowerService.addFlower(sourceDTO);
    }
}
