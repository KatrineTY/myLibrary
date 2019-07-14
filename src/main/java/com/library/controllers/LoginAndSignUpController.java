package com.library.controllers;

import com.library.dao.interfaces.LibraryDAO;
import com.library.dao.objects.Book;
import com.library.dao.objects.Genre;
import com.library.dao.objects.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes("genres, readerName")
public class LoginAndSignUpController {

    @Autowired
    private LibraryDAO libraryDAO;

    @ModelAttribute
    public Reader createReader() {
        return new Reader();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "startPage";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView login(HttpSession session) {
        ModelAndView model = new ModelAndView("loginPage");
        model.addObject("reader", createReader());
        return model;
    }

    @RequestMapping(value = "check-reader", method = RequestMethod.POST)
    public ModelAndView checkReader(@Valid @ModelAttribute("reader") Reader reader,
                                    BindingResult bindingResult,
                                    HttpSession session) {
        ModelAndView model = new ModelAndView();
//        if (!bindingResult.hasErrors() && libraryDAO.getAllReadersNames().contains(reader.getReaderName())) {
            model.setViewName("redirect:account");
            session.setAttribute("readerName", reader.getReaderName());
        List<Book> bookList = libraryDAO.getBookListForReader(reader.getReaderName());
            model.addObject("bookList", bookList);
        List<Genre> genres = libraryDAO.getAllGenres();
        session.setAttribute("listOfGenres", genres);
//        } else {
//            model.setViewName("loginPage");
//        }
        return model;
    }

    @RequestMapping(value = "account", method = RequestMethod.GET)
    private String getAccountPage() {
        return "account";
    }

    @RequestMapping(value = "signup", method = RequestMethod.GET)
    public String registerNewReader(HttpSession session) {
        return "signupPage";
    }

    @RequestMapping(value = "register-new-reader", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("readerName") String readerName,
                           @Valid @ModelAttribute("readerPhone") String readerPhone,
                           HttpSession session) {
        libraryDAO.addReader(readerName, readerPhone);
        return "startPage";
    }
}
