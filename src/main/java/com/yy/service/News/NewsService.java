package com.yy.service.News;

import com.yy.pojo.Movie;
import com.yy.pojo.News;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author yy
 * @date 2020/12/20/0020 15:37
 */
public interface NewsService {

    List<News> getNewsList();

    List<News> getNewsByNameOrType(String name, String type);

    News getNews(Integer id);

    boolean deleteNewsById(Integer id);

    boolean addNews(News news);

    boolean updateNews(News news);
}
