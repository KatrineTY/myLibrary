package com.library.controllers;


import com.library.models.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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
    public String addBook(Book book) {
        BooksTableController.getBookList().add(book);
        return "adminPage";
    }

    @RequestMapping(value = "deleteBookPage", method = RequestMethod.GET)
    public String getDeleteBook() {
        return "deleteBook";
    }

    @RequestMapping(value = "/deleteBook", method = RequestMethod.POST)
    public String deleteBook(@ModelAttribute("bookName") String bookName) {
        List<Book> bookList = BooksTableController.getBookList();
        List<Book> toRemove = new ArrayList<>();
        for (Book book:bookList){
            if (book.getBookName().equals(bookName)){
                toRemove.add(book);
            }
        }
        bookList.removeAll(toRemove);
        return "adminPage";
    }

    @RequestMapping(value = "/booksTable", method = RequestMethod.GET)
    public String getTablePage(){
        return "booksTable";
    }

}
