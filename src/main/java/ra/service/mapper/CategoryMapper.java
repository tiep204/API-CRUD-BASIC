package ra.service.mapper;

import org.springframework.stereotype.Component;
import ra.model.domain.Category;
import ra.model.dto.request.CategoryRequest;
import ra.model.dto.response.CategoryResponse;
@Component
public class CategoryMapper implements IGenericMapper<Category, CategoryRequest, CategoryResponse> {
    @Override
    public Category toEntity(CategoryRequest categoryRequest) {
        return Category.builder().name(categoryRequest.getName()).build();
    }

    @Override
    public CategoryResponse toResponse(Category category) {
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}