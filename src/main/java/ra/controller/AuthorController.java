package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.model.dto.request.AuthorRequest;
import ra.model.dto.response.AuthorResponse;
import ra.service.IAuthorService;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private IAuthorService authorService;

    @GetMapping
    public ResponseEntity<List<AuthorResponse>> findAll() {
        List<AuthorResponse> authorResponses = authorService.findAll();
        return new ResponseEntity<>(authorResponses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> findById(@PathVariable Long id) {
        AuthorResponse authorResponse = authorService.findById(id);
        return new ResponseEntity<>(authorResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AuthorResponse> create(@RequestBody AuthorRequest authorRequest) {
        AuthorResponse authorResponse = authorService.save(authorRequest);
        return new ResponseEntity<>(authorResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponse> update(@RequestBody AuthorRequest authorRequest, @PathVariable Long id) {
        AuthorResponse authorResponse = authorService.update(authorRequest, id);
        return new ResponseEntity<>(authorResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AuthorResponse> delete(@PathVariable Long id) {
        AuthorResponse authorResponse = authorService.delete(id);
        return new ResponseEntity<>(authorResponse, HttpStatus.OK);
    }
}