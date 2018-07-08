package cn.hacz.edu.xmlvo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/8 时间:11:26
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BodyVo {
    @JacksonXmlProperty(isAttribute = true)
    private Integer size;
    @JacksonXmlProperty(isAttribute = true, localName = "class")
    private String classStr = "app";
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "div")
    private List<DivVo> divVoList = new ArrayList<>();
}
