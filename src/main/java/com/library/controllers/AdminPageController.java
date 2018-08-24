package com.library.controllers;


import com.library.dao.impls.SQLiteDAO;
import com.library.dao.objects.Book;
import com.library.dao.objects.Genre;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminPageController {

    @ModelAttribute
    public Book createNewBook(){
        return new Book();
    }

    //TODO: command?
    @RequestMapping(value = "addBookPage", method = RequestMethod.GET)
    public ModelAndView getBookPage() {
        return new ModelAndView("addBook", "command", new Book());
    }

    //TODO: check that everything is not null
    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public ModelAndView addBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult,
                         HttpSession session) {
        ModelAndView model = new ModelAndView();
        if(bindingResult.hasErrors()){
            model.setViewName("addBook");
        } else{
            SQLiteDAO sqLiteDAO = (SQLiteDAO) session.getAttribute("sqliteDAO");
            sqLiteDAO.addBook(book.getBookName(),book.getAuthor().getAuthorName(),
                    book.getGenre().getGenreName(),book.getValue(),book.getDeposit(),book.getCount());

            List<Genre> genres = sqLiteDAO.getAllGenres();
            session.setAttribute("listOfGenres", genres);
            model.setViewName("redirect:/adminPage");
        }
        return model;
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
