package com.lyq.kill.server.services;

import com.lyq.kill.model.entity.ItemKill;

import java.util.List;

public interface IItemService {
    List<ItemKill> getKillItems() throws Exception;
    ItemKill getKillDetail(Integer id) throws Exception;
}
