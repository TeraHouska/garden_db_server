package cz.terahouska.dto.mappers;

import cz.terahouska.dto.ProductDTO;
import cz.terahouska.entities.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductEntity toEntity(ProductDTO source);
    ProductDTO toDTO(ProductEntity source);
}
