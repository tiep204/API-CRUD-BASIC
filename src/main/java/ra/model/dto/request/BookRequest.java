package ra.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.model.domain.Author;
import ra.model.domain.Category;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
    private String name;
    private Category category;
    private List<Long> listAuthor;
}