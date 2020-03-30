package com.lyq.kill.server.services;

/*
 * @Author LYQ
 * @Description //TODO 
 * @Date 17:05 2020/3/29
 * @Param 
 * @return 
 **/
public interface IKillService {

    Boolean killItem(Integer killId, Integer userId) throws Exception;

    Boolean killItemV2(Integer killId, Integer userId) throws Exception;

    Boolean killItemV3(Integer killId, Integer userId) throws Exception;

    Boolean killItemV4(Integer killId, Integer userId) throws Exception;

    Boolean killItemV5(Integer killId, Integer userId) throws Exception;
}
