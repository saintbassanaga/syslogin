package tech.saintbassanaga.authapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import tech.saintbassanaga.authapi.models.Locations;

import java.util.UUID;

public interface LocationsRepository extends JpaRepository<Locations, UUID>, JpaSpecificationExecutor<Locations> {
}