package ra.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.domain.City;
import ra.model.dto.request.CityRequest;
import ra.model.dto.response.CityResponse;
import ra.repository.CityRepository;
import ra.service.ICityService;
import ra.service.mapper.CityMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements ICityService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CityMapper cityMapper;

    @Override
    public List<CityResponse> findAll() {
        return cityRepository.findAll().stream()
                .map(city -> cityMapper.toResponse(city))
                .collect(Collectors.toList());
    }

    @Override
    public CityResponse findById(Long id) {
        Optional<City> cityOptional = cityRepository.findById(id);
        if (!cityOptional.isPresent()){
            return null;
        }
        return cityMapper.toResponse(cityOptional.get());
    }

    @Override
    public CityResponse save(CityRequest cityRequest) {
        City city = cityRepository.save(cityMapper.toEntity(cityRequest));
        return cityMapper.toResponse(city);
    }

    @Override
    public CityResponse update(CityRequest cityRequest, Long id) {
        City city = cityMapper.toEntity(cityRequest);
        city.setId(id);
        return cityMapper.toResponse(cityRepository.save(city));
    }

    @Override
    public CityResponse delete(Long id) {
        Optional<City> cityOptional = cityRepository.findById(id);
        if (cityOptional.isPresent()){
            cityRepository.deleteById(id);
            return cityMapper.toResponse(cityOptional.get());
        }
        return null;
    }
}