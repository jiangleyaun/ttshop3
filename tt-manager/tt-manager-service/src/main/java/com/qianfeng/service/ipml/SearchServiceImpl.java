package com.qianfeng.service.ipml;


import com.qianfeng.dao.SearchDao;
import com.qianfeng.pojo.dto.TbSearchItemResult;
import com.qianfeng.service.SearchService;
import org.apache.solr.client.solrj.SolrQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SearchServiceImpl implements SearchService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SearchDao searchDao;

    @Override
    public TbSearchItemResult search(String keyword, Integer page, int i) {
        TbSearchItemResult result = null;
        try {
            //创建solr查询对象
            SolrQuery query = new SolrQuery();
            //1 设置查询的内容
            query.setQuery(keyword);
            //2 设置分页条件
            if (page <= 0) page = 1;
            query.setStart((page - 1) * i);
            query.setRows(i);
            //3 设置搜索域
            query.set("df","item_keywords");
            //4 设置高亮显示
            query.setHighlight(true);
            query.addHighlightField("item_title");
            query.setHighlightSimplePre("<em style='color:red;'>");
            query.setHighlightSimplePost("</em>");
            //通过查询条件执行DAO查询方法
            //recordCount,list
            result = searchDao.search(query);
            //计算总页数
            long recordCount = result.getRecordCount();
            int totalPages = ((int)recordCount+i-1)/i;
            result.setTotalPages(totalPages);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }
}
