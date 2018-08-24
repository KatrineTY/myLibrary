package com.library.dao.objects;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Book {
    private int id;
    @NotNull(message = "Непустое поле!")
    @Pattern(regexp = "[a-zA-Z]+[\\s[a-zA-Z]+]*" , message = "Должны быть только буквы")
    private String bookName;
    @NotNull
    private Author author;
    @NotNull
    private Genre genre;

    @Min(value = 0,message = "Только положительные числа")
    private int value;
    @Min(value = 0,message = "Только положительные числа")
    private int deposit;
    @Min(value = 0,message = "Только положительные числа")
    private int count;

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
