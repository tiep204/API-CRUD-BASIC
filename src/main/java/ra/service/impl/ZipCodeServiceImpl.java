package ra.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.domain.ZipCode;
import ra.model.dto.request.ZipCodeRequest;
import ra.model.dto.response.ZipCodeResponse;
import ra.repository.ZipCodeRepository;
import ra.service.IZipCodeService;
import ra.service.mapper.ZipCodeMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ZipCodeServiceImpl implements IZipCodeService {
    @Autowired
    private ZipCodeRepository zipCodeRepository;
    @Autowired
    private ZipCodeMapper zipCodeMapper;

    @Override
    public List<ZipCodeResponse> findAll() {
        return zipCodeRepository.findAll().stream()
                .map(zipCode -> zipCodeMapper.toResponse(zipCode))
                .collect(Collectors.toList());
    }

    @Override
    public ZipCodeResponse findById(Long id) {
        Optional<ZipCode> zipCodeOptional = zipCodeRepository.findById(id);
        if (!zipCodeOptional.isPresent()) {
            return null;
        }
        return zipCodeMapper.toResponse(zipCodeOptional.get());
    }

    @Override
    public ZipCodeResponse save(ZipCodeRequest zipCodeRequest) {
        ZipCode zipCode = zipCodeRepository.save(zipCodeMapper.toEntity(zipCodeRequest));
        return zipCodeMapper.toResponse(zipCode);
    }

    @Override
    public ZipCodeResponse update(ZipCodeRequest zipCodeRequest, Long id) {
        ZipCode zipCode = zipCodeMapper.toEntity(zipCodeRequest);
        zipCode.setId(id);
        return zipCodeMapper.toResponse(zipCodeRepository.save(zipCode));
    }

    @Override
    public ZipCodeResponse delete(Long id) {
        Optional<ZipCode> zipCodeOptional = zipCodeRepository.findById(id);
        if (zipCodeOptional.isPresent()) {
            zipCodeRepository.deleteById(id);
            return zipCodeMapper.toResponse(zipCodeOptional.get());
        }
        return null;
    }
}