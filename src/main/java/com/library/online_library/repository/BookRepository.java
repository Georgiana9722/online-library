package com.library.online_library.repository;

 import com.library.online_library.model.Book;
 import org.springframework.data.jpa.repository.JpaRepository;

 import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>{
 List<Book>findByAuthorContainingIgnoreCase(String author);
 List<Book>findByTitleContainingIgnoreCase(String title);
}
