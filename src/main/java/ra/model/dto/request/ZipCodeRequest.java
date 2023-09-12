package ra.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.model.domain.City;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZipCodeRequest {
    private String name;
    private City city;
}