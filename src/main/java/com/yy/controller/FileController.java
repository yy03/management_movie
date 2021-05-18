package com.yy.controller;

import com.yy.pojo.Movie;
import com.yy.service.Movie.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;

@Controller
public class FileController {
    @Resource
    private MovieService movieService;
    private Movie movie = new Movie();
    @RequestMapping("/pictureUpload")
    public String pictureUpload(@RequestParam("file") CommonsMultipartFile file , HttpServletRequest request, Model model) throws IOException {
        String uploadFileName = file.getOriginalFilename();
        int index = uploadFileName.indexOf(".");
        uploadFileName = uploadFileName.substring(index);
        Date date = new Date();
        uploadFileName = String.valueOf(date.getTime())+uploadFileName;
        if ("".equals(uploadFileName)){
            return "redirect:/index.jsp";
        }
        System.out.println("上传文件名 : "+uploadFileName);
        String path = request.getServletContext().getRealPath("/pictureUpload");
        System.out.println(path);
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }
        System.out.println("上传文件保存地址："+realPath);
        System.out.println(realPath.toString());
        movie.setImg("http://localhost:8080/pictureUpload/"+uploadFileName);
        InputStream is = file.getInputStream(); //文件输入流
        OutputStream os = new FileOutputStream(new
                File(realPath,uploadFileName)); //文件输出流
        int len=0;
        byte[] buffer = new byte[1024];
        while ((len=is.read(buffer))!=-1){
            os.write(buffer,0,len);
            os.flush();
        }
        os.close();
        is.close();
        return "redirect:/movieList.html";
    }

    @RequestMapping("/addMovie")
    public String AddMovie(String name,String type, String synopsis){
        movie.setName(name);
        movie.setSynopsis(synopsis);
        movie.setType(type);
        movieService.addMovie(movie);
        return "redirect:/movieList.html";
    }
    @RequestMapping("/videoUpload")
    public String videoUpload(@RequestParam("file") CommonsMultipartFile file , HttpServletRequest request, Model model) throws IOException {
        String uploadFileName = file.getOriginalFilename();
        int index = uploadFileName.indexOf(".");
        uploadFileName = uploadFileName.substring(index);
        Date date = new Date();
        uploadFileName = String.valueOf(date.getTime())+uploadFileName;
        if ("".equals(uploadFileName)){
            return "redirect:/index.jsp";
        }
        String path = request.getServletContext().getRealPath("/videoUpload");
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }
        System.out.println("上传文件保存地址："+realPath);
        movie.setVideo("http://localhost:8080/videoUpload/"+uploadFileName);
        InputStream is = file.getInputStream(); //文件输入流
        OutputStream os = new FileOutputStream(new
                File(realPath,uploadFileName)); //文件输出流
        int len=0;
        byte[] buffer = new byte[1024];
        while ((len=is.read(buffer))!=-1){
            os.write(buffer,0,len);
            os.flush();
        }
        os.close();
        is.close();
        return "redirect:/movieList.html";
    }
}

