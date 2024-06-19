package cz.terahouska.controllers;

import cz.terahouska.dto.ProductDTO;
import cz.terahouska.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sow")
public class SowController {

    @Autowired
    ProductService productService;

    @RequestMapping("/vegetables")
    public List<ProductDTO> getVegetables() {
        return productService.getSowVegetables();
    }
}
