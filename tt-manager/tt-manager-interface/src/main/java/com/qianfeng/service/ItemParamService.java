package com.qianfeng.service;

import com.qianfeng.pojo.dto.Page;
import com.qianfeng.pojo.dto.Result;
import com.qianfeng.pojo.po.TbItemParam;
import com.qianfeng.pojo.vo.TbItemParamCustom;

public interface ItemParamService {
    Result<TbItemParamCustom> listItemParamsByPage(Page page);

    int saveItemParam(TbItemParam tbItemParam);

    TbItemParam getByItemCatId(Long cid);
}
