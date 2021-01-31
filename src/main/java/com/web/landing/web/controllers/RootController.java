package com.web.landing.web.controllers;

import com.web.landing.web.services.ApiService;
import com.web.landing.web.vos.ContactVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Controller
public class RootController {
    private final ApiService apiService;

    @Autowired
    public RootController(ApiService apiService) {
        this.apiService = apiService;
    }

    @RequestMapping(value = "/")
    public String index(HttpServletRequest request, HttpServletResponse response) {
        return "index";
    }

    @RequestMapping(value = "/contact", produces = MediaType.TEXT_PLAIN_VALUE)
    public void contact(HttpServletRequest request, HttpServletResponse response,
                        @RequestParam(name = "name", defaultValue = "") String name,
                        @RequestParam(name = "email", defaultValue = "") String email,
                        @RequestParam(name = "message", defaultValue = "") String message) throws IOException, SQLException {
        ContactVo contactVo = new ContactVo(name, email, message);
        this.apiService.contact(contactVo);
        response.getWriter().print("SENT_SUCCESS");
    }

}
