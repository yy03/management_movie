package com.yy.dao.news;

import com.yy.pojo.Movie;
import com.yy.pojo.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author yy
 * @date 2020/12/20/0020 15:10
 */
public interface NewsMapper {

    List<News> getNewsByNameOrType(@Param("name") String name, @Param("type") String type);

    List<News> getNewsList();

    News getNewsById(Integer id);

    int deleteNewsById(@Param("id")Integer id);

    int addNews(News news);

    int updateNews(News news);

}
