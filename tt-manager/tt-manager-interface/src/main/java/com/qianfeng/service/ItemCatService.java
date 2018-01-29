package com.qianfeng.service;

import com.qianfeng.pojo.dto.TreeNode;

import java.util.List;

public interface ItemCatService {
    /*下拉框叶子结点*/
    List<TreeNode> listCatsByParentId(Long parentId);
}
