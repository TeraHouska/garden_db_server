package cz.terahouska.services;

import cz.terahouska.dto.FlowerDTO;
import cz.terahouska.dto.mappers.FlowerMapper;
import cz.terahouska.entities.FlowerEntity;
import cz.terahouska.entities.repositories.FlowerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlowerService {
    @Autowired
    FlowerRepository flowerRepository;
    @Autowired
    FlowerMapper flowerMapper;

    public List<FlowerDTO> getAllFlowers() {
        return flowerRepository.findAll().stream()
                .map(flowerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public FlowerDTO getFlowerDetail(long id) {
        checkIfExistsOrThrow(id);
        return flowerMapper.toDTO(flowerRepository.getReferenceById(id));
    }

    public FlowerDTO addFlower(FlowerDTO sourceDTO) {
        return flowerMapper.toDTO(flowerRepository.save(flowerMapper.toEntity(sourceDTO)));
    }

    public FlowerDTO editFlower(FlowerDTO sourceDTO, long id) {
        checkIfExistsOrThrow(id);
        sourceDTO.setId(id);

        return addFlower(sourceDTO);
    }

    public void deleteFlower(long id) {
        checkIfExistsOrThrow(id);
        flowerRepository.deleteById(id);
    }

    private void checkIfExistsOrThrow(long id) {
        if (!flowerRepository.existsById(id))
            throw new EntityNotFoundException("id nebylo nalezeno v databázi");
    }
}
