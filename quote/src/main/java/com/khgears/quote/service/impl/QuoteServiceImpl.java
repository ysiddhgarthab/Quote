package com.khgears.quote.service.impl;

import com.khgears.quote.mapper.QuoteMapper;
import com.khgears.quote.pojo.Quote;
import com.khgears.quote.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService {
    @Autowired QuoteMapper quoteMapper;

    @Override
    public int add(Quote quote) {
        return quoteMapper.add(quote);
    }

    @Override
    public void delete(int id) {
       quoteMapper.delete(id);
    }

    @Override
    public Quote get(int id) {
        return quoteMapper.get(id);
    }

    @Override
    public int update(Quote quote) {
        return quoteMapper.update(quote);
    }

    @Override
    public List<Object> list() {
        return quoteMapper.list();
    }
}
