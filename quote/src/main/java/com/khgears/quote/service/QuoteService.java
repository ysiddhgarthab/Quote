package com.khgears.quote.service;

import com.khgears.quote.pojo.Quote;

import java.util.List;

public interface QuoteService {
    public int add(Quote quote);
    public void delete(int id);
    public Quote get(int id);
    public int update(Quote quote);
    public List<Object> list();
}
