package ra.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.domain.Author;
import ra.model.dto.request.AuthorRequest;
import ra.model.dto.response.AuthorResponse;
import ra.repository.AuthorRepository;
import ra.service.IAuthorService;
import ra.service.mapper.AuthorMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements IAuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public List<AuthorResponse> findAll() {
        return authorRepository.findAll()
                .stream()
                .map(author -> authorMapper.toResponse(author))
                .collect(Collectors.toList());
    }

    @Override
    public AuthorResponse findById(Long id) {
        Optional<Author> authorResponseOptional = authorRepository.findById(id);
        if (authorResponseOptional.isPresent()){
            return authorMapper.toResponse(authorResponseOptional.get());
        }
        return null;
    }

    @Override
    public AuthorResponse save(AuthorRequest authorRequest) {
        Author author = authorRepository.save(authorMapper.toEntity(authorRequest));
        return authorMapper.toResponse(author);
    }

    @Override
    public AuthorResponse update(AuthorRequest authorRequest, Long id) {
        Author author = authorMapper.toEntity(authorRequest);
        author.setId(id);
        return authorMapper.toResponse(authorRepository.save(author));
    }

    @Override
    public AuthorResponse delete(Long id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (optionalAuthor.isPresent()){
            authorRepository.deleteById(id);
            return authorMapper.toResponse(optionalAuthor.get());
        }
        return null;
    }
}
