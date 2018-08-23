package com.library.controllers;


import com.library.dao.impls.SQLiteDAO;
import com.library.dao.objects.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminPageController {

    //TODO: command?
    @RequestMapping(value = "addBookPage", method = RequestMethod.GET)
    public ModelAndView getBookPage() {
        return new ModelAndView("addBook", "command", new Book());
    }

    //TODO: check that everything is not null
    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("bookName") String bookName,
                          @ModelAttribute("author") String authorName,
                          @ModelAttribute("genre") String genreName,
                          @ModelAttribute("value") int value,
                          @ModelAttribute("deposit") int deposit,
                          @ModelAttribute("count") int count,
                          HttpSession session) {
        SQLiteDAO sqLiteDAO = (SQLiteDAO) session.getAttribute("sqliteDAO");
        sqLiteDAO.addBook(bookName,authorName,genreName,value,deposit,count);
        return "adminPage";
    }

    @RequestMapping(value = "deleteBookPage", method = RequestMethod.GET)
    public String getDeleteBook() {
        return "deleteBook";
    }

    @RequestMapping(value = "/deleteBook", method = RequestMethod.POST)
    public String deleteBook(@ModelAttribute("bookId") int bookId,
                             HttpSession session) {
        SQLiteDAO sqLiteDAO = (SQLiteDAO) session.getAttribute("sqliteDAO");

        List<Book> bookList = sqLiteDAO.getAllBooks();
        for (Book book:bookList){
            if (book.getId() == bookId){
                bookList.remove(book);
            }
        }
        sqLiteDAO.removeBookById(bookId);

        return "adminPage";
    }

    @RequestMapping(value = "/booksTable", method = RequestMethod.GET)
    public String getTablePage(HttpSession session){
        return "booksTable";
    }





}
