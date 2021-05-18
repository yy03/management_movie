package com.yy.dao.movie;

import com.yy.pojo.Movie;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author yy
 * @date 2020/12/15/0015 16:41
 */
public interface MovieMapper {

    int addMovie(Movie movie);
    int updateMovie(Movie movie);
    List<Movie> getMovieList();
    Movie getMovieById(Integer id);
    int deleteMovieById(@Param("id")Integer id);
    List<Movie> getMovieByNameOrType(@Param("name") String name,@Param("type") String type);

}
