package com.qianfeng.service.ipml;

import com.qianfeng.dao.TbItemCustomMapper;
import com.qianfeng.pojo.dto.TbSearchItemCustom;
import com.qianfeng.service.ItemIndexServer;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ItemIndexServerImpl implements ItemIndexServer {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TbItemCustomMapper tbItemCustomDao;
    @Autowired
    private SolrServer solrServer;
    @Override
    public boolean importAll() {
        List<TbSearchItemCustom> searchList = tbItemCustomDao.listSearchItems();
        //2 创建索引库
        // 遍历集合
        for (TbSearchItemCustom itemCustom : searchList){
            // 创建document
            SolrInputDocument document = new SolrInputDocument();
            // TbSearchItemCustom--SolrInputDocument
            document.addField("id",itemCustom.getId());
            document.addField("item_title",itemCustom.getTitle());
            document.addField("item_sell_point",itemCustom.getSellPoint());
            document.addField("item_price",itemCustom.getPrice());
            document.addField("item_image",itemCustom.getImage());
            document.addField("item_category_name",itemCustom.getCatName());
            //拿到装配好的document存放到索引库中
            try {
                solrServer.add(document);
            } catch (SolrServerException e) {
                logger.error(e.getMessage(),e);
                return false;
            } catch (IOException e) {
                logger.error(e.getMessage(),e);
                return false;
            }
        }
        // solrServer提交
        try {
            solrServer.commit();
        } catch (SolrServerException e) {
            logger.error(e.getMessage(),e);
            return false;
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
            return false;
        }
        return true;
    }
}
