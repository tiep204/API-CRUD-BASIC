package ra.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.domain.Book;
import ra.model.dto.request.BookRequest;
import ra.model.dto.response.BookResponse;
import ra.repository.BookRepository;
import ra.service.IBookService;
import ra.service.mapper.BookMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<BookResponse> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(book -> bookMapper.toResponse(book))
                .collect(Collectors.toList());
    }

    @Override
    public BookResponse findById(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()){
            return bookMapper.toResponse(bookOptional.get());
        }
        return null;
    }

    @Override
    public BookResponse save(BookRequest bookRequest) {
        Book book = bookRepository.save(bookMapper.toEntity(bookRequest));
        return bookMapper.toResponse(book);
    }

    @Override
    public BookResponse update(BookRequest bookRequest, Long id) {
        Book book = bookMapper.toEntity(bookRequest);
        book.setId(id);
        return bookMapper.toResponse(bookRepository.save(book));
    }

    @Override
    public BookResponse delete(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()){
            bookRepository.deleteById(id);
            return bookMapper.toResponse(bookOptional.get());
        }
        return null;
    }
}