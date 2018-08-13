package cn.hacz.edu.controller;

import cn.hacz.edu.entity.Article;
import org.bson.types.ObjectId;
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
        Article article = mongoTemplate.findAndRemove(query, Article.class);
    }

    @GetMapping(value = "/delete04Article")
    public void delete04Article() {
        //查询出符合条件的所有结果，并将符合条件的所有数据删除
        Query query = Query.query(Criteria.where("author").is("yinjihuan"));
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
        Update update = Update.update("title", "MongoTemplate").set("visitCount", 10);
        mongoTemplate.updateMulti(query, update, Article.class);
    }

    @GetMapping(value = "/update03Article")
    public void update03Article() {
        //特殊更新，更新author为jason的数据，如果没有author为jason的数据则以此条件创建一条新的数据
        //当没有符合条件的文档，就以这个条件和更新文档为基础创建一个新的文档，如果找到匹配的文档就正常的更新。
        Query query = Query.query(Criteria.where("author").is("jason"));
        Update update = Update.update("title", "MongoTemplate").set("visitCount", 10);
        mongoTemplate.upsert(query, update, Article.class);
    }

    @GetMapping(value = "/update04Article")
    public void update04Article() {
        //update的inc方法用于做累加操作，将money在之前的基础上加上100
        Query query = Query.query(Criteria.where("author").is("jason"));
        Update update = Update.update("title", "MongoTemplate").inc("money", 100);
        mongoTemplate.updateMulti(query, update, Article.class);
    }

    @GetMapping(value = "/update05Article")
    public void update05Article() {
        //update的rename方法用于修改key的名称
        Query query = Query.query(Criteria.where("author").is("jason"));
        Update update = Update.update("title", "MongoTemplate").rename("visitCount", "vc");
        mongoTemplate.updateMulti(query, update, Article.class);
    }

    @GetMapping(value = "/update06Article")
    public void update06Article() {
        //update的unset方法用于删除key
        Query query = Query.query(Criteria.where("author").is("jason"));
        Update update = Update.update("title", "MongoTemplate").unset("vc");
        mongoTemplate.updateMulti(query, update, Article.class);
    }

    @GetMapping(value = "/update07Article")
    public void update07Article() {
        //update的pull方法用于删除tags数组中的java
        Query query = Query.query(Criteria.where("author").is("yinjihuan"));
        Update update = Update.update("title", "MongoTemplate").pull("tags", "java");
        mongoTemplate.updateMulti(query, update, Article.class);
    }

    /**
     * 根据作者查询所有符合条件的数据，返回List
     */
    @GetMapping(value = "/select01Atricle")
    public void select01Atricle() {
        Query query = Query.query(Criteria.where("author").is("yinjihuan"));
        List<Article> articles = mongoTemplate.find(query, Article.class);
        System.out.println(articles);
    }

    /**
     * 只查询符合条件的第一条数据，返回Article对象
     */
    @GetMapping(value = "/select02Atricle")
    public void select02Atricle() {
        Query query = Query.query(Criteria.where("author").is("yinjihuan"));
        Article article = mongoTemplate.findOne(query, Article.class);
    }

    /**
     * 查询集合中所有数据，不加条件
     */
    @GetMapping(value = "/select03Atricle")
    public void select03Atricle() {
        List<Article> all = mongoTemplate.findAll(Article.class);
    }

    /**
     * 查询符合条件的数量
     */
    @GetMapping(value = "/select04Atricle")
    public void select04Atricle() {
        Query query = Query.query(Criteria.where("author").is("yinjihuan"));
        long count = mongoTemplate.count(query, Article.class);
    }

    /**
     * 根据主键ID查询
     */
    @GetMapping(value = "/select05Atricle")
    public void select05Atricle() {
        Article byId = mongoTemplate.findById(new ObjectId("57c6e1601e4735b2c306cdb7"), Article.class);
    }

    /**
     * in查询
     */
    @GetMapping(value = "/select06Atricle")
    public void select06Atricle() {
        List<String> authors = Arrays.asList("yinjihuan", "jason");
        Query query = Query.query(Criteria.where("author").in(authors));
        List<Article> articles = mongoTemplate.find(query, Article.class);
    }

    /**
     * ne（!=）查询
     */
    @GetMapping(value = "/select07Atricle")
    public void select07Atricle() {
        Query query = Query.query(Criteria.where("author").ne("yinjihuan"));
        List<Article> articles = mongoTemplate.find(query, Article.class);
    }

    /**
     * lt(<)查询访问量小于10的文章
     */
    @GetMapping(value = "/select08Atricle")
    public void select08Atricle() {
        Query query = Query.query(Criteria.where("visitCount").lt(10));
        List<Article> articles = mongoTemplate.find(query, Article.class);
    }

    /**
     * 范围查询，大于5小于10
     */
    @GetMapping(value = "/select09Atricle")
    public void select09Atricle() {
        Query query = Query.query(Criteria.where("visitCount").gt(5).lt(10));
        List<Article> articles = mongoTemplate.find(query, Article.class);
    }

    /**
     * 模糊查询，author中包含a的数据
     */
    @GetMapping(value = "/select10Atricle")
    public void select10Atricle() {
        Query query = Query.query(Criteria.where("author").regex("a"));
        List<Article> articles = mongoTemplate.find(query, Article.class);
    }

    /**
     * 数组查询，查询tags里数量为3的数据
     */
    @GetMapping(value = "/select11Atricle")
    public void select11Atricle() {
        Query query = Query.query(Criteria.where("tags").size(3));
        List<Article> articles = mongoTemplate.find(query, Article.class);
    }

    /**
     * or查询，查询author=jason的或者visitCount=0的数据
     */
    @GetMapping(value = "/select12Atricle")
    public void select12Atricle() {
        Query query = Query.query(Criteria.where("").orOperator(
                Criteria.where("author").is("jason"),
                Criteria.where("visitCount").is(0)));
        List<Article> articles = mongoTemplate.find(query, Article.class);
    }
}