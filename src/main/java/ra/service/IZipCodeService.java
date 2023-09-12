package ra.service;

import ra.model.dto.request.ZipCodeRequest;
import ra.model.dto.response.ZipCodeResponse;

import java.util.List;

public interface IZipCodeService {
    List<ZipCodeResponse> findAll();
    ZipCodeResponse findById(Long id);
    ZipCodeResponse save(ZipCodeRequest zipCodeRequest);
    ZipCodeResponse update(ZipCodeRequest zipCodeRequest,Long id);
    ZipCodeResponse delete(Long id);
}