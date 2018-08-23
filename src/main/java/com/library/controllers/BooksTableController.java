package com.library.controllers;


import com.library.dao.impls.SQLiteDAO;
import com.library.dao.objects.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BooksTableController {

    @RequestMapping(value = "/getCheckBoxResult", method = RequestMethod.POST)
    public ModelAndView getCheckBoxResult(@RequestParam(value = "genre", required = false) List<String> genres,
                                          HttpSession session) {
        List<Book> bookList = ((SQLiteDAO)session.getAttribute("sqliteDAO")).getAllBooks();

        ModelAndView model = new ModelAndView("booksTable");
        if (genres == null) {
            model.addObject("bookList", bookList);
        } else {

            model.addObject("bookList", bookList.stream().filter(book -> genres.contains(book.getGenre().getGenreName())).collect(Collectors.toList()));
        }
        return model;
    }

    private String returnUTF8Str(String str){
        try {
            return new String(str.getBytes("ISO8859_1"), StandardCharsets.UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "ERROR";
    }

    @RequestMapping(value = "/changeCountOfBook", method = RequestMethod.POST)
    public ModelAndView changeCountOfBook(@RequestParam(value = "bookId", required = false) List<Integer> booksId,
                                          HttpSession session) {
        SQLiteDAO sqLiteDAO = (SQLiteDAO)session.getAttribute("sqliteDAO");
        List<Book> bookList = sqLiteDAO.getAllBooks();
        ModelAndView model = new ModelAndView("booksTable");
        if (booksId != null) {
            for (Book book : bookList) {
                if (booksId.contains(book.getId())) {
                    sqLiteDAO.changeCountOfBook(book.getId(),book.getCount() - 1);
                    book.setCount(book.getCount() - 1);
                }
            }
        }
        model.addObject("bookList", bookList);
        return model;
    }
}
