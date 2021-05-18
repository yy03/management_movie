package com.yy.service.type;

import com.yy.dao.type.MovieTypeMapper;
import com.yy.pojo.Movie;
import com.yy.pojo.MovieType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author yy
 * @date 2020/12/18/0018 11:04
 */

@Service
public class MovieTypeServiceImpl implements MovieTypeService {

    @Resource
    private MovieTypeMapper movieTypeMapper;

    @Override
    public MovieType getMovieType(String type) {
        return movieTypeMapper.getType(type);
    }

    @Override
    public List<MovieType> getMovieTypeList() {
        return movieTypeMapper.getTypeList();
    }

    @Override
    public boolean addMovieType(String type) {
        boolean flag = false;
        if(movieTypeMapper.addMovie(type) > 0)
            flag = true;
        return flag;
    }

    @Override
    public boolean updateMovieType(Integer id,String type) {
        boolean flag = false;
        if(movieTypeMapper.updateMovie(id,type) > 0)
            flag = true;
        return flag;
    }

    @Override
    public boolean deleteMovieTypeByType(String type) {
        boolean flag = false;
        if(movieTypeMapper.deleteMovieTypeByType(type) > 0)
            flag = true;
        return flag;
    }


}
