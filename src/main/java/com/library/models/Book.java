package com.library.models;

public class Book {
    private String bookName;
    private String authorName;
    private String genre;
    private int value;
    private int deposit;
    private int count;
    private int id;

    public Book(int id, String bookName, String authorName, String genre, int value, int deposit, int count) {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.genre = genre;
        this.value = value;
        this.deposit = deposit;
        this.count = count;
    }

    public Book() {

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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
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
