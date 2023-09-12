package ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.model.domain.City;

public interface CityRepository extends JpaRepository<City,Long> {
}
