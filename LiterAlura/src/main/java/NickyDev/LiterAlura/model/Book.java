package NickyDev.LiterAlura.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String title;
    @ElementCollection(targetClass = ELanguage.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "book_languages", joinColumns = @JoinColumn(name = "book_id"))
    @Column(name = "language")
    private List<ELanguage> languages = new ArrayList<>();
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Author> authors;

    public Book(BookData bookData) {
        this.title = bookData.results().get(0).title();
        List<Author> authorList = new ArrayList<>();
        for (AuthorData authorData : bookData.results().get(0).authors()) {
            Author author = new Author(authorData.name(), authorData.yearbirth(), authorData.yeardeath());
            author.setBook(this);
            authorList.add(author);
        }
        this.authors = authorList;
        List<ELanguage> languageList = new ArrayList<>();
        for (String languageStr : bookData.results().get(0).languages()) {
            ELanguage language = ELanguage.fromString(languageStr.split(",")[0].trim());  // Adjust this if necessary
            languageList.add(language);
        }
        this.languages = languageList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ELanguage> getLanguages() {
        return languages;
    }

    public void setLanguages(List<ELanguage> languages) {
        this.languages = languages;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", title='" + title + '\'' +
                ", languages=" + languages +
                ", authors=" + authors;
    }
}

