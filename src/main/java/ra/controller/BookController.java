package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.model.dto.request.BookRequest;
import ra.model.dto.response.BookResponse;
import ra.service.IBookService;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public ResponseEntity<List<BookResponse>> findAll() {
        List<BookResponse> bookResponseList = bookService.findAll();
        return new ResponseEntity<>(bookResponseList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> findById(@PathVariable Long id){
        BookResponse bookResponse = bookService.findById(id);
        return new ResponseEntity<>(bookResponse,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<BookResponse> create(@RequestBody BookRequest bookRequest){
        BookResponse bookResponse = bookService.save(bookRequest);
        return new ResponseEntity<>(bookResponse,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> update(@RequestBody BookRequest bookRequest,@PathVariable Long id){
        BookResponse bookResponse = bookService.update(bookRequest,id);
        return new ResponseEntity<>(bookResponse,HttpStatus.OK);
    }
}