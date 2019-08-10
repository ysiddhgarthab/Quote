package com.khgears.quote.controller;
import java.util.List;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.khgears.quote.pojo.Quote;
import com.khgears.quote.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@RestController
public class QuoteController {
    @Autowired
    QuoteService quoteService;

    /*restful 部分*/
    @DS("sap")
    @GetMapping("/quote")
    public PageInfo<Object> list(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size,"docentry desc");
        List<Object> hs=quoteService.list();
        System.out.println(hs);

        PageInfo<Object> page = new PageInfo<>(hs,5); //5表示导航分页最多有5个，像 [1,2,3,4,5] 这样

        return page;
    }

    @GetMapping("/quote/{id}")
    public Quote get(@PathVariable("id") int id) throws Exception {
        System.out.println(id);
        Quote h=quoteService.get(id);
        System.out.println("执行了查询操作,查询id为"+id+"的数据");
        return h;
    }

    @PostMapping("/quote")
    public String add(@RequestBody Quote h) throws Exception {
        quoteService.add(h);
        System.out.println("执行了添加操作，添加对象为"+h);
        return "success";
    }

    @DeleteMapping("/quote/{id}")
    public String delete(Quote h) throws Exception {
        quoteService.delete(h.getId());
        System.out.println("执行了删除操作，删除id为"+h.getId()+"数据");
        return "success";
    }

    @PutMapping("/quote/{id}")
    public String update(@RequestBody Quote h) throws Exception {
        System.out.println("执行了更新操作，把id的为"+h.getId()+"的数据更新为"+h);
        quoteService.update(h);
        return "success";
    }

    /*页面跳转 部分*/
    @RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView listQuote(){
        ModelAndView mv = new ModelAndView("demo");
        return mv;
    }

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public ModelAndView editQuote(){
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }
}


