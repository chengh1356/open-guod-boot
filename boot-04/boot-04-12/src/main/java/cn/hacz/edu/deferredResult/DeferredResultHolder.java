package cn.hacz.edu.deferredResult;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/12 时间:14:04
 * @JDK 1.8
 * @Description 功能模块：
 */
@Component
public class DeferredResultHolder {
    /**
     * 订单号-订单结果
     */
    private Map<String, DeferredResult<String>> map = new HashMap<>();

    public Map<String, DeferredResult<String>> getMap() {
        return map;
    }

    public void setMap(Map<String, DeferredResult<String>> map) {
        this.map = map;
    }
}
