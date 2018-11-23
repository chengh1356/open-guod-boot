package cn.hacz.edu.modules.sys.service;

import cn.hacz.edu.modules.test.vo.DetailReqVo;
import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * project -
 *
 * @author yanfa07
 * @version 1.0
 * @date 日期:2018/11/21 时间:17:11
 * @JDK 1.8
 * @Description 功能模块：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUser {
    RestTemplate restTemplate = new RestTemplate();

    @Before
    public void befort(){}

    @Test
    public void test2() {
        DetailReqVo dr = new DetailReqVo();
        dr.setZtType("C");
        dr.setToken("ae4ed3fdb37949e8bd84b6d2effb7c86");
        dr.setJcType("C");
        dr.setName("郑州川海娱乐有限公司");
        dr.setLoginName("szjfy001");
        System.out.println(JSON.toJSONString(dr));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> entity = new HttpEntity<>(dr, headers);
        String s = restTemplate.postForObject("http://www.zzcredit.gov.cn/credit-data-lhjc/api/detail.json", entity, String.class);
        System.out.println(s);
    }
}
