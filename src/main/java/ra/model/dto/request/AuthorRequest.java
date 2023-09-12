package ra.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.model.domain.ZipCode;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorRequest {
    private String name;
    private ZipCode zipCode;
}