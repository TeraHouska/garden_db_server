package cz.terahouska.dto.mappers;

import cz.terahouska.dto.FlowerDTO;
import cz.terahouska.entities.FlowerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FlowerMapper {
    FlowerEntity toEntity(FlowerDTO source);
    FlowerDTO toDTO(FlowerEntity source);
}
