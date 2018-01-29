package com.qianfeng.service;


import com.qianfeng.pojo.dto.TbSearchItemResult;

public interface SearchService {
    TbSearchItemResult search(String keyword, Integer page, int i);
}
