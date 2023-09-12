package ra.service;

import ra.model.dto.request.CategoryRequest;
import ra.model.dto.response.CategoryResponse;

import java.util.List;

public interface ICategoryService {
    List<CategoryResponse> findAll();
    CategoryResponse findById(Long id);
    CategoryResponse save(CategoryRequest categoryRequest);
    CategoryResponse update(CategoryRequest categoryRequest,Long id);
    CategoryResponse delete(Long id);
}