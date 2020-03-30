package com.lyq.kill.server.Controller;

import com.lyq.kill.model.entity.ItemKill;
import com.lyq.kill.server.services.IItemService;
import com.lyq.kill.server.services.impl.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @ClassName ItemController
 * @Description 待秒杀商品Controller
 * @Author LYQ
 * @Date 2020/3/29 9:56
 * @Version 1.0
 **/

@Controller
public class ItemController {
    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
    @Autowired
    private IItemService itemService;
    private static final String prefix = "item";
    /**
     * @Author LYQ
     * @Description 获取待秒杀商品列表 
     * @Date 10:08 2020/3/29
     * @Param [list]
     * @return void
     **/
    @RequestMapping(value = {"/","/index",prefix+"/list",prefix+"/index.html"},method = RequestMethod.GET)
    private String list(ModelMap modelMap){
        try {
            List<ItemKill> list = itemService.getKillItems();
            modelMap.put("list",list);
            logger.info("获取待秒杀商品列表-调试 ",list);
        }catch (Exception e){
            logger.error("发生异常！",e.fillInStackTrace());
            return "/error";
        }
        
        return "list";
    }
    
    @GetMapping(value = "/error")
    private String error(){
        return "error";
    }
    
    /**
     * @Author LYQ
     * @Description 获取待秒杀商品详情
     * @Date 14:48 2020/3/29
     * @Param [id]
     * @return java.lang.String
     **/
    @GetMapping(value = prefix+"/detail/{id}")
    private String detail(@PathVariable Integer id,ModelMap modelMap){
        if (id == null || id < 0){
            return "/error";
        }
        try{
            ItemKill detail = itemService.getKillDetail(id);
            modelMap.put("detail",detail);

        }catch (Exception e){
            logger.error("获取待秒杀商品详情-错误");
            return "/error";
        }
        return "info";
    }
}






















