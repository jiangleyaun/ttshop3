package com.qianfeng.service.ipml;

import com.qianfeng.dao.TbItemParamCustomMapper;
import com.qianfeng.dao.TbItemParamMapper;
import com.qianfeng.pojo.dto.Page;
import com.qianfeng.pojo.dto.Result;
import com.qianfeng.pojo.po.TbItemParam;
import com.qianfeng.pojo.vo.TbItemParamCustom;
import com.qianfeng.service.ItemParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemParamServiceImpl implements ItemParamService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbItemParamCustomMapper itemParamCustomDao;
    @Autowired
    private TbItemParamMapper tbItemParamMapper;
    @Override
    public Result<TbItemParamCustom> listItemParamsByPage(Page page) {
        Result<TbItemParamCustom>  result = new Result<TbItemParamCustom>();
        try {
            Long total = itemParamCustomDao.countItemParams();
            List<TbItemParamCustom> list =  itemParamCustomDao.listItemParamsByPage(page);
            result.setTotal(total);
            result.setRows(list);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }

        return result;
    }

    @Override
    public int saveItemParam(TbItemParam tbItemParam) {
        int i = 0;
        try {
            i = tbItemParamMapper.insert(tbItemParam);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return i;
    }

    @Override
    public TbItemParam getByItemCatId(Long cid) {
        TbItemParam tbItemParam = null;
        try {
            tbItemParam = itemParamCustomDao.getByItemCatId(cid);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return tbItemParam;
    }
}
