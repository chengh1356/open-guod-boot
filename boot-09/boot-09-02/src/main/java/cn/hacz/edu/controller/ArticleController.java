package cn.hacz.edu.controller;

import cn.hacz.edu.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * project - 综合客户服务系统
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/8/13 时间:15:59
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
public class ArticleController {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 功能描述：循环添加数据
     */
    @GetMapping(value = "/addArticle")
    public void addArticle() {
        // 循环添加
        for (int i = 0; i < 10; i++) {
            Article article = new Article();
            article.setTitle("MongoTemplate的基本使用");
            article.setAuthor("yinjihuan");
            article.setUrl("http://cxytiandi.com/blog/detail/" + i);
            article.setTags(Arrays.asList("java", "mongodb", "spring"));
            article.setVisitCount(0L);
            article.setAddTime(new Date());
            mongoTemplate.save(article);
        }
    }

    /**
     * 功能描述：批量操作
     */
    @GetMapping(value = "/addArticleList")
    public void addArticleList() {
        //批量添加
        List<Article> articles = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            Article article = new Article();
            article.setTitle("MongoTemplate的基本使用");
            article.setAuthor("yinjihuan");
            article.setUrl("http://cxytiandi.com/blog/detail/" + i);
            article.setTags(Arrays.asList("java", "mongodb", "spring"));
            article.setVisitCount(0L);
            article.setAddTime(new Date());
            articles.add(article);
        }
        mongoTemplate.insert(articles, Article.class);
    }

    @GetMapping(value = "/delete01Article")
    public void delete01Article() {
        //删除author为yinjihuan的数据
        Query query = Query.query(Criteria.where("author").is("yinjihuan"));
        mongoTemplate.remove(query, Article.class);
        //如果实体类中没配集合名词，可在删除的时候单独指定article_info
        query = Query.query(Criteria.where("author").is("yinjihuan"));
        mongoTemplate.remove(query, "article_info");
    }

    @GetMapping(value = "/delete02Article")
    public void delete02Article() {
        //删除集合，可传实体类，也可以传名称
        mongoTemplate.dropCollection(Article.class);
        mongoTemplate.dropCollection("article_info");
    }

    @GetMapping(value = "/delete03Article")
    public void delete03Article() {
        //查询出符合条件的第一个结果，并将符合条件的数据删除,只会删除第一条
        Query query = Query.query(Criteria.where("author").is("yinjihuan"));
        query = Query.query(Criteria.where("author").is("yinjihuan"));
        Article article = mongoTemplate.findAndRemove(query, Article.class);
    }

    @GetMapping(value = "/delete04Article")
    public void delete04Article() {
        //查询出符合条件的所有结果，并将符合条件的所有数据删除
        Query query = Query.query(Criteria.where("author").is("yinjihuan"));
        query = Query.query(Criteria.where("author").is("yinjihuan"));
        List<Article> articles = mongoTemplate.findAllAndRemove(query, Article.class);
    }

    @GetMapping(value = "/deleteDatabase")
    public void deleteDatabase() {
        //删除数据库
        mongoTemplate.getDb().drop();
    }

    @GetMapping(value = "/update01Article")
    public void update01Article() {
        //修改第一条author为yinjihuan的数据中的title和visitCount
        Query query = Query.query(Criteria.where("author").is("yinjihuan"));
        Update update = Update.update("title", "MongoTemplate").set("visitCount", 10);
        mongoTemplate.updateFirst(query, update, Article.class);
    }

    /**
     *
     */
    @GetMapping(value = "/update02Article")
    public void update02Article() {
        //修改全部符合条件的
        Query query = Query.query(Criteria.where("author").is("yinjihuan"));
        query = Query.query(Criteria.where("author").is("yinjihuan"));
        Update update = Update.update("title", "MongoTemplate").set("visitCount", 10);
        mongoTemplate.updateMulti(query, update, Article.class);
    }

    /**
     * =查询
     */
    @GetMapping(value = "/select01Atricle")
    public void select01Atricle() {
        Query query = Query.query(Criteria.where("author").is("yinjihuan"));
        List<Article> articles = mongoTemplate.find(query, Article.class);
        System.out.println(articles);
    }
}