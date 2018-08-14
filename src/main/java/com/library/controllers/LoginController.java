package com.library.controllers;

import com.library.models.Reader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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
        List<String> genres = getGenres();
        session.setAttribute("listOfGenres", genres);
        return model;
    }

    private List<String> getGenres(){
        List<String> genres = new ArrayList<>();

        genres.add("genre1");
        genres.add("genre2");
        genres.add("genre3");
        genres.add("genre4");
        genres.add("genre5");
        return  genres;
    }

    private List<String> getReadersNames(){
        List<String> readers = new ArrayList<>();
        readers.add("reader1");
        readers.add("reader2");
        readers.add("reader3");
        readers.add("reader4");
        readers.add("reader5");
        return readers;
    }

    @RequestMapping(value = "check-reader",method = RequestMethod.POST)
    public ModelAndView checkReader(@ModelAttribute("readerName") String readerName,
                                    @ModelAttribute("password") String password) {
        ModelAndView model = new ModelAndView();
        if(getReadersNames().contains(readerName)){
            model.setViewName("adminPage");
        } else{
            model.setViewName("loginPage");
        }
        return model;
    }
}
