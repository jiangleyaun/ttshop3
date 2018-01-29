package com.qianfeng.dao;

import com.qianfeng.pojo.dto.Page;
import com.qianfeng.pojo.po.TbItemParam;
import com.qianfeng.pojo.vo.TbItemParamCustom;

import java.util.List;

public interface TbItemParamCustomMapper {

    Long countItemParams();

    List<TbItemParamCustom> listItemParamsByPage(Page page);

    TbItemParam getByItemCatId(Long cid);
}
