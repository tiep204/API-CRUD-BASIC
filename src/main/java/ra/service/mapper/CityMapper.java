package ra.service.mapper;

import org.springframework.stereotype.Component;
import ra.model.domain.City;
import ra.model.dto.request.CityRequest;
import ra.model.dto.response.CityResponse;

@Component
public class CityMapper implements IGenericMapper<City, CityRequest, CityResponse> {
    @Override
    public City toEntity(CityRequest cityRequest) {
        return City.builder()
                .name(cityRequest.getName())
                .build();
    }

    @Override
    public CityResponse toResponse(City city) {
        return CityResponse.builder()
                .id(city.getId())
                .name(city.getName())
                .build();
    }
}
