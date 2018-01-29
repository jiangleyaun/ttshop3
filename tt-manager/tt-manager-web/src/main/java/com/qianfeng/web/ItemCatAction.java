package com.qianfeng.web;

import com.qianfeng.pojo.dto.TreeNode;
import com.qianfeng.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ItemCatAction {
    @Autowired
    private ItemCatService itemCatService;

    /*下拉框叶子结点*/
    @ResponseBody
    @RequestMapping(value = "/itemCat",method = RequestMethod.POST)
    public List<TreeNode> ListCatsByParentId(@RequestParam("parentId") Long parentId){
        List<TreeNode> list = null;
        try {
            list = itemCatService.listCatsByParentId(parentId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
