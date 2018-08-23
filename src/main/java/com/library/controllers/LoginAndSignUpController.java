package com.library.controllers;

import com.library.dao.impls.SQLiteDAO;
import com.library.dao.objects.Book;
import com.library.dao.objects.Genre;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SessionAttributes("genres, reader")
public class LoginAndSignUpController {

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
        return model;
    }

    @RequestMapping(value = "check-reader", method = RequestMethod.POST)
    public ModelAndView checkReader(@ModelAttribute("readerName") String readerName,
                                    @ModelAttribute("password") String password,
                                    HttpSession session) {
        SQLiteDAO sqLiteDAO = (SQLiteDAO) session.getAttribute("sqliteDAO");

        ModelAndView model = new ModelAndView();
        if(sqLiteDAO.getAllReadersNames().contains(readerName)){
            model.setViewName("account");
            session.setAttribute("readerName", readerName);
            List<Book> bookList = sqLiteDAO.getBookListForReader(readerName);
            model.addObject("bookList",bookList);
        } else{
            model.setViewName("loginPage");
        }
        return model;
    }

    @RequestMapping(value = "signup", method = RequestMethod.GET)
    public String registerNewReader(){
        return "signupPage";
    }

    @RequestMapping(value = "register-new-reader", method = RequestMethod.POST)
    public String register(@ModelAttribute("readerName") String readerName,
                                 @ModelAttribute("readerPhone") String readerPhone,
                                 HttpSession session){
        SQLiteDAO sqLiteDAO = (SQLiteDAO) session.getAttribute("sqliteDAO");

        sqLiteDAO.addReader(readerName,readerPhone);

        return "startPage";
    }
}
