package cz.terahouska.controllers;

import cz.terahouska.dto.FlowerDTO;
import cz.terahouska.services.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/flower")
@Secured("ROLE_ADMIN")
public class AdminFlowerController {
    @Autowired
    FlowerService flowerService;

    @PostMapping("/add")
    public FlowerDTO addFlower(@RequestBody FlowerDTO sourceDTO) {
        return flowerService.addFlower(sourceDTO);
    }

    @PutMapping("/edit/{id}")
    public FlowerDTO editFlower(@RequestBody FlowerDTO sourceDTO, @PathVariable long id) {
        return flowerService.editFlower(sourceDTO, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFlower(@PathVariable long id) {

        flowerService.deleteFlower(id);
    }
}
