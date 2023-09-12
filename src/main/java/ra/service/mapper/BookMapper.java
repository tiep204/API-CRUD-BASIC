package ra.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ra.model.domain.Book;
import ra.model.domain.City;
import ra.model.dto.request.BookRequest;
import ra.model.dto.response.BookResponse;
import ra.repository.AuthorRepository;
import ra.repository.BookRepository;

@Component
public class BookMapper implements IGenericMapper<Book, BookRequest, BookResponse>{
    @Autowired
    private AuthorRepository authorRepository;
    @Override
    public Book toEntity(BookRequest bookRequest) {
        return Book.builder()
                .name(bookRequest.getName())
                .category(bookRequest.getCategory())
                .listAuthor(authorRepository.findByIdIsIn(bookRequest.getListAuthor()))
                .build();
    }

    @Override
    public BookResponse toResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .name(book.getName())
                .category(book.getCategory())
                .listAuthor(book.getListAuthor())
                .build();
    }
}