package com.library.online_library.service;

import com.library.online_library.repository.AuthorRepository;
import com.library.online_library.model.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorServiceImpl authorService;

    @Test
    void testSaveAuthor() {
        Author author = new Author();
        author.setName("J.K. Rowling");

        when(authorRepository.save(any(Author.class))).thenReturn(author);

        Author result = authorService.saveAuthor(author);

        assertEquals("J.K. Rowling", result.getName());
    }
}
