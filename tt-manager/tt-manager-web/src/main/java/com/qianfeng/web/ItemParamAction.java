package com.qianfeng.web;

import com.qianfeng.pojo.dto.Page;
import com.qianfeng.pojo.dto.Result;
import com.qianfeng.pojo.po.TbItemParam;
import com.qianfeng.pojo.utils.IDUtils;
import com.qianfeng.pojo.vo.TbItemParamCustom;
import com.qianfeng.service.ItemParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class ItemParamAction {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ItemParamService itemParamService;
    /*两表联查*/
    @ResponseBody
    @RequestMapping(value = "itemParams",method = RequestMethod.GET)
    public Result<TbItemParamCustom> listItemParamsByPage(Page page){
        Result<TbItemParamCustom>  rs= null;
        try {
            rs = itemParamService.listItemParamsByPage(page);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return  rs;
    }
    /*保存参数*/
    @ResponseBody
    @RequestMapping(value = "/itemParam/{cid}",method = RequestMethod.POST)
    public int saveItemParam(@PathVariable("cid") Long cid, @RequestParam("paramData") String paramData){
        int i = 0;
        TbItemParam tbItemParam = new TbItemParam();
        try {
            int id = (int)IDUtils.getItemId();
            tbItemParam.setId((long)id);
            tbItemParam.setItemCatId(cid);
            tbItemParam.setCreated(new Date());
            tbItemParam.setUpdated(new Date());
            tbItemParam.setParamData(paramData);
            i = itemParamService.saveItemParam(tbItemParam);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return i;
    }
    @ResponseBody
    @RequestMapping(value = "/itemParam/{cid}",method = RequestMethod.GET)
    public TbItemParam getByItemCatId(@PathVariable("cid") Long cid){
        TbItemParam tbItemParam = null;
        try {
            tbItemParam = itemParamService.getByItemCatId(cid);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return tbItemParam;
    }
}
