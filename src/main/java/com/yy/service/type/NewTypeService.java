package com.yy.service.type;

import com.yy.pojo.Movie;
import com.yy.pojo.MovieType;
import com.yy.pojo.NewType;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author yy
 * @date 2020/12/18/0018 11:04
 */
public interface NewTypeService {

    List<NewType> getNewTypeList();

    NewType getNewType(String type);

    boolean deleteNewTypeById(Integer id);

    boolean addNewType(String newType);

    boolean updateNewType(String type,Integer id);
}
