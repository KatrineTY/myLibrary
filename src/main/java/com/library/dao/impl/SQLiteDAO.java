package com.library.dao.impl;

import com.library.dao.interfaces.LibraryDAO;
import com.library.dao.objects.Author;
import com.library.dao.objects.Book;
import com.library.dao.objects.Genre;
import com.library.dao.objects.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component("sqliteDAO")
public class SQLiteDAO implements LibraryDAO {

    private static final String allBooksView = "all_books";
    private static final String booksTable = "books";
    private static final String genresTable = "genres";

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


    @Override
    public List<Book> getAllBooks() {
        String sql = "select * from " + allBooksView;
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            Author author = new Author();
            author.setId(resultSet.getInt("author_id"));
            author.setAuthorName(resultSet.getString("author_name"));

            Genre genre = new Genre();
            genre.setId(resultSet.getInt("genre_id"));
            genre.setGenreName(resultSet.getString("genre_name"));

            Book book = new Book();
            book.setGenre(genre);
            book.setAuthor(author);
            book.setId(resultSet.getInt("book_id"));
            book.setCount(resultSet.getInt("count"));
            book.setBookName(resultSet.getString("book_name"));
            book.setDeposit(resultSet.getInt("deposit"));
            book.setValue(resultSet.getInt("value"));
            return book;
        });
    }

    @Override
    public List<Genre> getAllGenres() {
        String sql = "select * from " + genresTable;
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            Genre genre = new Genre();
            genre.setId(resultSet.getInt("id"));
            genre.setGenreName(resultSet.getString("genre_name"));
            return genre;
        });
    }

    @Override
    public List<Reader> getAllReaders() {
        return null;
    }

    @Override
    public void changeCountOfBook(int bookId, int count) {
        String sql = "UPDATE " + booksTable + " SET count = :count WHERE id = :bookId";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("count", count);
        params.addValue("bookId", bookId);
        jdbcTemplate.update(sql,params);

    }

    //TODO: why when I delete any of books, the note is present?
    @Override
    public void removeBookById(int bookId) {
        String sql = "DELETE FROM books where id = :bookId";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("bookId", bookId);
        jdbcTemplate.update(sql,params);
    }
}
