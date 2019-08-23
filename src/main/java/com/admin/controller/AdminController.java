package com.admin.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.admin.service.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myplay.model.AdminData;
import com.myplay.model.Category;
import com.myplay.model.Goods;
import com.myplay.model.GoodsType;
import com.myplay.model.Video;

@RequestMapping("/admin")
@RestController
public class AdminController {
    @Autowired
    private AdminService adminservice;
    
    //  视频管理*********************************************************************
    @ResponseBody
    @RequestMapping("/getvideolist")
    public AdminData getVideoList(Model model,@RequestParam(defaultValue="1",value="currentpage",required=false) Integer  currentpage){
        PageHelper.startPage(currentpage, 5);
        System.out.println(currentpage);
        List<Video> videoList = adminservice.getVideoList();
        PageInfo<Video> pageinfo = new PageInfo<Video>(videoList);
//        PageInfo pageinfo = new PageInfo(videoList, 3);
        return AdminData.success().add("pageinfo", pageinfo);
    }
    @ResponseBody
    @RequestMapping("/pass")
    public int pass(Integer videoid){
        return adminservice.pass(videoid);
    }
    
    @ResponseBody
    @RequestMapping("/notpass")
    public int notpass(Integer videoid){
        return adminservice.notpass(videoid);
    }
//    模糊查询
    @ResponseBody
    @RequestMapping("/search")
    public AdminData searchByWord(String searchword,@RequestParam(defaultValue="1",value="currentpage",required=false) Integer  currentpage){
        System.out.println(currentpage+searchword);
        PageHelper.startPage(currentpage, 5);
        List<Video> videoList = adminservice.searchByWord(searchword);
        PageInfo<Video> pageinfo = new PageInfo<Video>(videoList);
        return AdminData.success().add("pageinfo", pageinfo);
    }
    //获取视频类型
    @ResponseBody
    @RequestMapping("/getcategory")
    public List<Category> getcategory(){
        return adminservice.getvideocategory();
    }
    //类型查询
    @ResponseBody
    @RequestMapping("/searchbycategory")
    public AdminData searchByCategory(Integer categoryid,@RequestParam(defaultValue="1",value="currentpage",required=false) Integer  currentpage){
        PageHelper.startPage(currentpage, 5);
        List<Video> videoList = adminservice.searchByCategory(categoryid);
        PageInfo<Video> pageinfo = new PageInfo<Video>(videoList);
        return AdminData.success().add("pageinfo", pageinfo);
    }
    
    
    //  商品管理*********************************************************************
    @ResponseBody
    @RequestMapping("/getshoplist")
    public AdminData getShopList(@RequestParam(defaultValue="1",value="currentpage",required=false) Integer  currentpage){
        PageHelper.startPage(currentpage, 5);
        System.out.println(currentpage);
        List<Goods> videoList = adminservice.getShopList();
        PageInfo<Goods> pageinfo = new PageInfo<Goods>(videoList);
        return AdminData.success().add("pageinfo", pageinfo);
    }
    
    //获取视频类型
    @ResponseBody
    @RequestMapping("/getgoodtype")
    public List<GoodsType> getGoodType(){
        return adminservice.getGoodType();
    }
    //商品类型查询
    @ResponseBody
    @RequestMapping("/searchbyshopcategory")
    public AdminData searchByShopCategory(Integer categoryid,@RequestParam(defaultValue="1",value="currentpage",required=false) Integer  currentpage){
        PageHelper.startPage(currentpage, 5);
        List<Goods> goodList = adminservice.searchByShopCategory(categoryid);
        PageInfo<Goods> pageinfo = new PageInfo<Goods>(goodList);
        return AdminData.success().add("pageinfo", pageinfo);
    }
    //模糊查询
    @ResponseBody
    @RequestMapping("/searchshop")
    public AdminData searchShopByWord(String searchword,@RequestParam(defaultValue="1",value="currentpage",required=false) Integer  currentpage){
        PageHelper.startPage(currentpage, 5);
        List<Goods> goodList = adminservice.searchShopByWord(searchword);
        PageInfo<Goods> pageinfo = new PageInfo<Goods>(goodList);
        return AdminData.success().add("pageinfo", pageinfo);
    }
    //编辑商品
    @ResponseBody
    @RequestMapping("/editshop")
    public int editShop(Goods goods){
        return adminservice.editShop(goods);
    }
    //删除商品
    @ResponseBody
    @RequestMapping("/delgoodbyid")
    public int delShop(Integer goodid){
        return adminservice.delShop(goodid);
    }
    //添加商品
    @ResponseBody
    @RequestMapping("/addshop")
    public int addShop(Goods goods){
        return adminservice.addShop(goods);
    }
    //通过ID查商品
    @ResponseBody
    @RequestMapping("/getgoodbyid")
    public Goods getGoodById(Integer goodid){
        return adminservice.getGoodById(goodid);
    }
}