package ra.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.domain.Category;
import ra.model.dto.request.CategoryRequest;
import ra.model.dto.response.CategoryResponse;
import ra.repository.CategoryRepository;
import ra.service.ICategoryService;
import ra.service.mapper.CategoryMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<CategoryResponse> findAll() {
        return categoryRepository.findAll().stream()
                .map(c->categoryMapper.toResponse(c))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryResponse findById(Long id) {
        Optional<Category> categoryOptional =categoryRepository.findById(id);
        if (categoryOptional.isPresent()){
            return categoryMapper.toResponse(categoryOptional.get());
        }
        return null;
    }

    @Override
    public CategoryResponse save(CategoryRequest categoryRequest) {
        Category category =categoryRepository.save(categoryMapper.toEntity(categoryRequest));
        return categoryMapper.toResponse(category);
    }

    @Override
    public CategoryResponse update(CategoryRequest categoryRequest, Long id) {
        Category category =categoryMapper.toEntity(categoryRequest);
        category.setId(id);
        return categoryMapper.toResponse(categoryRepository.save(category));
    }

    @Override
    public CategoryResponse delete(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()){
            categoryRepository.deleteById(id);
            return categoryMapper.toResponse(categoryOptional.get());
        }
        return null;
    }
}