package com.qianfeng.search.listener;

import com.qianfeng.dao.TbItemCustomMapper;
import com.qianfeng.pojo.dto.TbSearchItemCustom;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ItemAddMessageListener implements MessageListener{
    @Autowired
    private TbItemCustomMapper itemCustomDao;
    @Autowired
    private SolrServer solrServer;

    @Override
    public void onMessage(Message message) {
        try {
            //获取信息
            TextMessage textMessage = (TextMessage) message;
            String text = textMessage.getText();
            //获取商品ID
            long itemId = Long.parseLong(text);

            //调用DAO层方法通过商品ID查询出该商品
            TbSearchItemCustom itemCustom = itemCustomDao.getItemCustomById(itemId);
            //TbSearchItemCustom--Document
            SolrInputDocument document = new SolrInputDocument();
            document.addField("id",itemCustom.getId());
            document.addField("item_title",itemCustom.getTitle());
            document.addField("item_sell_point",itemCustom.getSellPoint());
            document.addField("item_price",itemCustom.getPrice());
            document.addField("item_image",itemCustom.getImage());
            document.addField("item_category_name",itemCustom.getCatName());
            //写入索引库
            solrServer.add(document);
            //提交
            solrServer.commit();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
