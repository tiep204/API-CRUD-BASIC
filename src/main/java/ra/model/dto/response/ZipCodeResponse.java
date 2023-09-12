package ra.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.model.domain.City;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZipCodeResponse {

    private Long id;
    private String name;
    private City city;
}