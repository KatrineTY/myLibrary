package com.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccountController {

    @RequestMapping(value = "adminPage", method = RequestMethod.GET)
    public String getAdminPage(){
        return "adminPage";
    }

    @RequestMapping(value = "bookStorage", method = RequestMethod.GET)
    public String getBookStoragePage(){
        return "booksTable";
    }
}
