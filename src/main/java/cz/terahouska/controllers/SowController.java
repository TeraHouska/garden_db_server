package cz.terahouska.controllers;

import cz.terahouska.constant.ProductType;
import cz.terahouska.dto.ProductDTO;
import cz.terahouska.entities.filters.ProductTypeFilter;
import cz.terahouska.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sow")
public class SowController {

    @Autowired
    ProductService productService;

    @GetMapping("/vegetables")
    public List<ProductDTO> getVegetables() {
        ProductTypeFilter filter = new ProductTypeFilter();
        filter.setType(ProductType.SOW_VEGETABLE);
        return productService.getSowProducts(filter);
    }

    @GetMapping("/flowers")
    public List<ProductDTO> getFlowers() {
        ProductTypeFilter filter = new ProductTypeFilter();
        filter.setType(ProductType.SOW_FLOWER);
        return productService.getSowProducts(filter);
    }

    @GetMapping("/herbs")
    public List<ProductDTO> getHerbs() {
        ProductTypeFilter filter = new ProductTypeFilter();
        filter.setType(ProductType.SOW_HERB);
        return productService.getSowProducts(filter);
    }
}
