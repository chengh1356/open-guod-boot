package cn.hacz.edu.util;

import java.util.HashMap;

/**
 * project - GitHub整理
 *
 * @author dong
 * @version 1.0
 * @date 日期:2018/9/15 时间:18:41
 * @JDK 1.8
 * @Description 功能模块：
 */
public class MapUtils extends HashMap<String, Object> {
    @Override
    public MapUtils put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
