package com.qianfeng.service.ipml;

import com.qianfeng.dao.TbContentMapper;
import com.qianfeng.pojo.jedis.JedisClient;
import com.qianfeng.pojo.po.TbContent;
import com.qianfeng.pojo.po.TbContentExample;
import com.qianfeng.pojo.utils.JsonUtils;
import com.qianfeng.pojo.utils.StrKit;
import com.qianfeng.service.ContentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TbContentMapper contentDao;
    @Autowired
    private JedisClient jedisClient;
    @Override
    public List<TbContent> getContentListByCid(Long cid) {
        //1.缓存中查询
        try{
            String listJson = jedisClient.hget("CONTENT_LIST", Long.toString(cid));
            if(StrKit.notBlank(listJson)){
                List<TbContent> contentList = JsonUtils.jsonToList(listJson, TbContent.class);
                return contentList;
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        //2.主业务，如果缓存中没有，在数据库中查询
            TbContentExample example = new TbContentExample();
            TbContentExample.Criteria criteria = example.createCriteria();
            criteria.andCategoryIdEqualTo(cid);
            List<TbContent> contentList = contentDao.selectByExample(example);
        //3.存入缓存
        try{
            jedisClient.hset("CONTENT_LIST",Long.toString(cid),JsonUtils.objectToJson(contentList));
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return contentList;
    }
}
