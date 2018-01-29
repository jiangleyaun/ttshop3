package com.qianfeng.web;

import com.qianfeng.pojo.dto.MessageResult;
import com.qianfeng.service.ItemIndexServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemIndexAction {
    @Autowired
    private ItemIndexServer itemIndexServer;

    @ResponseBody
    @RequestMapping(value = "/item/index",method = RequestMethod.POST)
    public MessageResult itemIndex(){
        boolean bl = itemIndexServer.importAll();
        MessageResult messageResult =new MessageResult();
        messageResult.setSuccess(false);
        if(bl){
            messageResult.setSuccess(true);
            messageResult.setMessage("恭喜！导入成功！");
        }
        return messageResult;
    }
}
