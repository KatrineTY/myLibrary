package com.library.dao.objects;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "books")
public class Book {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "Непустое поле!")
    @Pattern(regexp = "[a-zA-Z]+[\\s[a-zA-Z]+]*", message = "Должны быть только буквы")
    @Column(name = "book_name")
    private String bookName;
    @ManyToOne
    @JoinColumn(name = "author_id")
    @NotNull
    private Author author;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    @NotNull
    private Genre genre;

    @Column
    @Min(value = 0, message = "Только положительные числа")
    private int value;
    @Column
    @Min(value = 0, message = "Только положительные числа")
    private int deposit;
    @Column
    @Min(value = 0, message = "Только положительные числа")
    private int count;

    public Book() {
    }

    public Book(String bookName, Author author, Genre genre, int value, int deposit, int count) {
        this.bookName = bookName;
        this.author = author;
        this.genre = genre;
        this.value = value;
        this.deposit = deposit;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
