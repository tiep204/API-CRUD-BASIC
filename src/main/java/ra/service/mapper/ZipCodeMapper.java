package ra.service.mapper;

import org.springframework.stereotype.Component;
import ra.model.domain.ZipCode;
import ra.model.dto.request.ZipCodeRequest;
import ra.model.dto.response.ZipCodeResponse;
@Component
public class ZipCodeMapper implements IGenericMapper<ZipCode, ZipCodeRequest, ZipCodeResponse>{
    @Override
    public ZipCode toEntity(ZipCodeRequest zipCodeRequest) {
        return ZipCode.builder()
                .name(zipCodeRequest.getName())
                .city(zipCodeRequest.getCity())
                .build();
    }

    @Override
    public ZipCodeResponse toResponse(ZipCode zipCode) {
        return ZipCodeResponse.builder()
                .id(zipCode.getId())
                .name(zipCode.getName())
                .city(zipCode.getCity())
                .build();
    }
}