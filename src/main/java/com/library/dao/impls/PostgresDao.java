package com.library.dao.impls;

import com.library.dao.interfaces.LibraryDAO;
import com.library.dao.objects.Author;
import com.library.dao.objects.Book;
import com.library.dao.objects.Genre;
import com.library.dao.objects.Reader;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class PostgresDao implements LibraryDAO {

    private final SessionFactory sessionFactory;

    public PostgresDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Book> getAllBooks() {
        Session session = sessionFactory.openSession();
        List<Book> books = session.createQuery("from Book").list();
        session.close();
        return books;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Genre> getAllGenres() {
        Session session = sessionFactory.openSession();
        List genres = session.createQuery("from Genre").list();
        session.close();
        return genres;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<String> getAllReadersNames() {
        Session session = sessionFactory.openSession();
        List readerNames = session.createCriteria(Reader.class).setProjection(Projections.property("readerName")).list();
        session.close();
        return readerNames;


    }

    @Override
    public void updateBook(Book book) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(book);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removeBookById(int bookId) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.delete(session.get(Book.class, bookId));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void addBook(String bookName, String authorName, String genreName, int value, int deposit, int count) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Author author = (Author) session
                .createCriteria(Author.class)
                .add(Restrictions.eq("authorName", authorName))
                .uniqueResult();
        Genre genre = (Genre) session
                .createCriteria(Genre.class)
                .add(Restrictions.eq("genreName", genreName))
                .uniqueResult();
        if (author == null) {
            author = new Author();
            author.setAuthorName(authorName);
            session.save(author);
        }
        if (genre == null) {
            genre = new Genre();
            genre.setGenreName(genreName);
            session.save(genre);
        }
        session.save(new Book(bookName, author, genre, value, deposit, count));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void addReader(String readerName, String readerPhone) {
        Reader newReader = new Reader();
        newReader.setPassword(readerPhone);
        newReader.setReaderName(readerName);
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(newReader);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    @SuppressWarnings("unchecked")
    //TODO:
    public List<Book> getBookListForReader(String readerName) {
//        Session session = sessionFactory.openSession();
//        List books = session.createCriteria("from Book").list();
//        session.close();
//        return books;
        return null;
    }
}
