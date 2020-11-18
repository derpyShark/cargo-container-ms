package kpi.trspo.cargocontainerms.repository;

import kpi.trspo.cargocontainerms.model.CargoContainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CargoContainerRepository extends JpaRepository<CargoContainer, UUID> {
}
