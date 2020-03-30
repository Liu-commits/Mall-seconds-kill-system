package com.lyq.kill.model.dto;/**
 * Created by Administrator on 2020/5/21.
 */

import com.lyq.kill.model.entity.ItemKillSuccess;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author:lyq (SteadyJack)
 * @Date: 2020/5/21 22:02
 **/
@Data
public class KillSuccessUserInfo extends ItemKillSuccess implements Serializable{

    private String userName;

    private String phone;

    private String email;

    private String itemName;

    @Override
    public String toString() {
        return super.toString()+"\nKillSuccessUserInfo{" +
                "userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}