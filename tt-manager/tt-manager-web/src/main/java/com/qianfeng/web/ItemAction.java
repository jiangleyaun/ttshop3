package com.qianfeng.web;


import com.qianfeng.pojo.dto.MessageResult;
import com.qianfeng.pojo.dto.Order;
import com.qianfeng.pojo.dto.Page;
import com.qianfeng.pojo.dto.Result;
import com.qianfeng.pojo.po.TbItem;
import com.qianfeng.pojo.utils.JsonUtils;
import com.qianfeng.pojo.vo.TbItemCustom;
import com.qianfeng.pojo.vo.TbItemQuery;
import com.qianfeng.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.jms.*;
import java.util.List;


@Controller
public class ItemAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ItemService itemService;

    @Autowired
    private JmsTemplate jmsTemplate;
    @Resource
    private Destination topicDestination;

    @ResponseBody
    @RequestMapping(value = "/item/{itemId}",method = RequestMethod.GET)
    public TbItem getItemById(@PathVariable("itemId") Long itemId){
        return itemService.getItemById(itemId);
    }

/*    @ResponseBody
    @RequestMapping(value = "/items",method = RequestMethod.POST)
    public List<TbItem> listItem(){
        List<TbItem> list = null;

        try{

            list = itemService.listItems();
            System.out.println(list);

        }catch (Exception e){

            logger.error(e.getMessage(),e);

            e.printStackTrace();
        }

        return list;
    }*/
    /*单表分页查询*/
/*    @ResponseBody
    @RequestMapping(value = "/items",method = RequestMethod.POST)
    public Result<TbItem> listItem(Page page){
        Result<TbItem> result = null;

        try{

            result = itemService.listItemByPage(page);

        }catch (Exception e){

            logger.error(e.getMessage(),e);

            e.printStackTrace();
        }

        return result;
    }*/

    /*两表连查分页*/
    @ResponseBody
    @RequestMapping(value = "/items",method = RequestMethod.GET)
    public Result<TbItemCustom> listItem(Page page, Order order,TbItemQuery query){
        Result<TbItemCustom> result = null;

        try{

            result = itemService.listItemByPage(page,order,query);

        }catch (Exception e){

            logger.error(e.getMessage(),e);

            e.printStackTrace();
        }

        return result;
    }

    /*批量删除*/
    @ResponseBody
    @RequestMapping(value = "/item/batch",method = RequestMethod.POST)
    public int batchUpdate(@RequestParam("ids[]") List<Long> ids){
        int i = 0;
        try{

            i = itemService.batchUpdate(ids);

        }catch (Exception e){

            logger.error(e.getMessage(),e);

            e.printStackTrace();
        }
        return  i;
    }
    /*批量上架*/
    @ResponseBody
    @RequestMapping(value = "/item/up",method = RequestMethod.POST)
    public int upUpdate(@RequestParam("ids[]") List<Long> ids){
        int i = 0;
        try{
            i = itemService.upUpdate(ids);
        }catch (Exception e){
            logger.error(e.getMessage(),e);

            e.printStackTrace();
        }
        return i;
    }
    /*批量下架*/
    @ResponseBody
    @RequestMapping(value = "/item/down",method = RequestMethod.POST)
    public int downUpdate(@RequestParam("ids[]") List<Long> ids){
        int i = 0;
        try{
            i = itemService.downUpdate(ids);
        }catch (Exception e){
            logger.error(e.getMessage(),e);

            e.printStackTrace();
        }
        return i;
    }
    /*新增*/
    @ResponseBody
    @RequestMapping(value = "/item",method = RequestMethod.POST)
    public MessageResult saveItem(TbItem item,String itemDesc,String paramData){
        MessageResult result = new MessageResult();
        try {
            //1 返回保存商品的ID
            //a action saveItem返回值 MessageResult
            /*i = itemService.saveItem(item,itemDesc,paramData);*/
            final Long itemId = itemService.saveItem(item,itemDesc,paramData);
            //2 发送消息（商品ID）
            //a jmsTemplate.send(目标对象，MessageCreator);
            if (itemId != null) {
                jmsTemplate.send(topicDestination, new MessageCreator() {
                    @Override
                    public Message createMessage(Session session) throws JMSException {
                        TextMessage message = session.createTextMessage(itemId + "");
                        return message;
                    }
                });
            }
            result.setSuccess(true);
            result.setMessage("新增商品成功！");
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        JsonUtils.objectToJson(result);
        return result;
    }

}
