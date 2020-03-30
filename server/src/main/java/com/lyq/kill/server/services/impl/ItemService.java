package com.lyq.kill.server.services.impl;

import com.lyq.kill.model.entity.ItemKill;
import com.lyq.kill.model.mapper.ItemKillMapper;
import com.lyq.kill.server.services.IItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ItemService
 * @Description TODO
 * @Author LYQ
 * @Date 2020/3/29 10:17
 * @Version 1.0
 **/
@Service
public class ItemService implements IItemService {
    private static final Logger logger = LoggerFactory.getLogger(IItemService.class);
    @Autowired
    private ItemKillMapper itemKillMapper;
/**
 * @Author LYQ
 * @Description 获取待秒杀商品列表
 * @Date 10:26 2020/3/29
 * @Param []
 * @return java.util.List<com.lyq.kill.model.entity.ItemKill>
 **/
    @Override
    public List<ItemKill> getKillItems() throws Exception {
        
        return itemKillMapper.selectAll();
    }
    
    /**
     * @Author LYQ
     * @Description 获取秒杀详情
     * @Date 14:53 2020/3/29
     * @Param [id]
     * @return com.lyq.kill.model.entity.ItemKill
     **/
    @Override
    public ItemKill getKillDetail(Integer id) throws Exception {
        ItemKill itemKill = itemKillMapper.selectById(id);
        if (itemKill == null){
            throw new Exception("获取秒杀详情-秒杀记录不存在");
            
        }
        return itemKill;
    }
}
