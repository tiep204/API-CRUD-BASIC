package ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.model.domain.Author;

import java.util.Collection;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Long> {
    List<Author> findByIdIsIn(Collection<Long> id);
}