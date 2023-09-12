package ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.model.domain.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
