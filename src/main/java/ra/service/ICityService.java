package ra.service;

import ra.model.domain.City;
import ra.model.dto.request.CityRequest;
import ra.model.dto.response.CityResponse;

import java.util.List;

public interface ICityService {
    List<CityResponse> findAll();
    CityResponse findById(Long id);
    CityResponse save(CityRequest cityRequest);
    CityResponse update(CityRequest cityRequest,Long id);
    CityResponse delete(Long id);
}