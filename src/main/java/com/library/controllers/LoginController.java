package com.library.controllers;

import com.library.dao.impl.SQLiteDAO;
import com.library.models.Reader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("genres, reader")
public class LoginController {

    @ModelAttribute
    public Reader createNewReader() {
        return new Reader();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(HttpSession session) {
        ModelAndView model = new ModelAndView("loginPage");
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        SQLiteDAO sqLiteDAO = (SQLiteDAO) context.getBean("sqliteDAO");
        session.setAttribute("sqliteDAO", sqLiteDAO);

        return model;
    }

    @RequestMapping(value = "check-reader", method = RequestMethod.POST)
    public ModelAndView checkReader(@ModelAttribute("readerName") String readerName,
                                    @ModelAttribute("password") String password) {
        ModelAndView model = new ModelAndView("adminPage");
//        if(getReadersNames().contains(readerName)){
//            model.setViewName("adminPage");
//        } else{
//            model.setViewName("loginPage");
//        }
        return model;
    }
}
