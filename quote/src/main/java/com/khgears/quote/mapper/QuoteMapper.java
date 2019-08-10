package com.khgears.quote.mapper;

import com.khgears.quote.pojo.Quote;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuoteMapper {
    public int add(Quote quote);
    public void delete(int id);
    public Quote get(int id);
    public int update(Quote quote);
    public List<Object> list();
}
