package cn.hacz.edu.xmlvo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/8 时间:11:25
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HeadVo {
    private String meths = "meths";
    private String script = "script";
}
