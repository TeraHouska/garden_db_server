package cz.terahouska.controllers;

import cz.terahouska.dto.ProductDTO;
import cz.terahouska.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ProductDTO addProduct(@RequestBody ProductDTO sourceDTO) {
        return productService.addProduct(sourceDTO);
    }

    @PutMapping("/edit/{id}")
    public ProductDTO editProduct(@RequestBody ProductDTO sourceDTO, @PathVariable long id) {
        return productService.editProduct(id , sourceDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
    }
}
