package com.yy.service.Movie;

import com.yy.pojo.Movie;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author yy
 * @date 2020/12/16/0016 9:19
 */
public interface MovieService {

    List<Movie> getMovieList();

    List<Movie> getMovieByNameOrType(String name, String type);

    Movie getMovie(Integer id);

    boolean deleteMovieById(Integer id);

    boolean addMovie(Movie movie);

    boolean updateMovie(Movie movie);


}
