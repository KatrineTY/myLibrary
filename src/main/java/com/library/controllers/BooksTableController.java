package com.library.controllers;

import com.library.dao.interfaces.LibraryDAO;
import com.library.dao.objects.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BooksTableController {

    @Autowired
    LibraryDAO libraryDAO;

    @RequestMapping(value = "/getCheckBoxResult", method = RequestMethod.POST)
    public ModelAndView getCheckBoxResult(@RequestParam(value = "genre", required = false) List<String> genres,
                                          HttpSession session) {
        List<Book> bookList = libraryDAO.getAllBooks();

        ModelAndView model = new ModelAndView("booksTable");
        if (genres == null) {
            model.addObject("bookList", bookList);
        } else {
            model.addObject("bookList", bookList.stream().filter(book -> genres.contains(book.getGenre().getGenreName())).collect(Collectors.toList()));
        }
        return model;
    }

    @RequestMapping(value = "/changeCountOfBook", method = RequestMethod.POST)
    public ModelAndView changeCountOfBook(@RequestParam(value = "bookId", required = false) List<Integer> booksId,
                                          HttpSession session) {
        List<Book> bookList = libraryDAO.getAllBooks();
        ModelAndView model = new ModelAndView("booksTable");
        if (booksId != null) {
            for (Book book : bookList) {
                if (booksId.contains(book.getId())) {
                    book.setCount(book.getCount() - 1);
                    libraryDAO.updateBook(book);

                }
            }
        }
        model.addObject("bookList", bookList);
        return model;
    }
}
