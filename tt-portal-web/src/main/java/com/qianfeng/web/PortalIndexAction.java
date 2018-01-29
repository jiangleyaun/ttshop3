package com.qianfeng.web;

import com.qianfeng.pojo.po.TbContent;
import com.qianfeng.pojo.utils.PropKit;
import com.qianfeng.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PortalIndexAction {
    @Autowired
    private ContentService contentService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(Model model){
        List<TbContent> list = null;
        try {
            Long cid = PropKit.use("picture.properties").getLong("categoryId");
            list = contentService.getContentListByCid(cid);
            model.addAttribute("ad1List",list);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  "index";
    }
}
