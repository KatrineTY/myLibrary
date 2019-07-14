package com.library.dao.interfaces;

import com.library.dao.objects.Book;
import com.library.dao.objects.Genre;

import java.util.List;

public interface LibraryDAO {

    List<Book> getAllBooks();

    List<Genre> getAllGenres();

    List<String> getAllReadersNames();

    void updateBook(Book book);

    void removeBookById(int bookId);

    void addBook(String bookName, String authorName, String genreName, int value, int deposit, int count);

    void addReader(String readerName, String readerPhone);

    List<Book> getBookListForReader(String readerName);
}