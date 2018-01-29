package com.qianfeng.service;

import com.qianfeng.pojo.po.TbContent;

import java.util.List;

public interface ContentService {

    List<TbContent> getContentListByCid(Long cid);
}
