package cn.hacz.edu.parameter;
import org.springframework.util.StringUtils;

import javax.persistence.Query;
/**
 * ========================
 * Created with IntelliJ IDEA.
 *
 * @author guod
 * Date：2018/3/8
 * Time：13:15
 * Description：功能模块：
 * JDK：V1.8
 * GitHub地址：https://github.com/guod369
 * ========================
 */
public enum LinkEnum {
    /**
     * 等于
     */
    EQ("="),
    /**
     * 大于等于
     */
    GE(">="),
    /**
     * 大于
     */
    GT(">"),
    /**
     * in
     */
    IN("IN"),
    /**
     * 需要手动在 value中添加 %
     */
    LIKE("LIKE"),
    /**
     * 小于等于
     */
    LE("<="),
    /**
     * 小于
     */
    LT("<"),
    /**
     * 不等于
     */
    NE("<>"),
    /**
     * not in
     */
    NIN("NOT IN"),
    /**
     * 为空 is null
     */
    EN("IS NULL"){
        @Override
        public String toCondition(String key,String index) {
            return key+" "+getName();
        }

        @Override
        public void setParameter(Predicate predicate, Query query,String index) {
            //do nothing
        }
    },
    /**
     * 不为空 is not null
     */
    NN("IS NOT NULL"){
        @Override
        public String toCondition(String key,String index) {
            return key+" "+getName();
        }

        @Override
        public void setParameter(Predicate predicate, Query query,String index) {
            //do nothing
        }
    };

    private String name;

    LinkEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toCondition(String key,String index){
        return key+" "+this.name+" :"+ (StringUtils.replace(key, ".", "_")+index);
    }

    public void setParameter(Predicate predicate, Query query,String index) {
        query.setParameter(StringUtils.replace(predicate.getKey() + index, ".", "_"),predicate.getValue());
    }
}
