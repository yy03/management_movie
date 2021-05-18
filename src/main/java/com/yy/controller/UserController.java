package com.yy.controller;

import com.yy.dao.user.UserMapper;
import com.yy.pojo.User;
import com.yy.service.user.UserService;

import org.apache.ibatis.annotations.Param;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Created by IntelliJ IDEA.
 *
 * @author yy
 * @date 2020/12/15/0015 9:24
 */

@Controller
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    public UserService getUserService() {
        return userService;
    }
    @RequestMapping(value="/dologin.html",method= RequestMethod.POST)
    public String doLogin(@Param("username") String username, @Param("password") String password, HttpServletRequest request, HttpSession session) throws Exception{
        //调用service方法，进行用户匹配
        User user = userService.userLogin(username, password);
        if(null != user){
            session.setAttribute("userSession",user);
            return "index";
        }else{
            return "login";
        }
    }

    @RequestMapping("/updatePwd")
    public String updatePwd(@Param("pass") String pass,@Param("oldPwd")String oldPwd,@Param("username")String username, Model model){
        User user = userMapper.getLoginUser(username);
        if (!user.getPassword().equals(oldPwd)){
            model.addAttribute("msg","旧密码不正确");
            return "updatePassword";
        }else {
            userMapper.updatePassword(pass);
            boolean flag = true;
            model.addAttribute("msg",flag);
            return "";
        }
    }

    @RequestMapping("toUpdatePwd")
    public String toUpdatePwd(){
        return "updatePassword";
    }
}
