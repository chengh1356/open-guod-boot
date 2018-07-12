package cn.hacz.edu.wriemock;

import com.github.tomakehurst.wiremock.client.WireMock;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/12 时间:21:51
 * @JDK 1.8
 * @Description 功能模块：
 */
public class MockServer {
    public static void main(String[] args) {
        WireMock.configureFor(8000);
        // 清空处理
        WireMock.removeAllMappings();
        WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo("/order/test"))
                .willReturn(WireMock.aResponse().withBodyFile("{\"id\":1}").withStatus(200)));
    }
}
