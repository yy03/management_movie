package com.yy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 *
 * @author yy
 * @date 2020/12/15/0015 16:37
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private int id;
    private String name;
    private String type;
    private String synopsis;
    private String img;
    private String video;

}
