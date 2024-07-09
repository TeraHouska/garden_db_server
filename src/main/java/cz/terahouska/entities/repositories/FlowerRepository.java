package cz.terahouska.entities.repositories;

import cz.terahouska.entities.FlowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowerRepository extends JpaRepository<FlowerEntity, Long> {
}
