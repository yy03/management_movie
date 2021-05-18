package com.yy.dao.type;

import com.yy.pojo.MovieType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author yy
 * @date 2020/12/17/0017 10:15
 */
public interface MovieTypeMapper {
    MovieType getType(@Param("type") String type);

    List<MovieType> getTypeList();

    int deleteMovieTypeByType(@Param("type")String type);

    int addMovie(String type);

    int updateMovie(@Param("id") Integer id,@Param("type") String type);
}
