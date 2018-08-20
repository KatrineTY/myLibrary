package com.library.dao.impl;

import com.library.dao.interfaces.LibraryDAO;
import com.library.dao.objects.Author;
import com.library.dao.objects.Book;
import com.library.dao.objects.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component("sqliteDAO")
public class SQLiteDAO implements LibraryDAO {

    private static final String allBooksView = "all_books";
    private static final String booksTable = "books";
    private static final String genresTable = "genres";
    private static final String readersTable = "readers";
    private static final String authorsTable = "authors";

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
        String sql = "SELECT * FROM " + genresTable;
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            Genre genre = new Genre();
            genre.setId(resultSet.getInt("id"));
            genre.setGenreName(resultSet.getString("genre_name"));
            return genre;
        });
    }

    @Override
    public List<String> getAllReadersNames() {
        String sql = "SELECT * FROM " + readersTable;

        return jdbcTemplate.query(sql, (resultSet, i) -> {
            return resultSet.getString("reader_name");
        });
    }

    @Override
    public void changeCountOfBook(int bookId, int count) {
        String sql = "UPDATE " + booksTable + " SET count = :count WHERE id = :bookId";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("count", count);
        params.addValue("bookId", bookId);
        jdbcTemplate.update(sql, params);
    }

    //TODO: why when I delete any of books, the note is present?
    @Override
    public void removeBookById(int bookId) {
        String sql = "DELETE FROM " + booksTable + " where id = :bookId";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("bookId", bookId);
        jdbcTemplate.update(sql, params);
    }

    @Override
    public void addBook(String bookName, String authorName, String genreName, int value, int deposit, int count) {
        String sql = "SELECT count(*) FROM " + authorsTable + " WHERE author_name = ?;";
        int authorId;
        int genreId;
        if (jdbcTemplate.getJdbcOperations()
                .queryForObject(sql, new Object[]{authorName}, Integer.class) == 0) {
            authorId = insertAuthor(authorName);
        } else {
            authorId = findAuthorId(authorName);
        }

        sql = "SELECT count(*) FROM " + genresTable + " WHERE genre_name = ?;";
        if (jdbcTemplate.getJdbcOperations()
                .queryForObject(sql, new Object[]{genreName}, Integer.class) == 0) {
            genreId = insertGenre(genreName);
        } else {
            genreId = findGenreId(genreName);
        }

        insertBook(bookName, authorId, genreId, value, deposit, count);
    }

    @Override
    public void addReader(String readerName, String readerPhone) {
        String sql = "INSERT into " + readersTable + " (reader_name, phone) VALUES (:readerName, :readerPhone)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("readerName", readerName);
        params.addValue("readerPhone", readerPhone);

        jdbcTemplate.update(sql, params);
    }

    @Override
    public List<Book> getBookListForReader(String readerName) {
        return null;
    }

    private void insertBook(String bookName, int authorId, int genreId, int value, int deposit, int count) {
        String sql = "INSERT into " + booksTable + " (book_name, author_id,genre_id,value,deposit,count) " +
                "VALUES (:bookName, :authorId, :genreId, :value, :deposit, :count)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("bookName", bookName);
        params.addValue("authorId", authorId);
        params.addValue("genreId", genreId);
        params.addValue("value", value);
        params.addValue("deposit", deposit);
        params.addValue("count", count);

        jdbcTemplate.update(sql, params);

    }

    private int insertAuthor(String authorName) {
        String sql = "INSERT into " + authorsTable + " (author_name) VALUES (:authorName)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("authorName", authorName);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, params, keyHolder);

        return keyHolder.getKey().intValue();
    }

    private int insertGenre(String genreName) {
        String sql = "INSERT into " + genresTable + " (genre_name) VALUES (:genreName)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("genreName", genreName);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, params, keyHolder);

        return keyHolder.getKey().intValue();
    }

    private int findAuthorId(String authorName) {
        String sql = "SELECT id FROM " + authorsTable + " WHERE author_name = ?;";
        return jdbcTemplate.getJdbcOperations().queryForObject(sql, new Object[]{authorName}, Integer.class);
    }

    private int findGenreId(String genreName) {
        String sql = "SELECT id FROM " + genresTable + " WHERE genre_name = ?;";
        return jdbcTemplate.getJdbcOperations().queryForObject(sql, new Object[]{genreName}, Integer.class);
    }
}
