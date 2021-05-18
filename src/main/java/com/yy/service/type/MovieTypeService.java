package com.yy.service.type;

import com.yy.pojo.Movie;
import com.yy.pojo.MovieType;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author yy
 * @date 2020/12/18/0018 11:04
 */
public interface MovieTypeService {

    List<MovieType> getMovieTypeList();

    MovieType getMovieType(String type);

    boolean deleteMovieTypeByType(String type);

    boolean addMovieType(String type);

    boolean updateMovieType(Integer id,String type);
}
