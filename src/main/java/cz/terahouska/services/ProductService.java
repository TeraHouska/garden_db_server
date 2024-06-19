package cz.terahouska.services;

import cz.terahouska.dto.ProductDTO;
import cz.terahouska.dto.mappers.ProductMapper;
import cz.terahouska.entities.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductMapper productMapper;

    public List<ProductDTO> getSowVegetables() {
        return productRepository.findAll()
                .stream()
                .map(productEntity -> productMapper.toDTO(productEntity))
                .collect(Collectors.toList());
    }
}
