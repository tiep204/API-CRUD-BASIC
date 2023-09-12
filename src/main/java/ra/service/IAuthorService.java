package ra.service;

import ra.model.dto.request.AuthorRequest;
import ra.model.dto.response.AuthorResponse;

import java.util.List;

public interface IAuthorService {
    List<AuthorResponse> findAll();
    AuthorResponse findById(Long id);
    AuthorResponse save(AuthorRequest authorRequest);
    AuthorResponse update(AuthorRequest authorRequest,Long id);
    AuthorResponse delete(Long id);
}