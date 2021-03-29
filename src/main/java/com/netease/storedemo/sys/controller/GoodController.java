package com.netease.storedemo.sys.controller;


import com.netease.storedemo.sys.domain.Good;
import com.netease.storedemo.sys.domain.Response;
import com.netease.storedemo.sys.service.IGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cys
 * @since 2021-03-22
 */
@RestController
@CrossOrigin
@RequestMapping("/sys")
public class GoodController {

    @Autowired
    private IGoodService goodService;
    /**
     * 功能描述:
     *  发布商品
     *
     * @Author:cysmbp15
     * @Date: 2021/3/25 4:36 下午
     */
    @RequestMapping(value = "/good", method = RequestMethod.POST)
    public Response create(@RequestBody Good good){
        System.out.println(System.getProperty("user.dir"));
        Response response = new Response();
        if (good.getGoodname()==null || good.getGoodname().length()<2 || good.getGoodname().length()>80){
            response.setStatus("500");
            response.setMsg("标题不符");
            return response;
        }
        if (good.getAbstracts()==null || good.getAbstracts().length()<2 || good.getAbstracts().length()>140){
            response.setStatus("500");
            response.setMsg("摘要不符");
            return response;
        }
        if (good.getDescription()==null || good.getDescription().length()<2 || good.getDescription().length()>1000){
            response.setStatus("500");
            response.setMsg("描述不符");
            return response;
        }

        if ( goodService.addOne(good)){
            good.setIsSold(0);
            response.setStatus("200");
            response.setStatus("success");
        }else{
           response.setStatus("500");
           response.setMsg("false");
        }
        return response;
    }
    /**
     * 功能描述:
     * 〈获取所有商品〉
     *
     * @Author:cysmbp15
     * @Date: 2021/3/25 4:36 下午
     */
    @RequestMapping(value = "/goods", method = RequestMethod.GET)
    public List<Good> getList(){
        List<Good> lists = goodService.getList();
        return lists;
    }
    /**
     * 功能描述:
     * 删除商品
     *
     * @Author:cysmbp15
     * @Date: 2021/3/25 4:36 下午
     */
    @RequestMapping(value = "/good", method = RequestMethod.DELETE)
    public Response delOne(int goodId){
        Response response = goodService.delOne(goodId);
        return response;
    }
    /**
     * 功能描述:
     * 获取单个商品
     * @Author:cysmbp15
     * @Date: 2021/3/25 4:37 下午
     */
    @RequestMapping(value = "/good", method = RequestMethod.GET)
    public Good getOne(@RequestParam(name = "id") int goodId) {
        return goodService.getOne(goodId);
    }


    /**
     * 功能描述:
     * 上传图片
     *
     * @Author:cysmbp15
     * @Date: 2021/3/25 4:37 下午
     */
    @RequestMapping("/addImg")
    @CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
    public String addImg(@RequestBody MultipartFile file, HttpServletRequest request, HttpServletResponse response)throws Exception{
        System.out.println("上传图片是否为空："+file.isEmpty());
        if(file != null){
            String path =null;// 文件路径
            String imgType=null;//图片类型
            String  fileName = file.getOriginalFilename();// 原文件名称
            String trueFileName = null;
            // 判断图片类型
            imgType=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
            if(imgType!=null){
                if("GIF".equals(imgType.toUpperCase()) || "PNG".equals(imgType.toUpperCase()) || "JPG".equals(imgType.toUpperCase())){
                    String realPath = System.getProperty("user.dir")+"/../FrontEnd/src/assets/";
                    trueFileName = String.valueOf(System.currentTimeMillis())+fileName;
                    // 设置图片存放的路径
                    path=realPath+trueFileName;
                    System.out.println("图片的存放路径为"+path);
                    // 转存文件到指定路径
                    file.transferTo(new File(path)); // 转存而不是写出
                    System.out.println("文件成功上传到指定目录下");
                }else{
                    System.out.println("请上传GIF、PNG或者JPG格式的文件");
                }
            }else{
                System.out.println("文件类型为空");
            }
            return trueFileName;
        }else{
            System.out.println("没有找到相对应的文件");
        }
        System.out.println("文件上传的原名称为:"+file.getOriginalFilename());

        return "";
    }
}
