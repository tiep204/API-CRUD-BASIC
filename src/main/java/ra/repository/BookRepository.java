package ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.model.domain.Book;

public interface BookRepository extends JpaRepository<Book,Long> {
}
