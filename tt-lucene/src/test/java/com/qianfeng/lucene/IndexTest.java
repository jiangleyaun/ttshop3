package com.qianfeng.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*public class IndexTest {

    @Test
    public void testCreateIndex() throws IOException {
        //采集原数据
        IBookDao bookDao = new BookDaoImpl();
        List<Book> bookList = bookDao.listBooks();
        //文档域 （文档域中存放的是一个个的文档document,一个document相当于表中一条记录）
        List<Document> documentList = new ArrayList<Document>();
        //将原数据中的Book对象转换Document对象
        for (Book book : bookList){
            Document document = new Document();
            //要不要分词：要不要拿这个字段搜索
            //要不要索引：要不要拿这个字段排序
            //要不要存储： 这个字段是否要存到document中
            //图书ID：不分词、要索引、要存储
            Field id = new StringField("id", book.getId().toString(), Field.Store.YES);
            //图书名称：要分词、要索引、要存储
            Field name = new TextField("name", book.getName(), Field.Store.YES);
            //图书价格：要分词、要索引、要存储
            Field price = new FloatField("price",book.getPrice(), Field.Store.YES);
            //图书图片地址：不分词、不索引、要存储
            Field pic = new StoredField("pic", book.getPic());
            //图片描述：要分词、要索引、要存储
            Field description = new TextField("description",book.getDescription(),Field.Store.YES);
            //将每一个Field添加文档中
            document.add(id);
            document.add(name);
            document.add(price);
            document.add(pic);
            document.add(description);
            //将每个document添加到文档域中
            documentList.add(document);
        }

        //可以使用中文分词器，也可以使用默认的分词器，默认的分词器对中文支持不好
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_4_10_3,analyzer);
        //指定索引库的地址
        File file = new File("d:/bookindex");
        Directory directory = FSDirectory.open(file);
        IndexWriter writer = new IndexWriter(directory,config);
        //遍历插入
        for (Document document:documentList){
            writer.addDocument(document);
        }
        //释放资源
        writer.close();
    }

    @Test
    public void testSearchIndex() throws ParseException, IOException {
        //分词器，
        QueryParser parser = new QueryParser("name",new StandardAnalyzer());
        Query query = parser.parse("name:java");
        //指定索引库的地址
        File indexFile = new File("d:/bookindex");
        FSDirectory directory = FSDirectory.open(indexFile);
        IndexReader reader = DirectoryReader.open(directory);
        IndexSearcher searcher = new IndexSearcher(reader);
        //搜索索引库的内容
        TopDocs topDocs = searcher.search(query,10);
        System.out.println("匹配的记录总数为："+topDocs.totalHits);
*//*        System.out.println(topDocs.scoreDocs);
        for (int i = 0;i<topDocs.scoreDocs.length;i++) {
            System.out.println(topDocs.scoreDocs[i]);
        }*//*
    }

    @Test
    public void testDeleteIndex() throws IOException {
        //创建分词器
        Analyzer analyzer = new StandardAnalyzer();
        //创建IndexWriterConfig
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_4_10_3,analyzer);
        //指定索引库地址
        File file = new File("d:/bookindex");
        Directory directory = FSDirectory.open(file);
        IndexWriter writer = new IndexWriter(directory,config);
        //指定删除的内容
*//*        Term term = new Term("name","solr");
        writer.deleteDocuments(term);*//*
        writer.deleteAll();
        writer.close();
    }

    @Test
    public  void tesUpdateIndex() throws IOException {
        //创建分词器
        Analyzer analyzer = new StandardAnalyzer();
        //创建IndexWriteConfig
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_4_10_3,analyzer);
        //指定索引地址
        File file = new File("d:/bookindex");
        Directory directory = FSDirectory.open(file);
        IndexWriter writer = new IndexWriter(directory,config);

        //
        Term term = new Term("name","solr");
        Document document = new Document();
        document.add(new StringField("name","java", Field.Store.YES));

        writer.updateDocument(term,document);
        writer.close();
    }
}*/
