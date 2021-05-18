package com.yy.controller;

import com.yy.pojo.MovieType;
import com.yy.pojo.NewType;
import com.yy.service.type.NewTypeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author yy
 * @date 2020/12/18/0018 17:32
 */

@Controller
public class NewTypeController {
    @Resource
    private NewTypeService newTypeService;

    @RequestMapping("/updateNewTypePage")
    public String updateNewTypePage(@Param("id") Integer id,@Param("type") String type){
        newTypeService.updateNewType(type,id);
        return "redirect:/newTypeList";
    }

    @RequestMapping("/newTypeList")
    public String selectNewType(Model model,HttpServletRequest request, HttpSession session){
        List<NewType> newTypeList = newTypeService.getNewTypeList();
        session.setAttribute("newTypeList",newTypeList);
        model.addAttribute("newTypeList",newTypeList);
        return "newsType";
    }

    @RequestMapping("/toUpdateNewTypePage/{newType.id}")
    public String toUpdateNewTypePage(Model model,@PathVariable("newType.id") Integer id){
        model.addAttribute("id",id);
        return "updateNewsType";
    }
    @RequestMapping("/addNewType")
    public String addNewType(@Param("type") String type, HttpServletRequest request, HttpSession session){
        newTypeService.addNewType(type);
        return "redirect:/newTypeList";
    }
    @RequestMapping("selectNewTypeByType")
    public String selectNewTypeByType(@Param("type") String type,Model model){
        NewType newTypeList = newTypeService.getNewType(type);
        model.addAttribute("newTypeList",newTypeList);
        return "newsType";
    }

    @RequestMapping("/delNewType/{newType.id}")
    public String delNewType(@PathVariable("newType.id") Integer id){
        newTypeService.deleteNewTypeById(id);
        return "redirect:/newTypeList";
    }
}
