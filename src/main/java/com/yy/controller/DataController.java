package com.yy.controller;


import com.yy.service.Movie.MovieService;
import com.yy.service.News.NewsService;
import com.yy.service.type.MovieTypeService;
import com.yy.service.type.NewTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class DataController {
    @Resource
    private MovieService movieService;
    @Resource
    private MovieTypeService movieTypeService;
    @Resource
    private NewsService newsService;
    @Resource
    private NewTypeService newTypeService;

    @RequestMapping("/getData")
    public String getData(Model model, HttpSession session) {
        int movie_number = movieService.getMovieList().size();
        int movieType_number = movieTypeService.getMovieTypeList().size();
        int news_number = newsService.getNewsList().size();
        int newsType_number = newTypeService.getNewTypeList().size();
        session.setAttribute("movie_number",movie_number);
        session.setAttribute("movieType_number",movieType_number);
        session.setAttribute("news_number",news_number);
        session.setAttribute("newsType_number",newsType_number);
        return "welcome";
    }
}
