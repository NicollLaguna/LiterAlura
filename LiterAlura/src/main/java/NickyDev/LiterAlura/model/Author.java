package NickyDev.LiterAlura.model;


import jakarta.persistence.*;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Authors")

@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true, nullable = false)
    String name;
    Integer yearbirth;
    Integer yeardeath;
    @ManyToOne()
    @JoinColumn(name = "book_id")
    private Book book;


    public Author(String name, Integer yearbirth, Integer yeardeath) {
        this.name = name;
        this.yearbirth = yearbirth;
        this.yeardeath = yeardeath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYearbirth() {
        return yearbirth;
    }

    public void setYearbirth(Integer yearbirth) {
        this.yearbirth = yearbirth;
    }

    public Integer getYeardeath() {
        return yeardeath;
    }

    public void setYeardeath(Integer yeardeath) {
        this.yeardeath = yeardeath;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String toString() {
        return "id=" + id +
                ", Name='" + name + '\'' +
                ", Year of Birth=" + yearbirth +
                ", Year of Death=" + yeardeath;
    }
}