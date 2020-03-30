package com.lyq.kill.server.dto;/**
 * Created by Administrator on 2020/5/17.
 */

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author LYQ
 * @Description //TODO 
 * @Date 16:59 2020/3/29
 * @Param 
 * @return 
 **/
@Data
@ToString
public class KillDto implements Serializable{

    @NotNull
    private Integer killId;

    private Integer userId;
}