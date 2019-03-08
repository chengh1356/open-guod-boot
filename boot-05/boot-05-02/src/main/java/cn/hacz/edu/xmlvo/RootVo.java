package cn.hacz.edu.xmlvo;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;


/**
 * project - GitHub整理 ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/8 时间:11:24
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@JacksonXmlRootElement(localName = "root")
@JsonPropertyOrder({"head", "body"})
public class RootVo {
    @JacksonXmlProperty(localName = "head")
    private HeadVo headVo = new HeadVo();
    @JacksonXmlProperty(localName = "body")
    private BodyVo bodyVo = new BodyVo();
}
