package cz.terahouska.controllers;

import cz.terahouska.constant.ProductType;
import cz.terahouska.dto.ProductDTO;
import cz.terahouska.entities.filters.ProductTypeFilter;
import cz.terahouska.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/vegetables")
    public List<ProductDTO> getVegetables() {
        ProductTypeFilter filter = new ProductTypeFilter();
        filter.setType(ProductType.SOW_VEGETABLE);
        return productService.getProducts(filter);
    }

    @GetMapping("/herbs")
    public List<ProductDTO> getHerbs() {
        ProductTypeFilter filter = new ProductTypeFilter();
        filter.setType(ProductType.SOW_HERB);
        return productService.getProducts(filter);
    }

    @GetMapping("/reap")
    public List<ProductDTO> getReapProducts() {
        ProductTypeFilter filter = new ProductTypeFilter();
        filter.setType(ProductType.REAP);
        return productService.getProducts(filter);
    }

    @GetMapping("/souls")
    public List<ProductDTO> getSoulsProducts() {
        ProductTypeFilter filter = new ProductTypeFilter();
        filter.setType(ProductType.SOULS);
        return productService.getProducts(filter);
    }

    @GetMapping("/{id}")
    public ProductDTO getProductDetail(@PathVariable long id) {
        return productService.getProductDetail(id);
    }

    @GetMapping("/types")
    public ProductType[] getTypes() {
        return ProductType.values();
    }
}
