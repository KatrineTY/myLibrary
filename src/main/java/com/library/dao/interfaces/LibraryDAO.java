package com.library.dao.interfaces;

import com.library.dao.objects.Book;
import com.library.dao.objects.Genre;
import com.library.dao.objects.Reader;

import java.util.List;

public interface LibraryDAO {

    List<Book> getAllBooks();

    List<Genre> getAllGenres();

    List<Reader> getAllReaders();

    void changeCountOfBook(int bookId, int count);

    void removeBookById(int bookId);

    void addBook(String bookName, String authorName, String genreName, int value, int deposit, int count);

}
