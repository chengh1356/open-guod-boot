package cn.hacz.edu.mapping.hql01;

/**
 * project -
 *
 * @author yanfa07
 * @version 1.0
 * @date 日期:2018/11/23 时间:21:10
 * @JDK 1.8
 * @Description 功能模块：
 */
public class MsgInfo {
    private int id;
    private String cont;
    private String topicName;
    private String categoryName;
    public MsgInfo(int id, String cont, String topicName, String categoryName) {
        super();
        this.id = id;
        this.cont = cont;
        this.topicName = topicName;
        this.categoryName = categoryName;
    }
    public String getTopicName() {
        return topicName;
    }
    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getCont() {
        return cont;
    }
    public void setCont(String cont) {
        this.cont = cont;
    }
}
