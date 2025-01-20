package NickyDev.LiterAlura.repository;

import NickyDev.LiterAlura.model.Book;
import NickyDev.LiterAlura.model.ELanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Book, Long> {
    List<Book> findByLanguagesContaining(ELanguage language);

    @Query("SELECT b FROM Book b JOIN b.authors a WHERE a.birthYear <= :year AND (a.deathYear >= :year OR a.deathYear IS NULL)")
    List<Book> findByYear(Integer year);
}
