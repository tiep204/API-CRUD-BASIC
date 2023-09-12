package ra.service;

import ra.model.dto.request.BookRequest;
import ra.model.dto.response.BookResponse;

import java.util.List;

public interface IBookService {
    List<BookResponse> findAll();
    BookResponse findById(Long id);
    BookResponse save(BookRequest bookRequest);
    BookResponse update(BookRequest bookRequest,Long id);
    BookResponse delete(Long id);
}