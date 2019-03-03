package cn.hacz.edu.base.vo;

import java.util.HashMap;

/**
 * project -
 *
 * @author yanfa07
 * @version 1.0
 * @date 日期:2019/2/28 时间:17:23
 * @JDK 1.8
 * @Description 功能模块：
 */
public class Data extends HashMap {
    public Data addObj(String key, Object value) {
        this.put(key, value);
        return this;
    }

    public Data addChat(String chat) {
        this.put("chat", chat);
        return this;
    }

    public Data addAmount(String amount) {
        this.put("amount", amount);
        return this;
    }

    public Data addOutTradeNo(String outTradeNo) {
        this.put("outTradeNo", outTradeNo);
        return this;
    }

    public Data addActualProfit(String actualProfit) {
        this.put("actualProfit", actualProfit);
        return this;
    }

    public Data addTradeStatus(String tradeStatus) {
        this.put("tradeStatus", tradeStatus);
        return this;
    }

    public Data addPresentGiftUuid(String presentGiftUuid) {
        this.put("presentGiftUuid", presentGiftUuid);
        return this;
    }
}
