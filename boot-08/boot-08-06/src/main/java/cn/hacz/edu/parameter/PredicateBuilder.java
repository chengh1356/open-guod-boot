package cn.hacz.edu.parameter;

import java.util.ArrayList;
import java.util.List;

/**
 * ========================
 * Created with IntelliJ IDEA.
 *
 * @author guod
 * Date：2018/3/8
 * Time：13:41
 * Description：功能模块：
 * JDK：V1.8
 * GitHub地址：https://github.com/guod369
 * ========================
 */
public class PredicateBuilder {
    private List<Predicate> predicates = new ArrayList<Predicate>();

    public static PredicateBuilder create() {
        return new PredicateBuilder();
    }

    public PredicateBuilder add(String key, Object value, LinkEnum link) {
        predicates.add(new Predicate(key, value, link));
        return this;
    }

    public PredicateBuilder add(String key, Object value) {
        predicates.add(new Predicate(key, value));
        return this;
    }

    public List<Predicate> build() {
        return predicates;
    }
}
