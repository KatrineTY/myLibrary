package com.library.controllers;

import com.library.dao.impls.SQLiteDAO;
import com.library.dao.objects.Book;
import com.library.dao.objects.Genre;
import com.library.dao.objects.Reader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        SQLiteDAO sqLiteDAO = (SQLiteDAO) context.getBean("sqliteDAO");
        session.setAttribute("sqliteDAO", sqLiteDAO);
        List<Genre> genres = sqLiteDAO.getAllGenres();
        session.setAttribute("listOfGenres", genres);
        model.addObject("reader", createReader());
        return model;
    }

    @RequestMapping(value = "check-reader", method = RequestMethod.POST)
    public ModelAndView checkReader(@Valid @ModelAttribute("reader") Reader reader,
                                    BindingResult bindingResult,
                                    HttpSession session) {
        SQLiteDAO sqLiteDAO = (SQLiteDAO) session.getAttribute("sqliteDAO");

        ModelAndView model = new ModelAndView();

        if (!bindingResult.hasErrors() && sqLiteDAO.getAllReadersNames().contains(reader.getReaderName())) {
            model.setViewName("redirect:account");
            session.setAttribute("readerName", reader.getReaderName());
            List<Book> bookList = sqLiteDAO.getBookListForReader(reader.getReaderName());
            model.addObject("bookList", bookList);
        } else {
            model.setViewName("loginPage");
        }
        return model;
    }

    @RequestMapping(value = "account", method = RequestMethod.GET)
    private String getAccountPage() {
        return "account";
    }

    @RequestMapping(value = "signup", method = RequestMethod.GET)
    public String registerNewReader(HttpSession session) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        SQLiteDAO sqLiteDAO = (SQLiteDAO) context.getBean("sqliteDAO");
        session.setAttribute("sqliteDAO", sqLiteDAO);
        return "signupPage";
    }

    @RequestMapping(value = "register-new-reader", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("readerName") String readerName,
                           @Valid @ModelAttribute("readerPhone") String readerPhone,
                           HttpSession session) {
        SQLiteDAO sqLiteDAO = (SQLiteDAO) session.getAttribute("sqliteDAO");

        sqLiteDAO.addReader(readerName, readerPhone);

        return "startPage";
    }
}
