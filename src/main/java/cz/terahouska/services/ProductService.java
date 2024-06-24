package cz.terahouska.services;

import cz.terahouska.dto.ProductDTO;
import cz.terahouska.dto.mappers.ProductMapper;
import cz.terahouska.entities.ProductEntity;
import cz.terahouska.entities.filters.ProductTypeFilter;
import cz.terahouska.entities.repositories.ProductRepository;
import cz.terahouska.entities.repositories.specification.ProductTypeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductMapper productMapper;

    public List<ProductDTO> getSowProducts(ProductTypeFilter filter) {
        ProductTypeSpecification specification = new ProductTypeSpecification(filter);

        return productRepository.findAll(specification, PageRequest.of(0, filter.getLimit()))
                .stream()
                .map(productEntity -> productMapper.toDTO(productEntity))
                .collect(Collectors.toList());
    }

    public ProductDTO addProduct(ProductDTO sourceDTO) {
        ProductEntity resultEntity = productRepository.save(productMapper.toEntity(sourceDTO));
        return productMapper.toDTO(resultEntity);
    }

    public ProductDTO editProduct(long id, ProductDTO sourceDTO) {
        sourceDTO.setId(id);
        return addProduct(sourceDTO);
    }

    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }
}
