package ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.model.domain.ZipCode;

public interface ZipCodeRepository extends JpaRepository<ZipCode,Long> {
}
