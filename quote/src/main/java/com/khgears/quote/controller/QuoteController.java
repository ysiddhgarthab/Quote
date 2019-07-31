package com.khgears.quote.controller;

import com.khgears.quote.pojo.Quote;
import com.khgears.quote.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class QuoteController {
    @Autowired
    QuoteService quoteService;

    @RequestMapping("/")
    public List<Quote> listQuote(){
        return quoteService.list();
    }
}
