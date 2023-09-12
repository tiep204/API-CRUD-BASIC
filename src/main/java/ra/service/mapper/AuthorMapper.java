package ra.service.mapper;

import org.springframework.stereotype.Component;
import ra.model.domain.Author;
import ra.model.dto.request.AuthorRequest;
import ra.model.dto.response.AuthorResponse;

@Component
public class AuthorMapper implements IGenericMapper<Author, AuthorRequest, AuthorResponse> {
    @Override
    public Author toEntity(AuthorRequest authorRequest) {
        return Author.builder()
                .name(authorRequest.getName())
                .zipCode(authorRequest.getZipCode())
                .build();
    }

    @Override
    public AuthorResponse toResponse(Author author) {
        return AuthorResponse.builder()
                .id(author.getId())
                .name(author.getName())
                .zipCode(author.getZipCode())
                .build();
    }
}
