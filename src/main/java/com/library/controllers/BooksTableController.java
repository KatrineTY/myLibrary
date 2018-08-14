package com.library.controllers;


import com.library.models.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BooksTableController {

    private static List<Book> bookList = createBookList();

    private static List<Book> createBookList() {

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(1,"book1kkkkk kkkkkkkk kkkkkkkkk kkkkkkk kkkkkkk kkkkkkkkkk kkkkkkkkkk", "author1", "genre1", 1000, 100, 10));
        bookList.add(new Book(2,"book2", "author1", "genre1", 1000, 100, 10));
        bookList.add(new Book(3,"book3", "author2", "genre1", 1000, 100, 10));
        bookList.add(new Book(4,"book4", "author1", "genre2", 1000, 100, 10));
        bookList.add(new Book(5,"book5", "author1", "genre3", 1000, 100, 10));
        bookList.add(new Book(6,"book6", "author5", "genre1", 1000, 100, 10));
        bookList.add(new Book(7,"book7", "author1", "genre4", 1000, 100, 10));
        bookList.add(new Book(8,"book8", "author6", "genre1", 1000, 100, 10));
        bookList.add(new Book(9,"book9", "author1", "genre1", 1000, 100, 10));
       bookList.add(new Book(10,"book1", "author1", "genre1", 1000, 100, 10));
       bookList.add(new Book(11,"book1 kkkkkkkkkk", "author1", "genre1", 1000, 100, 10));
        bookList.add(new Book(12,"book2", "author1", "genre1", 1000, 100, 10));
        bookList.add(new Book(13,"book3", "author2", "genre1", 1000, 100, 10));
        bookList.add(new Book(14,"book4", "author1", "genre2", 1000, 100, 10));
        bookList.add(new Book(15,"book5", "author1", "genre3", 1000, 100, 10));
        bookList.add(new Book(16,"book6", "author5", "genre1", 1000, 100, 10));
        bookList.add(new Book(17,"book7", "author1", "genre4", 1000, 100, 10));
        bookList.add(new Book(18,"book8", "author6", "genre1", 1000, 100, 10));
        bookList.add(new Book(19,"book9", "author1", "genre1", 1000, 100, 10));
        bookList.add(new Book(20,"book2", "author1", "genre1", 1000, 100, 10));
        bookList.add(new Book(21,"book1kkkkk kkkkkkkk kkkkkkkkk kkkkkkk kkkkkkk kkkkkkkkkk kkkkkkkkkk", "author1", "genre1", 1000, 100, 10));
        bookList.add(new Book(22,"book2", "author1", "genre1", 1000, 100, 10));
        bookList.add(new Book(23,"book3", "author2", "genre1", 1000, 100, 10));
        bookList.add(new Book(24,"book4", "author1", "genre2", 1000, 100, 10));
        bookList.add(new Book(25,"book5", "author1", "genre3", 1000, 100, 10));
        bookList.add(new Book(26,"book6", "author5", "genre1", 1000, 100, 10));
        bookList.add(new Book(27,"book7", "author1", "genre4", 1000, 100, 10));
        bookList.add(new Book(28,"book8", "author6", "genre1", 1000, 100, 10));
        bookList.add(new Book(29,"book9", "author1", "genre1", 1000, 100, 10));
        return bookList;
    }

    static List<Book> getBookList(){
        return bookList;
    }

    @RequestMapping(value = "/getCheckBoxResult", method = RequestMethod.POST)
    public ModelAndView getCheckBoxResult(@RequestParam(value = "genre", required = false) List<String> genres) {
        ModelAndView model = new ModelAndView("booksTable");
        if (genres == null) {
            model.addObject("bookList", bookList);
        } else {
            model.addObject("bookList", bookList.stream().filter(book -> genres.contains(book.getGenre())).collect(Collectors.toList()));
        }

        return model;
    }

    @RequestMapping(value = "/changeCountOfBook", method = RequestMethod.POST)
    public ModelAndView changeCountOfBook(@RequestParam(value = "bookId", required = false) List<Integer> booksId) {
        ModelAndView model = new ModelAndView("booksTable");
        if (booksId != null) {
            for (Book book : bookList) {
                if (booksId.contains(book.getId())) book.setCount(book.getCount() - 1);
            }
        }
        model.addObject("bookList", bookList);
        return model;
    }
}
