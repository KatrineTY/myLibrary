package com.library.dao.objects;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class LibraryNotebook {
    @Id
    @Column
    private int id;
    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @Column(name = "date_taken")
    private String dateTaken;
    @Column(name = "date_return")
    private String dateReturn;

    public LibraryNotebook() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(String dateTaken) {
        this.dateTaken = dateTaken;
    }

    public String getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(String dateReturn) {
        this.dateReturn = dateReturn;
    }
}
